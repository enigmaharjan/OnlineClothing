package com.example.onlineclothing;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.ClothesViewHolder> {

    Context mContext;
    List<Clothes> clothesList;

    public ClothesAdapter(Context mContext, List<Clothes> clothesList) {
        this.mContext = mContext;
        this.clothesList = clothesList;
    }

    @NonNull
    @Override
    public ClothesAdapter.ClothesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        return  new ClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothesAdapter.ClothesViewHolder clothesViewHolder, int i) {

        final Clothes clothes = clothesList.get(i);
        clothesViewHolder.imgItem.setImageResource(clothes.getImage());
        clothesViewHolder.tvItemName.setText(clothes.getItemName());

        clothesViewHolder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ItemDescription.class);
                i.putExtra("itemName", clothes.getItemName());
                i.putExtra("price", clothes.getPrice());
                i.putExtra("description", clothes.getItemDescription());
                i.putExtra("image", clothes.getImage());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clothesList.size();
    }

    public class ClothesViewHolder extends  RecyclerView.ViewHolder{

        CircleImageView imgItem;
        TextView tvItemName;
        public ClothesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItemPic);
            tvItemName = itemView.findViewById(R.id.tvItemName);
        }
    }
}
