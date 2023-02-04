package com.example.jadwal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        EditText edName, edDesc;
        DatePicker edDate;
        Button btnSave;

        edName = view.findViewById(R.id.edName);
        edDate = view.findViewById(R.id.edDate);
        edDesc = view.findViewById(R.id.edDesc);
        btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(view1 -> {
            Task task = new Task();

            if (edName.getText().toString().equals("") || edDesc.getText().toString().equals("")) {
                Toast.makeText(getContext(), "Insert data!", Toast.LENGTH_LONG).show();
                return;
            }

            task.setName(edName.getText().toString());
            task.setDate(edDate.getDayOfMonth() + "/" + (edDate.getMonth() + 1) + "/" + edDate.getYear());
            task.setDesc(edDesc.getText().toString());

            TaskHelper db = new TaskHelper(getContext());
            if (db.insert(task) > 0) {
                Toast.makeText(getContext(), "Insert success!", Toast.LENGTH_LONG).show();
                edName.setText("");
                edDesc.setText("");
            } else {
                Toast.makeText(getContext(), "Insert failed!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}