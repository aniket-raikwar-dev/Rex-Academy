package com.example.rexacademy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {

    EditText reg_FullName, reg_Email, reg_Password, reg_ConfirmPassword;
    Button reg_Button;
    FirebaseAuth fAuth;



    TextView loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        reg_FullName = (EditText) findViewById(R.id.registerName);
        reg_Email = (EditText) findViewById(R.id.registerEmail);
        reg_Password = (EditText) findViewById(R.id.registerPassword);
        reg_ConfirmPassword = (EditText) findViewById(R.id.registerConfirmPassword);
        reg_Button = (Button) findViewById(R.id.registerButton);

        fAuth = FirebaseAuth.getInstance();

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.juntos);



        //--------------------------------------------------------------------------------
        // Direct goes to Login Activity
        loginButton = (TextView) findViewById(R.id.gotoLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(i);
            }
        });

        //----------------------------------------------------------------------------------




        reg_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Extract Data
                mediaPlayer.start();

                String fullName = reg_FullName.getText().toString();
                String email = reg_Email.getText().toString();
                String password = reg_Password.getText().toString();
                String confirmPassword = reg_ConfirmPassword.getText().toString();

                if(fullName.isEmpty()){
                    reg_FullName.setError("Please Enter Your Full Name");
                    return;
                }

                if(email.isEmpty()){
                    reg_Email.setError("Please Enter Your Valid Email Address");
                    return;
                }

                if(password.isEmpty()){
                    reg_Password.setError("Please Enter Your Password");
                    return;
                }

                if(confirmPassword.isEmpty()){
                    reg_ConfirmPassword.setError("Please Enter Your Confirm Password");
                    return;
                }

                if(!password.equals(confirmPassword)){
                    reg_ConfirmPassword.setError("Password Does Not Match !");
                    return;
                }

                // Data is Validated '
                // Register the User using FireBase.

                Toast.makeText(RegisterPage.this, "Data is Validated", Toast.LENGTH_SHORT).show();


                fAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //Send User to Next Page (Home Screen)
                        startActivity(new Intent(getApplicationContext(), VerifyMail.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(RegisterPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });




            }
        });
    }
}