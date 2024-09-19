package com.example.phonemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button gotoPictures =  findViewById(R.id.pictures);
        Button gotoSpecs = findViewById(R.id.specs);
        Button gotoLogin = findViewById(R.id.login);
        gotoPictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicturesPage();
            }
        });

        gotoSpecs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpecsPage();
            }
        });

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });
    }
    private void openPicturesPage(){
        Intent intent = new Intent(this,pictures.class);
        startActivity(intent);
    }

    private void openSpecsPage(){
        Intent intent = new Intent(this,specs.class);
        startActivity(intent);
    }
    private void openLoginPage(){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
}