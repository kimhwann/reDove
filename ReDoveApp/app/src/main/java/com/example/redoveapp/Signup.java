package com.example.redoveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.redoveapp.R.*;


public class Signup extends AppCompatActivity {
    private static final int POPUP1_ACTIVITY_REQUEST_CODE = 1;
    private static final int POPUP2_ACTIVITY_REQUEST_CODE = 2;

    private EditText nameet, departmentet, idet, pwet, emailet, phoneet;
    private Button signupbtn, btn1, btn2;

    ImageView signupback;
    CheckBox push_check, inform_check;

    private boolean popup1_shown = false;
    private boolean popup2_shown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_signup);

        nameet = findViewById(id.nameet);
        departmentet = findViewById(id.departmentet);
        idet = findViewById(id.idet);
        pwet = findViewById(id.pwet);
        emailet = findViewById(id.emailet);
        phoneet = findViewById(id.phoneet);
        signupbtn = findViewById(id.signupbtn);
        btn1 = findViewById(id.btn1);
        btn2 = findViewById(id.btn2);
        signupback = findViewById(id.signupback);
        inform_check = findViewById(id.inform_check);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Popup1.class);
                startActivityForResult(intent, POPUP1_ACTIVITY_REQUEST_CODE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Popup2.class);
                startActivityForResult(intent, POPUP2_ACTIVITY_REQUEST_CODE);
            }
        });

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
                String stu_name = nameet.getText().toString();
                String department = departmentet.getText().toString();
                String pw = pwet.getText().toString();
                String email = emailet.getText().toString();
                int stu_num = Integer.parseInt(idet.getText().toString());
                int phone = Integer.parseInt(phoneet.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Signup.this, Login.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "빈칸을 확인해주세요.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                SignupRequest signupRequest = new SignupRequest(stu_name,department,pw,email,stu_num,phone,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Signup.this);
                queue.add(signupRequest);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( resultCode == RESULT_OK ) {
            // get String data from Intent
            String returnString = data.getStringExtra(Intent.EXTRA_TEXT);
            if (requestCode == POPUP1_ACTIVITY_REQUEST_CODE) {
                popup1_shown = true;
            } else if (requestCode == POPUP2_ACTIVITY_REQUEST_CODE) {
                popup2_shown = true;
            }

            if ( popup1_shown && popup2_shown ) {
                inform_check.setChecked(true);
            }
        }
    }

    public void onCheckboxClicked(View view) {
        CheckBox checkBox = (CheckBox) view;
        boolean checked = checkBox.isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case id.inform_check:
                if ( checked ) {
                    if ( !popup1_shown || !popup2_shown ) {
                        MessageBox msgbox = new MessageBox("이용약관 및 개인정보 정책 내용을\n확인해주세요");
                        msgbox.show(getSupportFragmentManager(), "InformDialogFragment");
                        checkBox.setChecked(false);
                    }
                }
                else {
                }
                break;
            default:
                break;
        }
    }
}