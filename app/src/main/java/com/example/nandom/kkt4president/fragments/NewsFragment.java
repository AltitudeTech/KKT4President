package com.example.nandom.kkt4president.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.nandom.kkt4president.R;
import com.example.nandom.kkt4president.SingleNews;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private RelativeLayout rlNews1, rlNews2, rlNews3;


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

        rlNews1 = (RelativeLayout) view.findViewById(R.id.rlnews1);
        rlNews2 = (RelativeLayout) view.findViewById(R.id.rlnew2);
        rlNews3 = (RelativeLayout) view.findViewById(R.id.rlnew3);

        rlNews1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent singleNewsIntent = new Intent(getContext(), SingleNews.class);
                startActivity(singleNewsIntent);
            }
        });

        rlNews2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent singleNewsIntent = new Intent(getContext(), SingleNews.class);
                startActivity(singleNewsIntent);
            }
        });

        rlNews3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent singleNewsIntent = new Intent(getContext(), SingleNews.class);
                startActivity(singleNewsIntent);
            }
        });


        return view;
    }

}
