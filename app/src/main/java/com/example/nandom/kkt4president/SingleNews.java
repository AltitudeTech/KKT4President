package com.example.nandom.kkt4president;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class SingleNews extends AppCompatActivity {

    private ImageView newsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_news);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        newsImage = (ImageView) findViewById(R.id.newsImage);

//        String selected = getIntent().getStringExtra("image_selected");
//
//        if (selected.contentEquals("image1")){
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                newsImage.setImageDrawable(getDrawable(R.drawable.new_one));
//            }
//
//        }else if(selected.contentEquals("image2")){
//
//        }else{
//
//        }


    }
}
