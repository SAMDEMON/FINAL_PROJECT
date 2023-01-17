package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this,"record.db",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor = db.query("DATA",null,null,null,null,null,null);
        StringBuilder content = new StringBuilder();
        if (cursor.moveToFirst())
        {
            do {
                @SuppressLint("Range")
                String time = cursor.getString(cursor.getColumnIndex("time"));
                @SuppressLint("Range")
                int num = cursor.getInt(cursor.getColumnIndex("num"));
                content.append(time+"\t\t"+num+"個打勾\n");
            }while (cursor.moveToNext());

        }
        cursor.close();
        content.append("計分說明\n");
        content.append("1.統計打勾的數量,若超過十個,需特別注意自律神經失調的問題\n");
        content.append("2.一般來說,症狀愈多,自律神經失調的可能性愈高\n");
        content.append("3.自律神經檢測量表代表自律神經失調之可能性,無法作為臨床診斷之依據\n");
        TextView textView = (TextView) findViewById(R.id.text1);
        textView.setText(content.toString());
    }
}