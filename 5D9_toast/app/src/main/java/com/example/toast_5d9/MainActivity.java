package com.example.toast_5d9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    // Simple toast message
    public void showToast(View v){
        Toast.makeText(this, "Siddhartha Yalamanchili", Toast.LENGTH_LONG).show();
    }

    // Custom toast message
    public void showCustomToast(View v){
        LayoutInflater lf = getLayoutInflater();
        View cv = lf.inflate(R.layout.custom_toast, null); // Fixed: Pass null

        ImageView imgv = cv.findViewById(R.id.imageView);
        imgv.setImageResource(R.drawable.ic_launcher_foreground); // Ensure drawable exists

        TextView tv = cv.findViewById(R.id.textView);
        tv.setText("You created a custom toast");

        Toast t = new Toast(this);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(cv);
        t.show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"On Start called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "On Restart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this,"On Pause called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"On Resume called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "On Stop Called", Toast.LENGTH_SHORT).show();
    }
}
