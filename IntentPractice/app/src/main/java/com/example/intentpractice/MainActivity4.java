package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.intentpractice.Adapters.recyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> dataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        recyclerView  = findViewById(R.id.main4_recyclerView);
        for(int i=0;i<1000;i++)
        {
            dataset.add(""+i);
        }
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,1));
        recyclerViewAdapter adapter = new recyclerViewAdapter(getApplicationContext(),dataset);
        recyclerView.setAdapter(adapter);

    }
}