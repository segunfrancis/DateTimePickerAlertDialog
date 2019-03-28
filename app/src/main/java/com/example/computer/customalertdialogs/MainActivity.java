package com.example.computer.customalertdialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showTime = findViewById(R.id.pick_time);
        Button showDate = findViewById(R.id.pick_date);
        Button basicAlertDialog = findViewById(R.id.basic_alert_dialog);
        Button listAlertDialog = findViewById(R.id.list_alert_dialog);

        // Time
        showTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new TimePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });

        // Date
        showDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        // Basic Alert Dialog
        basicAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BasicAlertDialog alertDialog = new BasicAlertDialog();
                alertDialog.show(getSupportFragmentManager(), "BasicAlertDialog");
            }
        });

        // List Alert Dialog
        listAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListAlertDialog alertDialog = new ListAlertDialog();
                alertDialog.show(getSupportFragmentManager(), "ListAlertDialog");
            }
        });
    }

    /**
     * @param view       the picker associated with the dialog
     * @param year       the selected year
     * @param month      the selected month (0-11 for compatibility with
     *                   {@link Calendar#MONTH})
     * @param dayOfMonth th selected day of the month (1-31, depending on
     */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        TextView displayText = findViewById(R.id.text_view);
        String date = "Date " + dayOfMonth + "/" + month + "/" + year;
        displayText.setText(date);
    }

    /**
     * Called when the user is done setting a new time and the dialog has
     * closed.
     *
     * @param view      the view associated with this listener
     * @param hourOfDay the hour that was set
     * @param minute    the minute that was set
     */
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView displayText = findViewById(R.id.text_view);
        String date = "Time " + hourOfDay + ":" + minute;
        displayText.setText(date);
    }
}
