package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void next(View view){
        Intent intent = getIntent();
        int id[] = {R.id.cb1,R.id.cb2,R.id.cb3,R.id.cb4,R.id.cb5,R.id.cb6,R.id.cb7,R.id.cb8,R.id.cb9,R.id.cb10,
                R.id.cb11,R.id.cb12,R.id.cb13};
        int counter = intent.getIntExtra("counter",0);
        CheckBox checkBox;
        for (int i=0;i<13;i++)
        {
            checkBox = (CheckBox) findViewById(id[i]);
            if (checkBox.isChecked())
            {
                counter++;
            }
        }
        String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this,"record.db",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("time",nowDate);
        values.put("num",counter);
        db.insert("DATA",null,values);
        Intent intent2 = new Intent(this,MainActivity3.class);
        startActivity(intent2);
    }
}