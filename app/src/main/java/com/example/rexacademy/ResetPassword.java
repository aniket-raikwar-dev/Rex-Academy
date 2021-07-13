package com.example.rexacademy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetPassword extends AppCompatActivity {
    EditText reset_newPass, reset_ConfirmPass;
    Button reset_btn;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.juntos);

        reset_newPass = (EditText) findViewById(R.id.resetNewPassword);
        reset_ConfirmPass = (EditText) findViewById(R.id.resetConfirmPassword);
        reset_btn = (Button) findViewById(R.id.RestPasswordButton);

        user = FirebaseAuth.getInstance().getCurrentUser();



        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.start();

                if(reset_newPass.getText().toString().isEmpty()){
                    reset_newPass.setError("Required Field");
                    return;
                }

                if(reset_ConfirmPass.getText().toString().isEmpty()){
                    reset_ConfirmPass.setError("Password Must Be Required");
                    return;
                }

                if(!reset_newPass.getText().toString().equals(reset_ConfirmPass.getText().toString())){
                    reset_ConfirmPass.setError("Password Does Not Match");
                    return;
                }

                user.updatePassword(reset_newPass.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(ResetPassword.this, "Password Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), resetPopUpWindow.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ResetPassword.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}