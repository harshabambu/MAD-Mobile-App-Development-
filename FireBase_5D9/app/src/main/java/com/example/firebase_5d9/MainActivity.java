package com.example.firebase_5d9;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    EditText edtxt_roll,edtxt_name,edtxt_avg,edtxt_grade;
    FirebaseDatabase fdb;

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
        edtxt_roll=(EditText) this.findViewById(R.id.edtxt_roll);
        edtxt_name=(EditText) this.findViewById(R.id.edtxt_name);
        edtxt_avg=(EditText) this.findViewById(R.id.edtxt_avg);
        edtxt_grade=(EditText) this.findViewById(R.id.edtxt_grade);

        fdb=FirebaseDatabase.getInstance();
    }
    public void insertStudent(View v){
      Student s=new Student(edtxt_roll.getText().toString(),edtxt_name.getText().toString(),edtxt_avg.getText().toString(),edtxt_grade.getText().toString());
        fdb.getReference("student")
                .child(edtxt_roll.getText().toString())
                .setValue(s)        .addOnSuccessListener(new OnSuccessListener<Void>() {
                  @Override
                  public void onSuccess(Void unused) {
                      Toast.makeText(MainActivity.this, "Insertion:success", Toast.LENGTH_SHORT).show();
                  }
              })
              .addOnFailureListener(new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {
                      Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                  }
              });
    }
}