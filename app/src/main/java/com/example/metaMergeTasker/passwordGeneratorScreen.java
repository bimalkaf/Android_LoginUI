package com.example.metaMergeTasker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class passwordGeneratorScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_generator_screen);

        // Adam: Locate and Store field and button objects
        // Luca: Added buttons for 8 and 12 character password generation
        TextView passwordField = findViewById(R.id.GenPasswordField);
        MaterialButton genBTN8 = findViewById(R.id.genBTN);
        MaterialButton genBTN12 = findViewById(R.id.gen1BTN);

        // Adam: Run this on load to populate password field
        passwordField.setText(getPassword(12));

        // Adam: genBtn on click function, set text and run function all in one
        // Luca: Added buttons for 8 and 12 character password generation and made relevant event handlers for each (setting relevant len value)
        genBTN8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                passwordField.setText(getPassword(8));
            }
        });

        genBTN12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                passwordField.setText(getPassword(12));
            }
        });
    }

    // Adam: here is the getPassword function i was supplied by the team
    public String getPassword(int len) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String num = "0123456789";
        String specialChars = "<>,.?/}]{[+_-)(*&^%$#@!=";
        String combination = upper+lower+specialChars+num;

        char[] password = new char[len];
        Random r = new Random();
        for (int i = 0; i <len; i++)
        {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }
        return new String(password);
    }

}