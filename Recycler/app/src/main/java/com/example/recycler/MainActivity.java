package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycler.Department;
import com.example.recycler.DepartmentAdaptor;
import com.example.recycler.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Department> depts = new ArrayList<>();
        depts.add(new Department(R.drawable.cse, "CSE", "210"));
        depts.add(new Department(R.drawable.ece, "ECE", "140"));
        depts.add(new Department(R.drawable.eee, "EEE", "70"));
        rcv = (RecyclerView) this.findViewById(R.id.rcv);
        rcv.setAdapter(new DepartmentAdaptor(getApplicationContext(), depts));
        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}