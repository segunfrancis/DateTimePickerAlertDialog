package com.example.computer.customalertdialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.text_view);
        final Button hideText = findViewById(R.id.hide_text);
        Button showTime = findViewById(R.id.pick_time);
        final Button showDate = findViewById(R.id.pick_date);
        Button basicAlertDialog = findViewById(R.id.basic_alert_dialog);
        Button listAlertDialog = findViewById(R.id.list_alert_dialog);
        Button multiChoiceAlertDialog = findViewById(R.id.multi_choice_alert_dialog);
        Button customAlertDialog = findViewById(R.id.custom_alert_dialog);

        customAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.login_page, null);
                builder.setView(view);
                final EditText username = view.findViewById(R.id.username);
                builder.setPositiveButton("SIGN IN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Welcome " + username.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });

        // Hide text if visible
        hideText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getVisibility() == View.VISIBLE) {
                    textView.setVisibility(View.GONE);
                    hideText.setEnabled(false);
                } else if (textView.getVisibility() == View.GONE) {
                    hideText.setEnabled(true);
                }
            }
        });

        // Time
        showTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new TimePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "timePicker");
                hideText.setEnabled(true);
            }
        });

        // Date
        showDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "datePicker");
                hideText.setEnabled(true);
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

        // MultiChoice Alert Dialog
        multiChoiceAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiChoiceAlertDialog alertDialog = new MultiChoiceAlertDialog();
                alertDialog.show(getSupportFragmentManager(), "MultiChoiceAlertFragment");


                hideText.setEnabled(true);
            }
        });

        // Custom Alert Dialog
        /*customAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialog alertDialog = new CustomAlertDialog();
                alertDialog.show(getSupportFragmentManager(), "CustomAlertDialog");

                hideText.setEnabled(true);
            }
        });*/
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
        displayText.setVisibility(View.VISIBLE);
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
        displayText.setVisibility(View.VISIBLE);
        displayText.setText(date);
    }
}
