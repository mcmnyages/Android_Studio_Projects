package com.example.phonemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class buypage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buypage);


        TextView phoneName = findViewById(R.id.iphone1);
        ImageView phoneImage = findViewById(R.id.iphone2);
        TextView phoneDescription = findViewById(R.id.iphone4);
        TextView phonePrice = findViewById(R.id.iphone5);
        Button buyButton = findViewById(R.id.buy_button);


        // Set phone details
        phoneName.setText("Phone Name");
        phoneImage.setImageResource(R.drawable.iphone3);
        phoneDescription.setText("Description about the phone.");
        phonePrice.setText("Price: $XXX");

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle buy button click
                // Implement buy functionality here
            }
        });
    }
}