package com.example.listviewicon;

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

        Data[] data = new Data[] {
            new Data(R.drawable.java, "Java", "Ini adalah Java"),
                new Data(R.drawable.java, "Javva", "Ini adalah Javva"),
                new Data(R.drawable.java, "Jawa", "Ini adalah Jawa"),
                new Data(R.drawable.java, "Kunci", "Jawa Adalah Kunci"),
                new Data(R.drawable.java, "Javanese", "Javanese hood"),
                new Data(R.drawable.java, "Jawir", "Black Java"),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyAdapterList adapter = new MyAdapterList(data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }
}