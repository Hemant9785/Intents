package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {

    TextView t;
    EditText e;
    Button b;
    String msg="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t = findViewById(R.id.main3_txtView);
        e = findViewById(R.id.main3_editText);
        b = findViewById(R.id.main3_finishbtn);
        Intent data = getIntent();
        msg = data.getExtras().getString("key");
        t.setText(msg);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("message","bhej diya hemant bhai 😁😁😁");
        data.putExtra("msg2",e.getText().toString());
        setResult(RESULT_OK,data);
        super.finish();
    }
}