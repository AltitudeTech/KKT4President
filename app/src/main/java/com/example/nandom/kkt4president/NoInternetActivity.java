package com.example.nandom.kkt4president;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.nandom.kkt4president.classes.ConnectionDetector;
import com.example.nandom.kkt4president.fragments.GalleryMainFragment;
import com.example.nandom.kkt4president.fragments.NewsMainFragment;

public class NoInternetActivity extends AppCompatActivity {

    private Button bRefresh;
    ConnectionDetector cd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Initializing Connection Detector
        cd = new ConnectionDetector(NoInternetActivity.this);

        bRefresh = (Button) findViewById(R.id.bRefresh);


        bRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cd.isConnected()) {
                    Intent refresh = new Intent(NoInternetActivity.this, NoInternetActivity.class);
                    startActivity(refresh);
                    NoInternetActivity.this.finish();
                }else{
                    Intent surveyIntent = new Intent(NoInternetActivity.this, OnlineSurvey.class);
                    surveyIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(surveyIntent);
                }
            }
        });

    }

}

