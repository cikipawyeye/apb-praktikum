package com.example.datafakultas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHandler myDB;

    EditText edIdFak, edNameFak;
    Button btnInsert, btnUpdate, btnDelete, btnView;
    TextView labelFak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHandler(this);

        edIdFak = findViewById(R.id.txtIdFk);
        edNameFak = findViewById(R.id.txtNameFk);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnView = findViewById(R.id.btnView);
        labelFak = findViewById(R.id.datas);

        btnInsert.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        Fakultas newFakultas = new Fakultas();

        String idFak = edIdFak.getText().toString();
        String nameFak = edNameFak.getText().toString();

        newFakultas.setNamaFk(nameFak);
        newFakultas.setIdFk(idFak);

        FakultasHelper helper = new FakultasHelper(this);

        switch (btn.getId()) {
            case R.id.btnInsert:
                int resInsert = helper.insert(newFakultas);
                if (resInsert > 0) {
                    Toast.makeText(this, "Data berhasil disimpan.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Data gagal disimpan!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnUpdate:
                int resUpdate = helper.update(newFakultas);
                if (resUpdate > 0) {
                    Toast.makeText(this, "Data berhasil diubah.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Data gagal diubah!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnDelete:
                boolean resDelete = helper.delete(idFak);
                if (resDelete) {
                    Toast.makeText(this, "Data berhasil dihapus.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Data gagal dihapus!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnView:
                ArrayList<Fakultas> listOfFakultas = helper.getData();

                StringBuilder fakultasListData = new StringBuilder();

                int i = 1;
                for (Fakultas fak: listOfFakultas) {
                    fakultasListData.append(i + "\nKode Fakultas: " + fak.getIdFk() +
                            "\nNama Fakultas: " + fak.getNamaFk() + "\n");
                    i++;
                }
                labelFak.setText(fakultasListData);
                break;
        }
    }
}