package com.example.nandom.kkt4president.classes;

/**
 * Created by Nandom on 4/6/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nandom.kkt4president.KTTTelevision;
import com.example.nandom.kkt4president.R;
import com.example.nandom.kkt4president.model.Image;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class KttTvAdapter extends RecyclerView.Adapter<KttTvAdapter.MyViewHolder> {

    private List<KttTv> kttTvList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView videoThumbnail;
        public LinearLayout llVideos;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvTitle);
            videoThumbnail = (ImageView) view.findViewById(R.id.videoThumbnail);
            llVideos = (LinearLayout) view.findViewById(R.id.llVideos);
        }
    }

    public KttTvAdapter(List<KttTv> kttTvList, Context context) {
        this.kttTvList = kttTvList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kttv_model, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final KttTv kttTv = kttTvList.get(position);
        holder.title.setText(kttTv.getTitle());
        Picasso.with(context).load(kttTv.getImageThumbnail()).into(holder.videoThumbnail);
        
        holder.llVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, kttTv.getLink(), Toast.LENGTH_SHORT).show();
            }
        });
        
    }

    @Override
    public int getItemCount() {
        return kttTvList.size();
    }
}
