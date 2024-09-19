package com.example.toastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private RadioGroup radiogroups;
Button submit, clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=(Button)findViewById(R.id.button2);
        clear = (Button) findViewById(R.id.button);
        radiogroups = (RadioGroup) findViewById(R.id.radioGroup);
        radiogroups.clearCheck();
        radiogroups.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radiobutton = (RadioButton)group.findViewById(checkedId);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedid = radiogroups.getCheckedRadioButtonId();
                if(selectedid==-1){
                    Toast.makeText(MainActivity.this,"No Room has been selected",Toast.LENGTH_SHORT).show();
                }
                else{
                    RadioButton radioButton = (RadioButton) radiogroups.findViewById(selectedid);
                    Toast.makeText(MainActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radiogroups.clearCheck();
            }
        });
    }
}