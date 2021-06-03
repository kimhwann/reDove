package com.example.redoveapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    TextView outtv, logouttv;
    ImageView settingback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        outtv = (TextView) findViewById(R.id.outtv);
        outtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Withdrawal.class);
                startActivity(intent);
            }
        });

        final TextView logouttv = (TextView) findViewById(R.id.logouttv);
        logouttv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Setting.this, R.style.MyAlertDialogStyle);
                dlg.setTitle("로그아웃");
                dlg.setMessage("정말 로그아웃 하시겠나요?");
                //Typeface face = Typeface.createFromAsset(getAssets(), "font/nanumsquare_acb.ttf");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    }
                });

                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        settingback = (ImageView) findViewById(R.id.settingback);
        settingback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mypage.class);
                startActivity(intent);
            }
        });

    }
}