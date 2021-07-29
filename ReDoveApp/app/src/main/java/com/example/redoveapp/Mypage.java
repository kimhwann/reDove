package com.example.redoveapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Mypage extends Fragment {
    private View view;
    private Button profile;
    private ImageView sell, buy, heart;
    private TextView confirm, setting, notify;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_mypage, container, false);
        profile = view.findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Profile profile = new Profile();
                profile.setArguments(bundle);
                transaction.replace(R.id.frameLayout, profile);
                transaction.commit();
            }
        });

        sell = view.findViewById(R.id.sell);
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Sell sell = new Sell();
                sell.setArguments(bundle);
                transaction.replace(R.id.frameLayout, sell);
                transaction.commit();
            }
        });

        buy = view.findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Buy buy = new Buy();
                buy.setArguments(bundle);
                transaction.replace(R.id.frameLayout, buy);
                transaction.commit();
            }
        });

        heart = view.findViewById(R.id.heart);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Heart heart = new Heart();
                heart.setArguments(bundle);
                transaction.replace(R.id.frameLayout, heart);
                transaction.commit();
            }
        });

        setting = view.findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
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


        return view;
    }
}