package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edPesan;
    private Button btnSendPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPesan = findViewById(R.id.ed_pesan);
        btnSendPesan = findViewById(R.id.btn_send_to_fragment);

        btnSendPesan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String pesan = edPesan.getText().toString();
//
//                if (pesan.equals("") || pesan == null) {
//                    pesan = "Pesan";
//                }

                // set pesan ke bundle dan mengirim ke fragment
                Bundle data = new Bundle();
                data.putString("key_pesan", pesan);
                FragmentSatu fragmentSatu = new FragmentSatu();
                fragmentSatu.setArguments(data);

                displayFragment(fragmentSatu);
            }
        });

    }

    public void displayFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}