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
        ImageButton organiser = (ImageButton) findViewById(R.id.btn_organiser);
        ImageButton expMang = (ImageButton) findViewById(R.id.btn_expense);
        ImageButton pwMang = (ImageButton) findViewById(R.id.btn_manager);

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

        // Adam: Organiser Button Action
        organiser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                messageBox("Organiser - Yet to be implemented!");
            }
        });

        // Adam: Expense Manager Button Action
        expMang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                messageBox("Expense Manager - Yet to be implemented!");
            }
        });

        // Adam: Password Manager Button Action
        pwMang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                messageBox("Password Manager - Yet to be implemented!");
            }
        });
    }

    // Adam: Toast Message Box :)
    public void messageBox(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}