package com.example.school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button gotoSecondActivityButton = findViewById(R.id.button);
        gotoSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
          
        });
    }