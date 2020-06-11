package com.example.futsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {


   public static final String TAG = "TAG";
    TextView profile_name,profile_email,profile_phoneno;
    Button Savebtn;
    ImageView profileImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent data = getIntent();
        String fullname = data.getStringExtra("fullname");
        String email = data.getStringExtra( "email");
        String phone = data.getStringExtra( "phone");

        profile_name = findViewById(R.id.Profile_Name);
        profile_email = findViewById(R.id.Profile_email);
        profile_phoneno = findViewById(R.id.Profile_Phoneno);
        profileImageView = findViewById(R.id.Profile_Image);


        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(profile.this, "Profile Image", Toast.LENGTH_SHORT).show();

            }
        });

        profile_email.setText(email);
        profile_name.setText(fullname);
        profile_phoneno.setText(phone);

        Log.d(TAG, "onCreate:"  + fullname + "" + email + " "+ phone);


    }
}
