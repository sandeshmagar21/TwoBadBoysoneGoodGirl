package com.example.futsalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class Register extends AppCompatActivity {
    public static final String TAG = "Tag";
    EditText sFullname ,sEmail, sPassword, sConfirmpassword ,sPhoneNumber;
    FirebaseAuth mAuth;
    Button Register, alreadylogin;
    FirebaseFirestore fStore;
    String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sFullname = findViewById(R.id.signup_fullname);
        sPhoneNumber = findViewById(R.id.signup_phonenumber);
        sEmail = findViewById(R.id.signup_email_id);
        sPassword = findViewById(R.id.signup_pass_id);
        sConfirmpassword = findViewById(R.id.signup_confirmPass_id);
        Register = findViewById(R.id.register);
        alreadylogin= findViewById(R.id.register_id);

        mAuth = FirebaseAuth.getInstance();
        //fStore = FirebaseFirestore.getInstance();


       // if (mAuth.getCurrentUser() != null){
          //  startActivity(new Intent(getApplicationContext(),MainActivity.class));
          //  finish();
       // }


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = sEmail.getText().toString().trim();
                String  password = sPassword.getText().toString().trim();
                final String fullName = sFullname.getText().toString();
                final String phoneNumber = sPhoneNumber.getText().toString();

                if (TextUtils.isEmpty(email)){
                    sEmail.setError("Email is required ");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    sEmail.setError("Password is required");
                    return;
                }
                if(password.length() <6){
                    sPassword.setError("Password must be >== 6 Character");
                    return;
                }

                //register the user in firebase

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){


                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        alreadylogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


    }
    //Exit
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(" are you sure want to Exit")
          .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Register.super.onBackPressed();

                    }
                })
                .setNegativeButton(" No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
         AlertDialog alertDialog= builder.create();
         alertDialog.show();


    }
}
