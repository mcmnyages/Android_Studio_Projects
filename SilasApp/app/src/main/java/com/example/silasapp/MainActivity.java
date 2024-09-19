package com.example.silasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private CheckBox football,tennis,hockey,cricket,basketball;
    private Button buttonDetails;
    private TextView tv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        football = (CheckBox) findViewById(R.id.checkbox1);
        tennis = (CheckBox) findViewById(R.id.checkbox2);
        basketball = (CheckBox) findViewById(R.id.checkbox3);
        cricket = (CheckBox) findViewById(R.id.checkbox4);
        hockey = (CheckBox) findViewById(R.id.checkbox5);
        buttonDetails = (Button) findViewById(R.id.button);
        tv1 = (TextView) findViewById(R.id.textView3);


        buttonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("");
                tv1.setText("CODES");

                if (football.isChecked()) {
                    tv1.append("\nFB: Football");
                }
                if (tennis.isChecked()) {
                    tv1.append("\nTT: Table Tennis");
                }
                if (basketball.isChecked()) {
                    tv1.append("\nBB: Baskball");
                }
                if (hockey.isChecked()) {
                    tv1.append("\nHK: Hockey");
                }
                if (cricket.isChecked()) {
                    tv1.append("\nCK: Cricket");
                }
            }
        });


    }


    }
