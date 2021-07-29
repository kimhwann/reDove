package com.example.redoveapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Setting extends Fragment {
    private View view;
    private ImageView settingback;
    private TextView logouttv, outtv;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_setting, container, false);

        settingback = view.findViewById(R.id.settingback);
        settingback.setOnClickListener(new View.OnClickListener() {
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

        logouttv = view.findViewById(R.id.logouttv);
        logouttv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle);
                dlg.setTitle("로그아웃");
                dlg.setMessage("정말 로그아웃 하시겠나요?");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), Login.class);
                        startActivity(intent);
                    }
                });

                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        outtv = view.findViewById(R.id.outtv);
        outtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Withdrawal withdrawal= new Withdrawal();
                withdrawal.setArguments(bundle);
                transaction.replace(R.id.frameLayout, withdrawal);
                transaction.commit();
            }
        });

        return view;

    }
}