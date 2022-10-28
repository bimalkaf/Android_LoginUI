package com.example.metaMergeTasker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class passwordGeneratorScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_generator_screen);
    }

    public String getPassword(int len)
    {
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