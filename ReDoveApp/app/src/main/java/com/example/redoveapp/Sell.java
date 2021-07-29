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
import android.widget.ImageView;

public class Sell extends Fragment {
    private View view;
    private ImageView sellback;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_sell, container, false);
        sellback = view.findViewById(R.id.sellback);
        sellback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Mypage mypage = new Mypage();
                mypage.setArguments(bundle);
                transaction.replace(R.id.frameLayout, mypage);
                transaction.commit();
            }
        });
        return view;
    }
}