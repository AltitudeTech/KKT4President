package com.example.nandom.kkt4president;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.nandom.kkt4president.apollographql.MyApolloClient;
import com.example.nandom.kkt4president.classes.KttTv;
import com.example.nandom.kkt4president.classes.KttTvAdapter;
import com.example.nandom.kkt4president.classes.RecyclerTouchListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import pl.droidsonroids.gif.GifImageView;

public class KTTTelevision extends AppCompatActivity {

    private static final String TAG = "KTTTelevision";

    private RecyclerView recyclerView;

    private KttTvAdapter mKttTvAdapter;

    private List<KttTv> kttTvList = new ArrayList<>();

    private ImageView ivKttTv;
    private TextView tvTitle;
    private GifImageView loadingKTTTv;



    private String[] thumbnailUrl = new String[10];
    private String[] title = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ktttelevision);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        loadingKTTTv = (GifImageView) findViewById(R.id.loadingKTTTV);

        mKttTvAdapter = new KttTvAdapter(kttTvList, this);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mKttTvAdapter);


        ivKttTv = (ImageView) findViewById(R.id.videoThumbnail);
        tvTitle = (TextView) findViewById(R.id.tvTitle);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                KttTv kttTv = kttTvList.get(position);
                Toast.makeText(getApplicationContext(), kttTv.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        getPosts();
    }

    private void getPosts() {

        MyApolloClient.getMyApolloClient().query(KttvVideosQuery.builder().build()).enqueue(new ApolloCall.Callback<KttvVideosQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<KttvVideosQuery.Data> response) {

                int kttvSize = response.data().KttvPagination.items.size();

//                final String main = response.data().KttvPagination.items().get(0).toString();
//                final String youtubeId = response.data().KttvPagination.items().get(i).youtubeId.toString();


                thumbnailUrl[0] = response.data().KttvPagination.items().get(0).thumbnailUrl.toString();
                title[0] = response.data().KttvPagination.items().get(0).title.toString();

                thumbnailUrl[1] = response.data().KttvPagination.items().get(1).thumbnailUrl.toString();
                title[1] = response.data().KttvPagination.items().get(1).title.toString();

                thumbnailUrl[2] = response.data().KttvPagination.items().get(2).thumbnailUrl.toString();
                title[2] = response.data().KttvPagination.items().get(2).title.toString();

                thumbnailUrl[3] = response.data().KttvPagination.items().get(3).thumbnailUrl.toString();
                title[3] = response.data().KttvPagination.items().get(3).title.toString();

                thumbnailUrl[4] = response.data().KttvPagination.items().get(4).thumbnailUrl.toString();
                title[4] = response.data().KttvPagination.items().get(4).title.toString();

                thumbnailUrl[5] = response.data().KttvPagination.items().get(5).thumbnailUrl.toString();
                title[5] = response.data().KttvPagination.items().get(5).title.toString();

                thumbnailUrl[6] = response.data().KttvPagination.items().get(6).thumbnailUrl.toString();
                title[6] = response.data().KttvPagination.items().get(6).title.toString();

                thumbnailUrl[7] = response.data().KttvPagination.items().get(7).thumbnailUrl.toString();
                title[7] = response.data().KttvPagination.items().get(7).title.toString();

                final int size = response.data().KttvPagination.items().size();

                final int two = response.data().KttvPagination.items().size();

                KTTTelevision.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadingKTTTv.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);

                        for (int i = 0; i < size; i++) {

//                            KttTv kttTv = new KttTv(title[i], thumbnailUrl[i]);

                            KttTv kttTv = new KttTv(title[i], thumbnailUrl[i]);
//                            kttTv.setTitle(title[i]);
                            kttTv.setImageThumbnail(thumbnailUrl[i]);
                            kttTvList.add(kttTv);

//                            tvTitle.setText(getTitle());

                        }

                        mKttTvAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {
                Toast.makeText(KTTTelevision.this, "This is an error", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse Error");
            }
        });
    }

}
