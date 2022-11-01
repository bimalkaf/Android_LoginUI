package com.example.metaMergeTasker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class homeScreen extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        imageButton = (ImageButton) findViewById(R.id.btn_generator);

        imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent=new Intent(homeScreen.this, passwordGeneratorScreen.class);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setComponent(new ComponentName("com.xstudioo.noteme","com.xstudioo.noteme.MainActivity"));
                startActivity(intent);
            }



    });
}}