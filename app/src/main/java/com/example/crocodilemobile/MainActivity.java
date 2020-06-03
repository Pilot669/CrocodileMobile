package com.example.crocodilemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

    }
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Intent intent = new Intent(this, Page.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}