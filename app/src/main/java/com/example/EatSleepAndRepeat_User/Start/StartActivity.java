package com.example.EatSleepAndRepeat_User.Start;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.EatSleepAndRepeat_User.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Initialize in login fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentLogin()).commit();

        TextView btnLogin = findViewById(R.id.btnLogin);
        TextView btnRegister = findViewById(R.id.btnRegister);

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