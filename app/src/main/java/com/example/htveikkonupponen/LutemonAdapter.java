package com.example.htveikkonupponen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonAdapter extends RecyclerView.Adapter<LutemonAdapter.LutemonViewHolder> {

    private ArrayList<Lutemon> lutemons;

    public LutemonAdapter(ArrayList<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lutemon, parent, false);

        return new LutemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        holder.textViewLutemonInfo.setText(
                "ID: " + lutemon.getId() + "\n" + lutemon.getStats() + "\n" + "Location: " + lutemon.getLocation());

        switch (lutemon.getColor()) {
            case "White":
                holder.imageViewLutemon.setImageResource(R.drawable.white_lutemon);
                break;
            case "Green":
                holder.imageViewLutemon.setImageResource(R.drawable.green_lutemon);
                break;
            case "Pink":
                holder.imageViewLutemon.setImageResource(R.drawable.pink_lutemon);
                break;
            case "Orange":
                holder.imageViewLutemon.setImageResource(R.drawable.orange_lutemon);
                break;
            case "Black":
                holder.imageViewLutemon.setImageResource(R.drawable.black_lutemon);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    public static class LutemonViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewLutemon;
        TextView textViewLutemonInfo;

        public LutemonViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewLutemon = itemView.findViewById(R.id.imageViewLutemon);
            textViewLutemonInfo = itemView.findViewById(R.id.textViewLutemonInfo);
        }
    }
}