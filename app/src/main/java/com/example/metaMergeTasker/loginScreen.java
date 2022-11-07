package com.example.metaMergeTasker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.example.metaMergeTasker.extraFunctions;

public class loginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // ADAM: Fixed object types...
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        TextView forgotPass = (TextView) findViewById(R.id.forgotPass);

        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.login_btn);

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // HARDCODED CREDENTIALS: admin and admin
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (username.getText().toString().equals(getString(R.string.username)) && password.getText().toString().equals(getString(R.string.password))) {
                    //correct
                    new extraFunctions.ShowToast(loginScreen.this, false, "Login Successful");
                    //Toast.makeText(loginScreen.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(loginScreen.this, homeScreen.class);
                    startActivity(intent);
                } else {
                    //incorrect
                    new extraFunctions.ShowToast(loginScreen.this, true, "ERROR: Login Failed!");;
                }
            }
        });
    }
}