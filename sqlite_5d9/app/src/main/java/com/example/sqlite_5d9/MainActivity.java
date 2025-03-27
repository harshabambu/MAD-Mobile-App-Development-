package com.example.sqlite_5d9;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private StudentGradeDB sgdb;
    private EditText rollno, name, avg, grade;

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

        sgdb = new StudentGradeDB(this);
        rollno = findViewById(R.id.edttxt_roll);
        name = findViewById(R.id.edttxt_name);
        avg = findViewById(R.id.edttxt_avg);
        grade = findViewById(R.id.edttxt_grade);
    }

    public void insertStudent(View v) {
        try {
            int rno = Integer.parseInt(rollno.getText().toString().trim());
            String nams = name.getText().toString().trim();
            float avrg = Float.parseFloat(avg.getText().toString().trim());
            String grd = grade.getText().toString().trim();
            Student s = new Student(rno, nams, avrg, grd);
            sgdb.addStudent(s);
            Toast.makeText(this, "Insertion successful", Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_LONG).show();
        }
    }

    public void getStudent(View v) {
        try {
            int rno = Integer.parseInt(rollno.getText().toString().trim());
            String result = sgdb.getStudent(rno);
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Enter a valid roll number", Toast.LENGTH_LONG).show();
        }
    }

    public void updateStudent(View v) {
        try {
            int rno = Integer.parseInt(rollno.getText().toString().trim());
            String nams = name.getText().toString().trim();
            float avrg = Float.parseFloat(avg.getText().toString().trim());
            String grd = grade.getText().toString().trim();
            Student s = new Student(rno, nams, avrg, grd);
            sgdb.updateStudent(s);
            Toast.makeText(this, "Update successful", Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteStudent(View v) {
        try {
            int rno = Integer.parseInt(rollno.getText().toString().trim());
            sgdb.deleteStudent(rno);
            Toast.makeText(this, "Deletion successful", Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Enter a valid roll number", Toast.LENGTH_LONG).show();
        }
    }
}