package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataList[] data = new DataList[5];

        data[0] = new DataList("Title 1", "$10", R.drawable.rgb);
        data[1] = new DataList("Title 2", "$10", R.drawable.rgb);
        data[2] = new DataList("Title 3", "$10", R.drawable.rgb);
        data[3] = new DataList("Title 4", "$10", R.drawable.rgb);
        data[4] = new DataList("Title 5", "$10", R.drawable.rgb);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyAdapterList adapter = new MyAdapterList(data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}