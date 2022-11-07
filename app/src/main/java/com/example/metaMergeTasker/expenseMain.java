package com.example.metaMergeTasker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Adam: Expense Manager Main Interface
public class expenseMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_main);

        TextView expenseTitle = (TextView)findViewById(R.id.expenseTitle);

        // ADAM: Set textview title here in case we want other UI languages in the future
        expenseTitle.setText("Expense");
    }
}