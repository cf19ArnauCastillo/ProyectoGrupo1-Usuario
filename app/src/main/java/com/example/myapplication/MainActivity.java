package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        Button btnSigIn = findViewById(R.id.btnSingIn);
        EditText textMail = findViewById(R.id.txtMail);
        EditText txtPassword = findViewById(R.id.txtPassword);


        // If the user already access into the app, goes directly to home screen
        SharedPreferences prefs = getSharedPreferences("SharedP", Context.MODE_PRIVATE);

        if (prefs.getBoolean("login", false)) startHome();


        /**
         * When there is a click on the "Login" button and the credentials are correct,
         * home screen will take place.
         */
        btnSigIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textMail.getText().toString().equals("123") && txtPassword.getText().toString().equals("123")) {
                    savePreferences(prefs, textMail.getText().toString());
                    startHome();
                } else {
                    Toast.makeText(getApplicationContext(), "The password is incorrect", Toast.LENGTH_LONG).show();
                    txtPassword.setText("");
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startRegister();
            }
        });
        public void startHome(){
            startActivity(new Intent(getApplicationContext(), FragmentHome.class));
        }
        public void startRegister(){
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        }
    }
}