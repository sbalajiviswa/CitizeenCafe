package com.example.citizencafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> title_list = new ArrayList<>();
    ArrayList<String> problems_list = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    // bringing up the new activity for entering new problem title andproblem statement
    public void add_problem(View view){
        Intent intent = new Intent(getApplicationContext(),newProblem.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);// the list view for showing the list of problem titles
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, title_list); // the list view 's array adapter
        listView.setAdapter(arrayAdapter);

        try{




            SQLiteDatabase mydatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
            // created a table named problems in sqlite for storing tile, statement and city names
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS problems (title VARCHAR, statement VARCHAR, city VARCHAR, id INTEGER PRIMARY KEY)");

        /*the below code is suppose to get data from newProblem activity and store
        it in problems but for some reason it is not doing
           but breaking the code*/

            //-----//
            /*Intent intent = getIntent();
        String intentDataTitle = "titlestuff";
        String intentDataStatement = "statementsssff";
        mydatabase.execSQL("INSERT INTO problems(title,statement,city) +VALUES("+intentDataTitle+","+intentDataStatement+
                    ",'coimbatore')");
                                    */
            //----//


    /* mydatabase.execSQL("INSERT INTO problems(title,statement,city) VALUES('contaminated water','lack of water in my area','coimbatore')");
        mydatabase.execSQL("INSERT INTO problems(title,statement,city) VALUES('Lack of electricity','no current since flood','chennai')");*/

        //below code is to go through sqlite databse and retrive information
        Cursor c = mydatabase.rawQuery("SELECT * FROM problems",null);
        int titleTndex = c.getColumnIndex("title");
        int statementIndex = c.getColumnIndex("statement");
        int cityIndex = c.getColumnIndex("city");
        c.moveToFirst();
        while(!c.isAfterLast()){
            Log.i("title:",c.getString(titleTndex));
            Log.i("statement:",c.getString(statementIndex));
            Log.i("city",c.getString(cityIndex));
            title_list.add(c.getString(titleTndex));
            problems_list.add(c.getString(statementIndex));
            c.moveToNext();
        }

        //below code is to go to ProblemList activity after thr list is clicked
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(),problemListActivity.class);
                    intent.putExtra("title",title_list.get(position));
                    intent.putExtra("problem",problems_list.get(position));
                    startActivity(intent);


            }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}