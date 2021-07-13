package com.example.rexacademy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class VerifyMail extends AppCompatActivity {
    TextView head_1, head_2, head_3, head_4;
    Button verifyMail;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_mail);

        head_1 = (TextView) findViewById(R.id.just);
        head_2 = (TextView) findViewById(R.id.verify);
        head_3 = (TextView) findViewById(R.id.please);
        head_4 = (TextView) findViewById(R.id.sent);

        verifyMail = (Button) findViewById(R.id.verifyMail_Button);
        auth = FirebaseAuth.getInstance();

        if(!auth.getCurrentUser().isEmailVerified()){
            verifyMail.setVisibility(View.VISIBLE);
            head_1.setVisibility(View.VISIBLE);
            head_2.setVisibility(View.VISIBLE);
            head_3.setVisibility(View.VISIBLE);
            head_4.setVisibility(View.GONE);
        }

        verifyMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send Verification Email
                auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(VerifyMail.this, "Verification Mail is Sent.", Toast.LENGTH_SHORT).show();
                        verifyMail.setVisibility(View.GONE);
                        head_1.setVisibility(View.VISIBLE);
                        head_2.setVisibility(View.VISIBLE);
                        head_3.setVisibility(View.VISIBLE);
                        head_4.setVisibility(View.VISIBLE);
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(getApplicationContext(), LoginPage.class));
                        finish();


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(VerifyMail.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(getApplicationContext(), RegisterPage.class));
                        finish();

                    }
                });
            }
        });
    }
}