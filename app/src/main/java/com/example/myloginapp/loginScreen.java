package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class loginScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    //correct
                    Toast.makeText(loginScreen.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(loginScreen.this, homeScreen.class);
                    startActivity(intent);
                }else
                    //incorrect
                    Toast.makeText(loginScreen.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }   ;

        });
    }
}