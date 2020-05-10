package com.example.futsalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email; //variable name
    EditText Password;
    Button Signup;
    Button askLoginBtn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email= findViewById(R.id.Email);
        Password =findViewById(R.id.Password);
        Signup =findViewById(R.id.signup);
        askLoginBtn =findViewById(R.id.askLogin);

        askLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Login.class));

            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  Email = email.getText().toString();
                String password = Password.getText().toString();
                firebaseAuth =FirebaseAuth.getInstance();

                if (Email.isEmpty()){
                    email.setError("Please Enter Your Email Id");
                    email.requestFocus();
                }else  if (password.isEmpty()){
                    Password.setError("Please enter a password");
                    Password.requestFocus();
                }else if (!Email.isEmpty() && !password.isEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() { //OnCompleteLister Check successfull 
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {//successfull vayena vane
                            Toast.makeText(MainActivity.this, "Signup", Toast.LENGTH_SHORT).show();
                            
                        }else{
                            startActivity(new Intent(MainActivity.this,homeActivity.class));

                        }

                    }
                });
                }


            }
        });





    }
}
