package com.example.citizencafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class newProblem extends AppCompatActivity {
    EditText problem_entry;
    EditText statement_entry;
    Button add;

    //below function is to give back the new probelm title and statemnt to main activity
    public void giveback(View view){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_problem);
        problem_entry = findViewById(R.id.problemEntry);
        statement_entry = findViewById(R.id.statementEntry);
        add = findViewById(R.id.addbutton);

    }
}