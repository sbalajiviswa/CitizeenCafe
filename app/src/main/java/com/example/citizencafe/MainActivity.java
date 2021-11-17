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
    static ArrayList<String> title_list = new ArrayList<>();
    static ArrayList<String> problems_list = new ArrayList<>();
    static  ArrayList<String> city_list = new ArrayList<>();
    static ArrayAdapter arrayAdapter;



    // bringing up the new activity for entering new problem title andproblem statement
    public void add_problem(View view){
        Intent intent = new Intent(getApplicationContext(),newProblem.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city_list.add("coimbatore");
        city_list.add("chennai");
        ListView listView = findViewById(R.id.listview);// the list view for showing the list of problem titles
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, title_list); // the list view 's array adapter

            listView.setAdapter(arrayAdapter);
            SQLiteDatabase mydatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
            // created a table named problems in sqlite for storing tile, statement and city names

        mydatabase.execSQL("DROP TABLE problems" );
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS problems (title VARCHAR, statement VARCHAR, city VARCHAR, id INTEGER PRIMARY KEY)");

            //Creating new problem is no longer a problem
            //Inent stuff is commented if you wish to make work feel free to

           /* Intent intent = getIntent();
            String intentDataTitle = intent.getStringExtra("title");
            String intentDataStatement = intent.getStringExtra("problem");
            title_list.add(intentDataTitle);
            problems_list.add(intentDataStatement);*/

        /*    int i = title_list.size();
            while(i != 0){
            if (title_list.get(i-1) != null && problems_list.get(i-1) != null){
            mydatabase.execSQL("INSERT INTO problems(title,statement,city) VALUES('"+title_list.get(i-1)+"','"+problems_list.get(i-1)+
                    "','chennai')");}
            i = i-1;}
*/


     mydatabase.execSQL("INSERT INTO problems(title,statement,city) VALUES('contaminated water','lack of water in my area','coimbatore')");
        mydatabase.execSQL("INSERT INTO problems(title,statement,city) VALUES('Lack of electricity','no current since flood','chennai')");

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
            //city_list.add(c.getString(cityIndex));
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
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });


    }
//memememeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
}