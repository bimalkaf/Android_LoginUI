package com.example.metaMergeTasker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

public class noteMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_main_activity);

        //
        TextView pageTitle =(TextView) findViewById(R.id.noteTextView);

        // Adam: We set the page title here incase we want an easy way to translate to other languages in
        // the future
        String pageTitleText = "Notes";
        pageTitle.setText(pageTitleText);


    }
}