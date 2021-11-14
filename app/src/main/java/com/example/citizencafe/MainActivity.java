package com.example.citizencafe;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,titles);
        listView.setAdapter(arrayAdapter);
        try{
        SQLiteDatabase mydatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);//created a table named problems
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS problems (title VARCHAR, statement VARCHAR, city VARCHAR, id INTEGER PRIMARY KEY)");
       // mydatabase.execSQL("INSERT INTO problems(title,statement,city) VALUES('contaminated water','lack of water in my area','coimbatore')");
        //mydatabase.execSQL("INSERT INTO problems(title,statement,city) VALUES('Lack of electricity','no current since flood','chennai')");
        Cursor c = mydatabase.rawQuery("SELECT * FROM problems",null);
        int titleTndex = c.getColumnIndex("title");
        int statementIndex = c.getColumnIndex("statement");
        int cityIndex = c.getColumnIndex("city");
        c.moveToFirst();
        while(!c.isAfterLast()){
            Log.i("title:",c.getString(titleTndex));
            Log.i("statement:",c.getString(statementIndex));
            Log.i("city",c.getString(cityIndex));
            titles.add(c.getString(cityIndex));
            c.moveToNext();
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}