package com.example.nandom.kkt4president.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.nandom.kkt4president.R;
import com.example.nandom.kkt4president.adapter.NewsAdapter;
import com.example.nandom.kkt4president.app.AppController;
import com.example.nandom.kkt4president.classes.Config;
import com.example.nandom.kkt4president.classes.ConnectionDetector;
import com.example.nandom.kkt4president.classes.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private static final String TAG = NewsFragment.class.getSimpleName();
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


    public static NewsFragment newInstance() {
        // Required empty public constructor
        NewsFragment fragment = new NewsFragment();
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
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        listView = (ListView) view.findViewById(R.id.event_recycler);

        feedItems = new ArrayList<News>();

        listAdapter = new com.example.nandom.kkt4president.adapter.NewsAdapter(getActivity(), feedItems);
        listView.setAdapter(listAdapter);

        progressDialog = new ProgressDialog(getContext());

        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading News");
        progressDialog.show();


        // We first check for cached request
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(Config.DATA_URL);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJsonFeed(new JSONObject(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            // making fresh volley request and getting json
            JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                    Config.DATA_URL, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    VolleyLog.d(TAG, "Response: " + response.toString());
                    if (response != null) {
                        parseJsonFeed(response);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });

            // Adding request to volley request queue
            AppController.getInstance().addToRequestQueue(jsonReq);
        }




        //Initializing the object of the ConnectionDetection Class
//        cd = new ConnectionDetector(getContext());


//        //Initializing Views
//        recyclerView = (RecyclerView) view.findViewById(R.id.event_recycler);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//
//        // We first check for cached request
//        Cache cache = AppController.getInstance().getRequestQueue().getCache();
//        Cache.Entry entry = cache.get(Config.DATA_URL);
//        if (entry != null) {
//            // fetch the data from cache
//            try {
//                String data = new String(entry.data, "UTF-8");
//                try {
//                    parseData(new JSONObject(data));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            // making fresh volley request and getting json
//            JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
//                    Config.DATA_URL, null, new Response.Listener<JSONObject>() {
//
//                @Override
//                public void onResponse(JSONObject response) {
//                    VolleyLog.d(TAG, "Response: " + response.toString());
//                    if (response != null) {
//                        parseData(response);
//                    }
//                }
//            }, new Response.ErrorListener() {
//
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    VolleyLog.d(TAG, "Error: " + error.getMessage());
//                }
//            });
//
//            // Adding request to volley request queue
//            AppController.getInstance().addToRequestQueue(jsonReq);
//        }
//
//        return view;
//    }
//
//    //This method will parse json data
//    private void parseData(JSONObject response) {
//
//        try {
//            JSONArray array = response.getJSONArray("gistMany");
//
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject eventObj = (JSONObject) array.get(i);
//
//                News news = new News();
//
//                //Adding data to the news object
////                news.setImageUrl(eventObj.getString(Config.TAG_IMAGE_URL));
//                news.setTitle(eventObj.getString(Config.TAG_TITLE));
//                news.setDate(eventObj.getString(Config.TAG_DATE));
//                news.setId(eventObj.getInt(Config.TAG_ID));
//
//                newsList.add(news);
//            }
//
//            //Notifying the adapter that data has been added or changed
//            adapter.notifyDataSetChanged();
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//
//        }
//    }
        mRVFishPrice = (RecyclerView)view.findViewById(R.id.recycler_view);
        return view;
    }

    /**
     * Parsing json reponse and passing the data to feed view list adapter
     * */
    private void parseJsonFeed(JSONObject response) {

        progressDialog.hide();
        try {
            JSONArray feedArray = response.getJSONArray("gistMany");

            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                News item = new News();
//                item.setId(feedObj.getInt("_id"));
                item.setTitle(feedObj.getString("title"));
                item.setDate(feedObj.getString("publishedDate"));

//                // Image might be null sometimes
//                String image = feedObj.isNull("image") ? null : feedObj
//                        .getString("image");
//                item.setImge(image);
//                item.setStatus(feedObj.getString("status"));
//                item.setProfilePic(feedObj.getString("profilePic"));
//                item.setTimeStamp(feedObj.getString("timeStamp"));

                // url might be null sometimes
//                String feedUrl = feedObj.isNull("url") ? null : feedObj
//                        .getString("url");
//                item.setUrl(feedUrl);

                feedItems.add(item);
            }

            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

