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
import android.widget.Button;
import android.widget.ImageView;

import java.util.PrimitiveIterator;

public class Withdrawal2 extends Fragment {
    private View view;
    private ImageView widhdrawal2back;
    private Button withdrawal2btn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_withdrawal2, container, false);
        widhdrawal2back = view.findViewById(R.id.widhdrawal2back);
        widhdrawal2back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Withdrawal withdrawal = new Withdrawal();
                withdrawal.setArguments(bundle);
                transaction.replace(R.id.frameLayout, withdrawal);
                transaction.commit();
            }
        });

        withdrawal2btn = view.findViewById(R.id.withdrawal2btn);
        withdrawal2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });


        return view;
    }
}