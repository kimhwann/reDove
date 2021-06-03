package com.example.redoveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Withdrawal2 extends AppCompatActivity {

    ImageView widhdrawal2back;
    Button widhdrawal2btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal2);

        widhdrawal2back = (ImageView) findViewById(R.id.widhdrawal2back);
        widhdrawal2back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Withdrawal.class);
                startActivity(intent);
            }
        });

        widhdrawal2btn = (Button) findViewById(R.id.withdrawal2btn);
        widhdrawal2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}