package com.example.nandom.kkt4president.classes;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.nandom.kkt4president.R;

import java.util.ArrayList;

/**
 * Created by Nandom on 3/21/2018.
 */
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<News> data= Collections.emptyList();
    News current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public NewsAdapter(Context context, List<News> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.news_model, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        News current=data.get(position);
        myHolder.tvTitle.setText(current.getTitle());
//        myHolder.textSize.setText("Size: " + current.sizeName);
//        myHolder.textType.setText("Category: " + current.catName);
//        myHolder.textPrice.setText("Rs. " + current.price + "\\Kg");
//        myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

//        // load image into imageview using glide
//        Glide.with(context).load("http://192.168.1.7/test/images/" + current.fishImage)
//                .placeholder(R.drawable.ic_img_error)
//                .error(R.drawable.ic_img_error)
//                .into(myHolder.ivFish);

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        ImageView ivFish;
        TextView textSize;
        TextView textType;
        TextView textPrice;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.newsTitle);
//            ivFish= (ImageView) itemView.findViewById(R.id.ivFish);
//            textSize = (TextView) itemView.findViewById(R.id.textSize);
//            textType = (TextView) itemView.findViewById(R.id.textType);
//            textPrice = (TextView) itemView.findViewById(R.id.textPrice);
        }

    }

}