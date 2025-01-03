package com.example.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }
//    public void show_ll_activity(View v){
//        Intent i=new Intent(this,);
//        this.startActivity(i);
//    }

    public void show_tl_activity(View v){
         Intent i=new Intent(this,TableLayoutActivity.class);
         this.startActivity(i);
    }
    public void show_fl_activity(View v){
        Intent i=new Intent(this,FrameLayoutActivity.class);
        this.startActivity(i);
    }
    public void show_rl_activity(View v){
        Intent i=new Intent(this,RelativeLayoutActivity.class);
        this.startActivity(i);
    }
    public void show_tabl_activity(View v){
        Intent i=new Intent(this,TabLayoutActivity.class);
        this.startActivity(i);
    }
}
