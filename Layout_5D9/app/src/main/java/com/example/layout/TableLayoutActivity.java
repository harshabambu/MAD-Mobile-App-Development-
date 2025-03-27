package com.example.layout;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView imgv1=(ImageView) findViewById(R.id.img1);
        imgv1.setImageResource(R.drawable.img);
        ImageView imgv2=(ImageView) findViewById(R.id.img2);
        imgv2.setImageResource(R.drawable.lion);
        ImageView imgv3=(ImageView) findViewById(R.id.img3);
        imgv3.setImageResource(R.drawable.flower);
        ImageView imgv4=(ImageView) findViewById(R.id.img4);
        imgv4.setImageResource(R.drawable.dog);

    }
}