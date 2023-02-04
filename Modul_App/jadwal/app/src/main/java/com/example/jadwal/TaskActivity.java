package com.example.jadwal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TaskActivity extends AppCompatActivity {
    TextView txtName, txtDate, txtDesc;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        setTitle("Task");

        Intent intent = getIntent();

        String id = intent.getStringExtra("id");

        initView();

        TaskHelper helper = new TaskHelper(this);
        Task task = helper.getTask(id);

        txtName.setText(task.getName());
        txtDate.setText(task.getDate());
        txtDesc.setText(task.getDesc());

        btnDelete.setOnClickListener(view -> {
            if (helper.delete(id)) {
                Toast.makeText(this, "Hapus data berhasil", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "Hapus data gagal!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initView() {
        txtName = findViewById(R.id.txtName);
        txtDate = findViewById(R.id.txtDate);
        txtDesc = findViewById(R.id.txtDesc);
        btnDelete = findViewById(R.id.btnDelete);
    }
}