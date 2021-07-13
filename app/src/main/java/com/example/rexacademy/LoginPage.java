package com.example.rexacademy;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    EditText log_Email, log_Password;
    Button log_Button;
    FirebaseAuth firebaseAuth;

    TextView RegisterButton;
    TextView forgetButton;
    AlertDialog.Builder reset_alert;
    LayoutInflater inflater;

    Button googleSignButton;
    GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);



        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.juntos);

        firebaseAuth = FirebaseAuth.getInstance();

        forgetButton = (TextView) findViewById(R.id.forgetPassword);

        RegisterButton = (TextView) findViewById(R.id.gotoRegister);

        googleSignButton = (Button) findViewById(R.id.googleSignButton);

        reset_alert = new AlertDialog.Builder(this);

        inflater = this.getLayoutInflater();


        //-----------------------------------------------------------------------------------

        //Forget Button Activity
        forgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start Alert Dialog
                final View view = inflater.inflate(R.layout.reset_pop, null);
                reset_alert.setTitle("Forgot Password ?")
                        .setMessage("Enter Your Email Address to Get Reset Password Link.")
                        .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Validate the Email Address
                                EditText email = view.findViewById(R.id.reset_mail_pop);
                                if(email.getText().toString().isEmpty()){
                                    email.setError("Required");
                                    return;
                                }

                                // Send the Reset Link
                                firebaseAuth.sendPasswordResetEmail(email.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(LoginPage.this, "Reset Email Link Sent", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), forgetPasswordSentLink.class));
                                        finish();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(LoginPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                    }
                                });




                            }
                        }).setNegativeButton("Cancel", null)
                        .setView(view)
                        .create().show();
            }
        });



        //-------------------------------------------------------------------------------------
        // Direct Goes to Register Page
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(myIntent);
            }
        });

        //--------------------------------------------------------------------------------------



        //--------------------------------------------------------------------------------------


        log_Email = (EditText) findViewById(R.id.loginEmail);
        log_Password = (EditText) findViewById(R.id.loginPassword);
        log_Button = (Button) findViewById(R.id.loginButton);


        log_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract the Data  // Validate the Data
                mediaPlayer.start();

                if(log_Email.getText().toString().isEmpty()){
                    log_Email.setError("Please Enter Correct Email");
                    return;
                }

                if(log_Password.getText().toString().isEmpty()){
                    log_Password.setError("Please Enter Valid Password");
                    return;
                }


                // Date is Validate
                // Login the User

                firebaseAuth.signInWithEmailAndPassword(log_Email.getText().toString(), log_Password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        // Login is SuccessFull

                        startActivity(new Intent(getApplicationContext(), Home.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(LoginPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });



    }



    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }
    }

}