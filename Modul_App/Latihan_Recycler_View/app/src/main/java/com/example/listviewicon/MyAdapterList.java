package com.example.listviewicon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterList extends RecyclerView.Adapter<MyAdapterList.ViewHolder> {
    private final Data[] data;


    public MyAdapterList(Data[] data) {
        this.data = data;
    }


    @NonNull
    @Override
    public MyAdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        View listItem = layout.inflate(R.layout.list_item, parent, false);

        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterList.ViewHolder holder, int position) {
        final Data data = this.data[position];

        holder.imageView.setImageResource(data.getImageView());
        holder.title.setText(data.getTitle());
        holder.desc.setText(data.getDesc());
    }

    @Override
    public int getItemCount() {
        return this.data.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title, desc;
        public CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.card = itemView.findViewById(R.id.cardView);
            this.title = itemView.findViewById(R.id.list_title);
            this.desc = itemView.findViewById(R.id.list_desc);
            this.imageView = itemView.findViewById(R.id.list_img);
        }

    }
}
