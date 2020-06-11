package com.example.futsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {


    Button btn_profile,btn_features, btn_gallery, btn_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_profile = findViewById(R.id.buttonProfile);
        btn_features = findViewById(R.id.button_Feature);
        btn_gallery = findViewById(R.id.buttonGallery);
        btn_list = findViewById(R.id.buttonList);
        
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this,profile.class));
                Toast.makeText(homeActivity.this, "Profile Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this,gallery.class));
                Toast.makeText(homeActivity.this, "Gallery Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this,futsallist.class));
                Toast.makeText(homeActivity.this, "List Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
