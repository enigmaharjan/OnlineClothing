package com.example.onlineclothing;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class Dashboard extends AppCompatActivity {
    private RecyclerView recyclerView;
//    private Map<>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);

        ReadItem();

        List<Clothes> clothesList = null;
        ClothesAdapter clothesAdapter = new ClothesAdapter(this, clothesList);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddItem.class);
                startActivity(i);
            }
        });
    }

    private void ReadItem() {
        try{
            FileInputStream fis = openFileInput("items.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line=br.readLine())!=null){
                String[] parts = line.split("->");

            }
        }
        catch (IOException e){

        }
    }

}
