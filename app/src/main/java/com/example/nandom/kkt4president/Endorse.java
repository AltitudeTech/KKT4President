package com.example.nandom.kkt4president;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.nandom.kkt4president.apollographql.MyApolloClient;

import org.w3c.dom.Text;

import javax.annotation.Nonnull;

public class Endorse extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    private static final String TAG = "Endorsements";
    private String t1, t2, d1, d2;
    private ProgressDialog progressDialog;

    private TextView tvEndorserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endorse);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.enodorsement_title));

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Fetching Graphql Data");
//        progressDialog.setTitle("Graphql Fetch");
//        progressDialog.show();


//        tvEndorserName = (TextView) findViewById(R.id.tvEndorserName);

        dynamicToolbarColor();

        toolbarTextAppernce();

//        getPosts();

    }


    private void dynamicToolbarColor() {
                collapsingToolbarLayout.setContentScrimColor(Color.parseColor("#03183a"));
                collapsingToolbarLayout.setStatusBarScrimColor(Color.parseColor("#03183a"));
    }


    private void toolbarTextAppernce() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

//    private void getPosts() {
//
//        MyApolloClient.getMyApolloClient().query(CurrentTimeQuery.builder().build()).enqueue(new ApolloCall.Callback<CurrentTimeQuery.Data>() {
//            @Override
//            public void onResponse(@Nonnull Response<CurrentTimeQuery.Data> response) {
//
//                t1 = response.data().nextEvent().toString();
//
//                progressDialog.dismiss();
//                if(t1 != null) {
//                    Log.d(TAG, "It works" + t1);
//                }else{
//                    Log.d(TAG, "It doesnt work");
//                }
//                Endorse.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.d(TAG, "It works" + t1);
//                        Toast.makeText(Endorse.this, "This thing is working "+ t1, Toast.LENGTH_SHORT).show();
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
//                Endorse.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.d(TAG, "There is problem");
//                        Toast.makeText(Endorse.this, "This thing is not working "+ error, Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });
//
//    }
}
