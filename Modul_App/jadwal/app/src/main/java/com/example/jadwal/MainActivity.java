package com.example.jadwal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnHome, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, HomeFragment.class, null).commit();

        initView();

        btnHome.setOnClickListener(view -> {
            FragmentTransaction ft1 = fm.beginTransaction();
            ft1.replace(R.id.container, HomeFragment.class, null).commit();
        });

        btnAdd.setOnClickListener(view -> {
            FragmentTransaction ft2 = fm.beginTransaction();
            ft2.replace(R.id.container, AddFragment.class, null).commit();
        });

    }

    private void initView() {
        btnHome = findViewById(R.id.btnHome);
        btnAdd = findViewById(R.id.btnAdd);
    }


}