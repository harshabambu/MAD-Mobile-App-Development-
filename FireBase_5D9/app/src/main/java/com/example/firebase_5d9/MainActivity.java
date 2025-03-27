package com.example.firebase_5d9;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText edtxt_roll, edtxt_name, edtxt_avg, edtxt_grade;
    FirebaseDatabase fdb;
    DatabaseReference studentRef; // Added DatabaseReference for better structure

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

        edtxt_roll = findViewById(R.id.edtxt_roll);
        edtxt_name = findViewById(R.id.edtxt_name);
        edtxt_avg = findViewById(R.id.edtxt_avg);
        edtxt_grade = findViewById(R.id.edtxt_grade);

        fdb = FirebaseDatabase.getInstance();
        studentRef = fdb.getReference("students"); // Changed to plural "students" for better naming
    }

    public void insertStudent(View v) {
        String roll = edtxt_roll.getText().toString();
        Student s = new Student(roll, edtxt_name.getText().toString(),
                edtxt_avg.getText().toString(),
                edtxt_grade.getText().toString());

        studentRef.child(roll).setValue(s)
                .addOnSuccessListener(unused ->
                        Toast.makeText(MainActivity.this, "Insertion Successful", Toast.LENGTH_LONG).show())
                .addOnFailureListener(e ->
                        Toast.makeText(MainActivity.this, "Insertion Failure: " + e.getMessage(), Toast.LENGTH_LONG).show());
    }

    // Added CRUD operations
    public void getStudent(View v) {
        String roll = edtxt_roll.getText().toString();
        studentRef.child(roll).get()
                .addOnSuccessListener(dataSnapshot -> {
                    if (dataSnapshot.exists()) {
                        Student s = dataSnapshot.getValue(Student.class);
                        if (s != null) {
                            edtxt_name.setText(s.getName());
                            edtxt_avg.setText(s.getAvg());
                            edtxt_grade.setText(s.getGrade());
                            Toast.makeText(MainActivity.this, "Student Found: " + s.getName(), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "No student found with Roll No: " + roll, Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(e ->
                        Toast.makeText(MainActivity.this, "Retrieval Failure: " + e.getMessage(), Toast.LENGTH_LONG).show());
    }

    public void updateStudent(View v) {
        String roll = edtxt_roll.getText().toString();
        Student s = new Student(roll, edtxt_name.getText().toString(),
                edtxt_avg.getText().toString(),
                edtxt_grade.getText().toString());

        studentRef.child(roll).setValue(s)
                .addOnSuccessListener(unused ->
                        Toast.makeText(MainActivity.this, "Update Successful", Toast.LENGTH_LONG).show())
                .addOnFailureListener(e ->
                        Toast.makeText(MainActivity.this, "Update Failure: " + e.getMessage(), Toast.LENGTH_LONG).show());
    }

    public void deleteStudent(View v) {
        String roll = edtxt_roll.getText().toString();
        studentRef.child(roll).removeValue()
                .addOnSuccessListener(unused ->
                        Toast.makeText(MainActivity.this, "Deletion Successful", Toast.LENGTH_LONG).show())
                .addOnFailureListener(e ->
                        Toast.makeText(MainActivity.this, "Deletion Failure: " + e.getMessage(), Toast.LENGTH_LONG).show());
    }
}