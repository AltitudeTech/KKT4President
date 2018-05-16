package com.example.nandom.kkt4president;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.nandom.kkt4president.adapter.GalleryAdapter;
import com.example.nandom.kkt4president.app.AppController;
import com.example.nandom.kkt4president.classes.ConnectionDetector;
import com.example.nandom.kkt4president.fragments.GalleryFragment;
import com.example.nandom.kkt4president.fragments.NoInternet;
import com.example.nandom.kkt4president.model.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    ConnectionDetector cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Fragment selectedFragment = null;
        FragmentTransaction transaction = null;

        cd = new ConnectionDetector(this);

        if (cd.isConnected()) {
            Bundle bundle = new Bundle();
            String myMessage = "Gallery";
            bundle.putString("message", myMessage );
            selectedFragment = GalleryFragment.newInstance();
            selectedFragment.setArguments(bundle);

        } else {
//            Intent internetFailure = new Intent(Gallery.this, ConnectionFailure.class);
//            internetFailure.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(internetFailure);
            Bundle bundle = new Bundle();
            String myMessage = "NoInternetGallery";
            bundle.putString("message", myMessage );
            selectedFragment = NoInternet.newInstance();
            selectedFragment.setArguments(bundle);
        }

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.gallery_frame_layout, selectedFragment);
        transaction.commit();
    }



}