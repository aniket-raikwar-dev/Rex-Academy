package com.example.rexacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timer = new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (this){
                        wait(2000);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, LoginPage.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}