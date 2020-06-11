package com.example.futsalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText signup_fullname,signup_email, signup_pass,signup_confirm_pass;
    private Button mSignupBtn,  mLoginBtn;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup_fullname = findViewById(R.id.signup_fullname);
        signup_email = findViewById(R.id.signup_email_id);
        signup_pass= findViewById(R.id.signup_pass_id);
        signup_confirm_pass = findViewById(R.id.signup_confirmPass_id);
        mSignupBtn = findViewById(R.id.signup);
        mLoginBtn = findViewById(R.id.signup_id);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        
       if (mAuth.getCurrentUser() != null){
           startActivity(new Intent(MainActivity.this,Login.class));
           finish();
        }




    }

    public void signUp(View view) {
        String email = signup_email.getText().toString().trim();
        String password = signup_pass.getText().toString().trim();
        String confirm_pass = signup_confirm_pass.getText().toString().trim();
        String fullname = signup_fullname.getText().toString();




        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (TextUtils.isEmpty(confirm_pass)){
            Toast.makeText(this, "Confirm passsword field empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (password.length() <6){
            Toast.makeText(this, "password too short", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(password.equals(confirm_pass)){
            createAccount(email,password);

        }
        else{
            Toast.makeText(this, "password dont match", Toast.LENGTH_SHORT).show();
        }


        //signup button click garda yo function call hunxa

    }

    private void createAccount(String email, String password) {

        //firebase ko signup garni code rakhxama
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent (getApplicationContext(), homeActivity.class));


                            Toast.makeText(MainActivity.this, "Signup Successfull", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user
                            Toast.makeText(MainActivity.this, "Signup Fail", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

    }


}


