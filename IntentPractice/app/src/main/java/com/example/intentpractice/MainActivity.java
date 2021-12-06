package com.example.intentpractice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.intentpractice.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    String name,age;
    EditText e1,e2;
    Button b1,b2,b3,b4;
    ImageView i;
    Bitmap bitmap;
    TextView t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_main);


       e1 =findViewById(R.id.main_name);
       e2 = findViewById(R.id.main_age);
       b1=findViewById(R.id.main_sendData);
       b2=findViewById(R.id.main_result);
       t1 = findViewById(R.id.main1_textView);
       i = findViewById(R.id.main_img);
       b3 = findViewById(R.id.main_imgpck);
       b4 = findViewById(R.id.main_recyclerView);



       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sendFunction();
           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(MainActivity.this,MainActivity3.class);
               i.putExtra("key","kuch to bhej bhai");

               startActivityForResult(i,1);




           }
       });
       b3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               pickImg();
           }
       });

       b4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(MainActivity.this,MainActivity4.class);
               startActivity(i);
           }
       });



    }
    void pickImg()
    {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(i,2);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "pahuch gye func k andr", Toast.LENGTH_SHORT).show();
        if(resultCode==RESULT_OK && requestCode==1)
        {
            Bundle extras = data.getExtras();
            if(extras!=null)
            {
                Toast.makeText(this, extras.getString("message"), Toast.LENGTH_SHORT).show();
                t1.setText(extras.getString("msg2","kuch bhi nhi bheja 😢"));
            }
            else
            {
                Toast.makeText(this, "fuck u", Toast.LENGTH_SHORT).show();
            }
        }
        else if(resultCode==RESULT_OK && requestCode==2)
        {
            try {
                InputStream stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);
                i.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    void sendFunction()
    {

        name = e1.getText().toString();
        age = e2.getText().toString();
        Intent i = new Intent(MainActivity.this,MainActivity2.class);
        i.putExtra("name",name);
        i.putExtra("age",age);
        i.putExtra("intValue",10);
        startActivity(i);
    }


}