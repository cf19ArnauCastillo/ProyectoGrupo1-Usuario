package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = findViewById(R.id.btnCreateAccount);
        EditText textMail = findViewById(R.id.txtMailLogin);
        EditText txtPassword = findViewById(R.id.txtPasswordLogin);
        EditText txtUsername = findViewById(R.id.txtUserNameRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hola", Toast.LENGTH_LONG).show();
                startRegister ();
            }
        });
    }
    public void startRegister () {
        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
    }
}