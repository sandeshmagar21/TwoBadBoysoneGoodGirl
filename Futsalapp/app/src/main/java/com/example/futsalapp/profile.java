package com.example.futsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {
   private TextView profile_name,profile_email,profile_phoneno;
   private Button Savebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile_name = findViewById(R.id.Profile_Name);
        profile_email = findViewById(R.id.Profile_email);
        profile_phoneno = findViewById(R.id.Profile_Phoneno);


    }
}
