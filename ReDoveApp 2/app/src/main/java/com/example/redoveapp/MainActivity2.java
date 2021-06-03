package com.example.redoveapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Home home = new Home();
    private Category category = new Category();
    private Chatting chatting = new Chatting();
    private Mypage mypage = new Mypage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, home).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_1: {
                        transaction.replace(R.id.frameLayout, home).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_2: {
                        transaction.replace(R.id.frameLayout, category).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_3: {
                        transaction.replace(R.id.frameLayout, chatting).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_4: {
                        transaction.replace(R.id.frameLayout, mypage).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });
    }
}