package com.example.nandom.kkt4president;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.nandom.kkt4president.apollographql.MyApolloClient;

import javax.annotation.Nonnull;

public class Events extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private TextView tvEndorserName;
    private static final String TAG = "Events";
    private String t1, t2, d1, d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvEndorserName = (TextView) findViewById(R.id.tvEndorserName);

//        getPosts();
    }

//    private void getPosts() {
//
//        MyApolloClient.getMyApolloClient().query(CurrentTimeQuery.builder().build()).enqueue(new ApolloCall.Callback<CurrentTimeQuery.Data>() {
//            @Override
//            public void onResponse(@Nonnull Response<CurrentTimeQuery.Data> response) {
//
//                t1 = response.data().nextEvent.title;
//
//                progressDialog.dismiss();
//                if(t1 != null) {
//                    Log.d(TAG, "It works" + t1);
//                }else{
//                    Log.d(TAG, "It doesnt work");
//                }
//                Events.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.d(TAG, "It works" + t1);
//                        Toast.makeText(Events.this, "This thing is working "+ t1, Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(@Nonnull ApolloException e) {
//                progressDialog.dismiss();
//
//                final String error = e.toString();
//
//                Events.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.d(TAG, "There is problem");
//                        Toast.makeText(Events.this, "This thing is not working "+ error, Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });
//
//    }
}
