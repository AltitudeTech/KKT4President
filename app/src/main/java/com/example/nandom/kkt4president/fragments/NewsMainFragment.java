package com.example.nandom.kkt4president.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.nandom.kkt4president.Gallery;
import com.example.nandom.kkt4president.R;
import com.example.nandom.kkt4president.app.AppController;
import com.example.nandom.kkt4president.classes.Config;
import com.example.nandom.kkt4president.classes.ConnectionDetector;
import com.example.nandom.kkt4president.classes.News;
import com.example.nandom.kkt4president.adapter.NewsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsMainFragment extends Fragment {

    private static final String TAG = NewsMainFragment.class.getSimpleName();
    private RelativeLayout rlNews1, rlNews2, rlNews3;

    private RecyclerView recyclerView;

    private ListView listView;
    private NewsAdapter listAdapter;
    private List<News> feedItems;


    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private RecyclerView mRVFishPrice;
    private NewsAdapter mAdapter;

    private ArrayList<News> newsList;

    private News news;

    ConnectionDetector cd;

    private ProgressDialog progressDialog;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private RequestQueue requestQueue;

    private int requestCount = 1;

    Fragment selectedFragment = null;
    FragmentTransaction transaction = null;



    public static NewsMainFragment newInstance() {
        // Required empty public constructor
        NewsMainFragment fragment = new NewsMainFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_main, container, false);

        //Initializing Connection Detector
        cd = new ConnectionDetector(getContext());

        if (cd.isConnected()) {
            selectedFragment = NewsFragment.newInstance();

        } else {
//            Intent internetFailure = new Intent(Gallery.this, ConnectionFailure.class);
//            internetFailure.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(internetFailure);
            Bundle bundle = new Bundle();
            String myMessage = "NoInternetNews";
            bundle.putString("message", myMessage);
            selectedFragment = NoInternet.newInstance();
            selectedFragment.setArguments(bundle);
        }

        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.news_frame_layout, selectedFragment);
        transaction.commit();

        return view;
    }
}

