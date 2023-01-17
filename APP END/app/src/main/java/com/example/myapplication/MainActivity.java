package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void next(View view){
        int id[] = {R.id.cb1,R.id.cb2,R.id.cb3,R.id.cb4,R.id.cb5,R.id.cb6,R.id.cb7,R.id.cb8,R.id.cb9,R.id.cb10,
                    R.id.cb11,R.id.cb12,R.id.cb13,R.id.cb14,R.id.cb15,R.id.cb16,R.id.cb17,R.id.cb18,R.id.cb19,R.id.cb20,
                    R.id.cb21,R.id.cb22,R.id.cb23,R.id.cb24,R.id.cb25,R.id.cb26,R.id.cb27,R.id.cb28,R.id.cb29,R.id.cb30};
        int counter = 0;
        CheckBox checkBox;
        for (int i=0;i<30;i++)
        {
            checkBox = (CheckBox) findViewById(id[i]);
            if (checkBox.isChecked())
            {
                counter++;
            }
        }
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("counter",counter);
        startActivity(intent);
    }
}