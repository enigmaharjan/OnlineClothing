package com.example.onlineclothing;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddItem extends AppCompatActivity {
    private EditText etItemName, etItemPrice,etItemDescription;
    private ImageView ivView;
    private Button btnAddItem, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        etItemName = findViewById(R.id.etItemName);
        etItemPrice= findViewById(R.id.etItemPrice);
        etItemDescription= findViewById(R.id.etItemDescription);
        ivView= findViewById(R.id.ivImage);
        btnAddItem= findViewById(R.id.btnAdd);
        btnReset = findViewById(R.id.btnReset);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveItem();
            }
        });
    }

    private void SaveItem() {
        try{
            PrintStream printStream = new PrintStream(openFileOutput("items.txt", MODE_PRIVATE| MODE_APPEND));
            printStream.println(etItemName.getText().toString()+"->"+etItemPrice.getText().toString()+"->"+etItemDescription.getText().toString()+"->"+ ivView.getDrawable().toString());
            Toast.makeText(this, "Item Saved", Toast.LENGTH_LONG).show();
        }
        catch (IOException e){
            Log.d("Online Clothing App", "Error"+ e.toString());
            e.printStackTrace();
            Toast.makeText(this, "Item Saved", Toast.LENGTH_LONG).show();
        }
    }
}
