package com.example.metaMergeTasker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Adam: Expense Manager Main Interface
public class expenseMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_main);

        TextView expenseTitle = (TextView)findViewById(R.id.expenseTitle);

        // ADAM: Set textview title here in case we want other UI languages in the future
        expenseTitle.setText("Expense");

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.metaMergeTasker", Context.MODE_PRIVATE);

        //ADAM: ArrayList of Sets for storage of our expenses
        List<Set<String>> expenses = new ArrayList<Set<String>>();
        /*ADAM: example to add to the set
        *   ITEMS will need to be added and removed to ensure the correct order....
        *
        * expenses.add(new HashSet<Object>());
        * expenses.get(X).add("Some Object/String/Int"); // Each run will add an entry to row X
        * expenses.get(X).remove("Some Object/String/Int"); // Will delete matching entry
        *
         */


    }
}