package com.example.citizencafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newProblem extends AppCompatActivity {
    EditText problem_entry;
    EditText statement_entry;
    Button add;
    DatabaseReference databaseproblems;


    //below function is to give back the new probelm title and statemnt to main activity
    public void giveback(View view){
        if (!TextUtils.isEmpty(problem_entry.getText().toString())&&
        !TextUtils.isEmpty(statement_entry.getText().toString())) {
           /* MainActivity.title_list.add(problem_entry.getText().toString());
            MainActivity.problems_list.add(statement_entry.getText().toString());*/
            MainActivity.arrayAdapter.notifyDataSetChanged();
            String id = databaseproblems.push().getKey();
            Problems problems = new Problems(id,problem_entry.getText().toString(),
                    statement_entry.getText().toString());
            databaseproblems.child(id).setValue(problems);

            finish();
        }else{
            Toast.makeText(this, "Enter a valid problem", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_problem);
        problem_entry = findViewById(R.id.problemEntry);
        statement_entry = findViewById(R.id.statementEntry);
        add = findViewById(R.id.addbutton);
        databaseproblems = FirebaseDatabase.getInstance("https://citizencafe-b15ea-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Problems");

    }
}