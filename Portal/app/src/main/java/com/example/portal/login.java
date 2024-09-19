package com.example.portal;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      TextView userName = findViewById(R.id.userName);
      TextView passwordText = findViewById(R.id.password);
      Button login = findViewById(R.id.button2);
      TextView error = findViewById(R.id.textView2);
      login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String username = userName.getText().toString();
              String password = passwordText.getText().toString();
              if(isValidCredentials(username,password)){
                  Intent intent = new Intent(login.this, Welcome.class);
                  startActivity(intent);
              }
              else{
                  error.setText("Wrong username or Password");
              }
          }
      });

    }
    private boolean isValidCredentials(String username, String password){
        return username.equals("user") && password.equals("password");
    }
}