package com.example.crocodilemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class Splash extends Activity {

    private final int SPLASH_DISPLEY_LEHGHT = 5000;// время активити Splash 5000 ms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(intent);
                Splash.this.finish();

            }
        }, SPLASH_DISPLEY_LEHGHT);

    }

        @Override
    public void onBackPressed(){
        super.onBackPressed();

        }


}

