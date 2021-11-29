package com.example.citizencafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class signup extends AppCompatActivity {
    Button login_bt;
    Spinner spinner;
    ArrayAdapter <String> spinneradapter;
    ArrayList<String> city_list = new ArrayList<String>();
    public void login_function (View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        city_list.add("coimbatore");
        city_list.add("chennai");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login_bt = (Button) findViewById(R.id.Login);
        spinner = (Spinner) findViewById(R.id.city_field);
        spinneradapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,city_list);
        spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinneradapter);


        //drop box working but databse is loaded in amin activity so wont load before sigup have to brig em here

    }
}