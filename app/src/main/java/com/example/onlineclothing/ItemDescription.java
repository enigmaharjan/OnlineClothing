package com.example.onlineclothing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemDescription extends AppCompatActivity {
    private TextView tvName, tvPrice, tvDescription;
    private CircleImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        tvName = findViewById(R.id.tvItemName_description);
        tvPrice = findViewById(R.id.tvPrice_description);
        tvDescription = findViewById(R.id.tvDescription_description);
        img = findViewById(R.id.circleImg_description);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            tvName.setText(bundle.getString("itemName"));
            tvPrice.setText(bundle.getString("price"));
            tvDescription.setText(bundle.getString("description"));
            img.setImageResource(bundle.getInt("image"));
        }

    }
}
