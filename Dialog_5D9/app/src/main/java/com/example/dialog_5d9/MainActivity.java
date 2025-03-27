package com.example.dialog_5d9;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

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

    public void showDialog(View v) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        adb.setTitle("Harsha Vardhan");
        adb.setMessage("This is the dialog created by Harsha!!");
        adb.setPositiveButton("Continue", (dialogInterface, i) ->
                Toast.makeText(MainActivity.this, "Thank You", Toast.LENGTH_LONG).show());
        adb.setNegativeButton("Cancel", (dialogInterface, i) ->
                Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_LONG).show());
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void showTime(View v) {
        Calendar c = Calendar.getInstance();
        int dh = c.get(Calendar.HOUR);
        int dm = c.get(Calendar.MINUTE);
        TimePickerDialog tpd = new TimePickerDialog(this, (view, hourOfDay, minute) ->
                Toast.makeText(MainActivity.this, hourOfDay + "H: " + minute + "M", Toast.LENGTH_LONG).show(),
                dh, dm, true);
        tpd.show();
    }

    public void showDate(View v) {
        Calendar c = Calendar.getInstance();
        int dYear = c.get(Calendar.YEAR);
        int dMon = c.get(Calendar.MONTH);
        int dDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this, (datePicker, i, i1, i2) ->
                Toast.makeText(MainActivity.this, i + "Y:" + i1 + "M:" + i2 + "D", Toast.LENGTH_LONG).show(),
                dYear, dMon, dDay);
        dpd.setTitle("Pick a date please");
        dpd.show();
    }
}