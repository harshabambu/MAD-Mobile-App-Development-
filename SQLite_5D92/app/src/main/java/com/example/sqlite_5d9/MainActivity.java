package com.example.sqlite_5d9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edtxt_roll, edtxt_name, edtxt_avg, edtxt_grade;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        edtxt_roll = findViewById(R.id.edtxt_roll);
        edtxt_name = findViewById(R.id.edtxt_name);
        edtxt_avg = findViewById(R.id.edtxt_avg);
        edtxt_grade = findViewById(R.id.edtxt_grade);

        Button btnInsert = findViewById(R.id.btn_insert);
        Button btnGet = findViewById(R.id.btn_get);
        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnDelete = findViewById(R.id.btn_delete);

        // Initialize SQLite helper
        dbHelper = new DatabaseHelper(this);

        // Set button click listeners
        btnInsert.setOnClickListener(v -> insertStudent());
        btnGet.setOnClickListener(v -> getStudent());
        btnUpdate.setOnClickListener(v -> updateStudent());
        btnDelete.setOnClickListener(v -> deleteStudent());
    }

    private void insertStudent() {
        String roll = edtxt_roll.getText().toString().trim();
        String name = edtxt_name.getText().toString().trim();
        String avg = edtxt_avg.getText().toString().trim();
        String grade = edtxt_grade.getText().toString().trim();

        if (roll.isEmpty() || name.isEmpty() || avg.isEmpty() || grade.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = new Student(roll, name, avg, grade);
        if (dbHelper.insertStudent(student)) {
            Toast.makeText(this, "Student Inserted", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Insertion Failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void getStudent() {
        String roll = edtxt_roll.getText().toString().trim();
        if (roll.isEmpty()) {
            Toast.makeText(this, "Please enter roll number", Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = dbHelper.getStudent(roll);
        if (student != null) {
            edtxt_name.setText(student.getName());
            edtxt_avg.setText(student.getAvg());
            edtxt_grade.setText(student.getGrade());
            Toast.makeText(this, "Student Found: " + student.getName(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No student found with roll: " + roll, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateStudent() {
        String roll = edtxt_roll.getText().toString().trim();
        String name = edtxt_name.getText().toString().trim();
        String avg = edtxt_avg.getText().toString().trim();
        String grade = edtxt_grade.getText().toString().trim();

        if (roll.isEmpty() || name.isEmpty() || avg.isEmpty() || grade.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = new Student(roll, name, avg, grade);
        if (dbHelper.updateStudent(student)) {
            Toast.makeText(this, "Student Updated", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteStudent() {
        String roll = edtxt_roll.getText().toString().trim();
        if (roll.isEmpty()) {
            Toast.makeText(this, "Please enter roll number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (dbHelper.deleteStudent(roll)) {
            Toast.makeText(this, "Student Deleted", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Deletion Failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        edtxt_roll.setText("");
        edtxt_name.setText("");
        edtxt_avg.setText("");
        edtxt_grade.setText("");
    }
}