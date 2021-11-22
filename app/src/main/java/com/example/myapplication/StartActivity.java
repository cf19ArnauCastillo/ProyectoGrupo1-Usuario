package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Initialize in login fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentLogin()).commit();

        TextView btnLogin = findViewById(R.id.btnLogin2);
        TextView btnRegister = findViewById(R.id.btnRegister2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnRegister.setTextColor(getResources().getColor(R.color.gray));
                btnLogin.setTextColor(getResources().getColor(R.color.red));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentLogin()).commit();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLogin.setTextColor(getResources().getColor(R.color.gray));
                btnRegister.setTextColor(getResources().getColor(R.color.orange));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentRegister()).commit();
            }
        });

    }
}