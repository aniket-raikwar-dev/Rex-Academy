package com.example.rexacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class resetPopUpWindow extends AppCompatActivity {
    Button login_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pop_up_window);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.juntos);

        login_Button = (Button) findViewById(R.id.login_fromResetActivity);

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                startActivity(new Intent(getApplicationContext(), Home.class));
                finish();
            }
        });
    }
}