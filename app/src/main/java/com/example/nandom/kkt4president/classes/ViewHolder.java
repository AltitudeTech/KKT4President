package com.example.nandom.kkt4president.classes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.nandom.kkt4president.R;

/**
 * Created by Nandom on 3/21/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    //Views
    public TextView tvTitle;

    AdapterView.OnItemClickListener itemClickListener;

    //Initializing Views
    public ViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.newsTitle);



    }
}
