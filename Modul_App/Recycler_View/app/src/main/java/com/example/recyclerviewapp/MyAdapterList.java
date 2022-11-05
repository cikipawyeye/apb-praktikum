package com.example.recyclerviewapp;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyAdapterList extends RecyclerView.Adapter<MyAdapterList.ViewHolder> {
    private DataList[] data;

    public MyAdapterList(DataList[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyAdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.list_item, parent,false);

        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterList.ViewHolder holder, int position) {
        final DataList data = this.data[position];

        holder.imageView.setImageResource(this.data[position].getImageId());
        holder.textTitle.setText(this.data[position].getTitle());
        holder.textPrice.setText(this.data[position].getPrice());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;
            public TextView textTitle, textPrice;
            public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.cardView = (CardView) itemView.findViewById(R.id.cardView);
            this.textPrice = (TextView) itemView.findViewById(R.id.list_price);
            this.textTitle = (TextView) itemView.findViewById(R.id.list_title);
            this.imageView = (ImageView) itemView.findViewById(R.id.list_img);

        }
    }
}
