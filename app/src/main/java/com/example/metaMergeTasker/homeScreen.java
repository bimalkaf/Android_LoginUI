package com.example.metaMergeTasker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class homeScreen extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Adam: Create button object pointers, so we can use them :D
        ImageButton pwGen = (ImageButton) findViewById(R.id.btn_generator);
        ImageButton lists = (ImageButton) findViewById(R.id.btn_lists);

        // Adam: PWGen Image Button Action
        pwGen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(homeScreen.this, passwordGeneratorScreen.class);
                startActivity(intent);
            }
        });

        // Adam: Note Taker Image Button Action
        lists.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(homeScreen.this, noteMainActivity.class);
                startActivity(intent);
            }
        });
    }
}