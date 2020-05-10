package com.example.futsalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText Emailtx;
    EditText Passwordtx;
    Button  loginBtn;
    Button  asksignupBtn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Emailtx = findViewById(R.id.emailt);
        Passwordtx = findViewById(R.id.Passwordt);
        loginBtn =findViewById(R.id.loginBtn);
        asksignupBtn = findViewById(R.id.askSignup);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = Emailtx.getText().toString();
                String Password = Passwordtx.getText().toString();
                firebaseAuth =FirebaseAuth.getInstance();
                if (Email.isEmpty()){
                   Emailtx.setError("Please Enter EmailId");
                    Emailtx.requestFocus();
                }else if (Password.isEmpty()){
                    Passwordtx.setError("Please enter your password");
                    Passwordtx.requestFocus();
                }else if (Email.isEmpty() && !Password.isEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this,homeActivity.class));
                            }else{
                                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });


    }
}
