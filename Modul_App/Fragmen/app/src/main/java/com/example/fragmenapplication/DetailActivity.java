package com.example.fragmenapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView detailPesan = findViewById(R.id.detail_pesan);
        String pesan = getIntent().getStringExtra("key_pesan");
        detailPesan.setText(pesan);
    }
}