package com.example.myloginapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myloginapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    EditText name, email, senha;
    private FirebaseAuth auth;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null){

            startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            finish();
        }

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);

        sharedPreferences = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);

        boolean isFirstTime = sharedPreferences.getBoolean("firstTime",true);

        if (isFirstTime) {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("firstTime", false);
            editor.commit();
            Intent intent = new Intent(RegistrationActivity.this,OnBoardingActivity.class);
            startActivity(intent);
            finish();
        }
    }
    public void signup(View view){

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userSenha = senha.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this,"Enter Name!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this,"Enter Email Address!", Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(userSenha)) {
            Toast.makeText(this,"Enter Senha!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (userSenha.length() < 6) {
            Toast.makeText(this,"Senha to shot, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(userEmail,userSenha)
                .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this, "Successfully Register", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                        }else{
                            Toast.makeText(RegistrationActivity.this, "Redistration Failed"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
    }


    public void singin(View view){
        startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
    }
}