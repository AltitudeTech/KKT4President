package com.example.nandom.kkt4president.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.nandom.kkt4president.Gallery;
import com.example.nandom.kkt4president.R;

/**
 * Created by Nandom on 3/27/2018.
 */

public class NoInternet extends Fragment {

    private Button bRefresh;
    private String myValue;

    public static NoInternet newInstance() {
        // Required empty public constructor
        NoInternet fragment = new NoInternet();
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
        View view = inflater.inflate(R.layout.no_internet_layout, container, false);

        bRefresh = (Button) view.findViewById(R.id.bRefresh);

        final String myValue = this.getArguments().getString("message");
//
//        if (myValue.contentEquals("NoInternet")) {
//            bRefresh.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    // Refresh main activity upon close of dialog box
////                    Intent refresh = new Intent(getContext(), NewsMainFragment.class);
////                    startActivity(refresh);
////                    getActivity().finish();
//                }
//            });
//
//        } else if (myValue.contentEquals("Gallery")) {
//            bRefresh.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    // Refresh main activity upon close of dialog box
//                    Toast.makeText(getContext(), myValue, Toast.LENGTH_SHORT).show();
//                    Intent refresh = new Intent(getActivity(), Gallery.class);
//                    startActivity(refresh);
//                    getActivity().finish(); //
//                }
//            });
//
//        }

        if(myValue.contentEquals("NoInternetGallery")) {
            bRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Refresh main activity upon close of dialog box
                    Toast.makeText(getContext(), myValue, Toast.LENGTH_SHORT).show();
                    Intent refresh = new Intent(getActivity(), Gallery.class);
                    startActivity(refresh);
                    getActivity().finish(); //
                }
            });
        }else if(myValue.contentEquals("NoInternetNews")){
            bRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Refresh main activity upon close of dialog box
                    NewsMainFragment newsFragment = new NewsMainFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.news_frame_layout, newsFragment);
                    fragmentTransaction.commit();
                }
            });
        }
        return view;
    }



}