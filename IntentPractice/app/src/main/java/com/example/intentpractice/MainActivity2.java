package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t = findViewById(R.id.show_activity2);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name","****");
        String age = extras.getString("age","********");
        int number = extras.getInt("intValue",10);
        int marks = extras.getInt("marks",000000);

        t.setText(name + " "+ age + " " + number + " "+ " marks " + marks);

    }
}