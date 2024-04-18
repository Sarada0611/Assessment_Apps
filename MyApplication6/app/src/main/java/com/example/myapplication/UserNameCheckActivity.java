package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class UserNameCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.username_check);

        String username = getIntent().getStringExtra("username");

        TextView  textUserName = findViewById(R.id.userName);
        textUserName.setText("Welcome, "+username);
    }
}
