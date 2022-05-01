package com.learning.elearning.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.learning.elearning.R;

import java.sql.Struct;

public class LoginActivity extends AppCompatActivity {
    EditText loginEmail,loginPassword;
    Button loginButton,registerButton;
    FirebaseAuth auth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        auth = FirebaseAuth.getInstance();
        registerButton = findViewById(R.id.login_reg_btn);
        progressBar = findViewById(R.id.regprogressBar);
        progressBar.setVisibility(View.GONE);

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openRegister();
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

    }

    private void openRegister() {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        finish();
    }

    private void loginUser() {
        String email,password;
        email = loginEmail.getText().toString().trim();
        password = loginPassword.getText().toString().trim();

        if(email.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Please provide all Fields", Toast.LENGTH_SHORT).show();
        }
        else{
            progressBar.setVisibility(View.VISIBLE);
         auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     progressBar.setVisibility(View.GONE);
                     startActivity(new Intent(LoginActivity.this,ProfileActivity.class));

                 }
                 else{
                     progressBar.setVisibility(View.GONE);
                     Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                 }
             }
         }) ;
        }

    }
}