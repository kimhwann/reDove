package com.example.redoveapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Category extends Fragment {
    private View view;
    private ImageView categoryback, clothes, bag, beauty, digital, book, etc;
    private SearchView search;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_category, container, false);
        categoryback = view.findViewById(R.id.categoryback);
        categoryback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Home home = new Home();
                home.setArguments(bundle);
                transaction.replace(R.id.frameLayout, home);
                transaction.commit();
            }
        });

        clothes = view.findViewById(R.id.clothes);
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Clothes clothes = new Clothes();
                clothes.setArguments(bundle);
                transaction.replace(R.id.frameLayout, clothes);
                transaction.commit();
            }
        });

        bag = view.findViewById(R.id.bag);
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Bag bag = new Bag();
                bag.setArguments(bundle);
                transaction.replace(R.id.frameLayout, bag);
                transaction.commit();
            }
        });

        beauty = view.findViewById(R.id.beauty);
        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Beauty beauty = new Beauty();
                beauty.setArguments(bundle);
                transaction.replace(R.id.frameLayout, beauty);
                transaction.commit();
            }
        });

        digital = view.findViewById(R.id.digital);
        digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Digital digital = new Digital();
                digital.setArguments(bundle);
                transaction.replace(R.id.frameLayout, digital);
                transaction.commit();
            }
        });

        book = view.findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Book book = new Book();
                book.setArguments(bundle);
                transaction.replace(R.id.frameLayout, book);
                transaction.commit();
            }
        });

        etc = view.findViewById(R.id.etc);
        etc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Etc etc = new Etc();
                etc.setArguments(bundle);
                transaction.replace(R.id.frameLayout, etc);
                transaction.commit();
            }
        });

        search = view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Search search = new Search();
                search.setArguments(bundle);
                transaction.replace(R.id.frameLayout, search);
                transaction.commit();
            }
        });



        return view;

    }

}