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

public class Register extends AppCompatActivity {
    EditText sEmail, sPassword, sConfirmpassword ;
    FirebaseAuth mAuth;
    Button Register, alreadylogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sEmail = findViewById(R.id.signup_email_id);
        sPassword = findViewById(R.id.signup_pass_id);
        sConfirmpassword = findViewById(R.id.signup_confirmPass_id);
        Register = findViewById(R.id.register);
        alreadylogin= findViewById(R.id.register_id);
        mAuth = FirebaseAuth.getInstance();


        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = sEmail.getText().toString().trim();
                String  password = sPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    sEmail.setError("Email is required");
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


    }
}
