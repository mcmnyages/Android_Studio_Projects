package com.example.phonemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class specs extends AppCompatActivity {

    private ListView specsListView;
    private ArrayAdapter<String> specsAdapter;

    private String[] iphoneSpecs = {"Display: Super Retina XDR OLED, 6.1 inches",
            "Chip: A14 Bionic chip",
            "Camera: Dual 12MP Ultra Wide and Wide cameras",
            "Battery: Up to 17 hours video playback",
            "OS: iOS 14"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specs);
        specsListView = findViewById(R.id.phonespecs);
        specsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, iphoneSpecs);
        specsListView.setAdapter(specsAdapter);
    }
}