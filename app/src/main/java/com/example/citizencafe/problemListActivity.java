package com.example.citizencafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class problemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_list);
        //variable declaration stuff
        TextView textView = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.textView2);

        //getting the intent from main activity
        Intent intent = getIntent();
        String intentDataTitle = intent.getStringExtra("title");
        String intentDataStatement = intent.getStringExtra("problem");
        textView.setText(intentDataTitle);
        textView1.setText(intentDataStatement);

    }
}