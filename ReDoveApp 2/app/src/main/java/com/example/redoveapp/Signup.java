package com.example.redoveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Signup extends AppCompatActivity {
    private EditText nameet, idet, pwet, emailet, phoneet;
    private Button signupbtn, btn1, btn2;
    private ImageView signupback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameet = findViewById(R.id.nameet);
        idet = findViewById(R.id.idet);
        pwet = findViewById(R.id.pwet);
        emailet = findViewById(R.id.emailet);
        phoneet = findViewById(R.id.phoneet);
        signupbtn = findViewById(R.id.signupbtn);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        signupback = findViewById(R.id.signupback);

        signupback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText에 현재 입력되어있는 값을 get해온다.
                String stu_name = nameet.getText().toString();
                String pw= pwet.getText().toString();
                String email= emailet.getText().toString();
                int stu_num = Integer.parseInt(idet.getText().toString());
                int phone = Integer.parseInt(phoneet.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {//회원가입에 성공한 경우
                                Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Signup.this, Login.class);
                                startActivity(intent);
                            } else {//회원가입에 실패한 경우
                                Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                SignupRequest signupRequest = new SignupRequest(stu_name,pw,email,stu_num,phone, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Signup.this);
                queue.add(signupRequest);
            }
        });


    }
}