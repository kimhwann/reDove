package com.example.redoveapp;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Withdrawal extends Fragment {
    private View view;
    private ImageView widhdrawalback;
    private Button widhdrawalbtn1, widhdrawalbtn2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_withdrawal, container, false);
        widhdrawalback = view.findViewById(R.id.widhdrawalback);
        widhdrawalback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Setting setting = new Setting();
                setting.setArguments(bundle);
                transaction.replace(R.id.frameLayout, setting);
                transaction.commit();
            }
        });

        widhdrawalbtn1 = view.findViewById(R.id.widhdrawalbtn1);
        widhdrawalbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Setting setting = new Setting();
                setting.setArguments(bundle);
                transaction.replace(R.id.frameLayout, setting);
                transaction.commit();
            }
        });

        widhdrawalbtn2 = view.findViewById(R.id.widhdrawalbtn2);
        widhdrawalbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Withdrawal2 withdrawal2 = new Withdrawal2();
                withdrawal2.setArguments(bundle);
                transaction.replace(R.id.frameLayout, withdrawal2);
                transaction.commit();
            }
        });

        return view;

    }
}