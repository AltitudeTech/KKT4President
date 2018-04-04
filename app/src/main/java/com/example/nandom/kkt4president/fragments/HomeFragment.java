package com.example.nandom.kkt4president.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nandom.kkt4president.Events;
import com.example.nandom.kkt4president.KTTTelevision;
import com.example.nandom.kkt4president.OnlineSurvey;
import com.example.nandom.kkt4president.R;
import com.example.nandom.kkt4president.YOUFIRST;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private CardView kttTVCard, opinionCard, eventsCard, yez;
    private Button bAbout;
    private Fragment selectedFragment = null;
    private BottomNavigationView bottomNavigationView;

    public static HomeFragment newInstance() {
        // Required empty public constructor
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        kttTVCard = (CardView) view.findViewById(R.id.ktt_tv_card);
        opinionCard = (CardView) view.findViewById(R.id.opinion_card);
        eventsCard = (CardView) view.findViewById(R.id.events_card);
        yez = (CardView) view.findViewById(R.id.ktt_yez_card);

        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.navigation);


        kttTVCard.setOnClickListener(this);
        opinionCard.setOnClickListener(this);
        eventsCard.setOnClickListener(this);
        yez.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ktt_tv_card:
                Intent kttIntent = new Intent(getContext(), KTTTelevision.class);
                startActivity(kttIntent);
                break;
            case R.id.opinion_card:
                Intent galleryIntent = new Intent(getContext(), OnlineSurvey.class);
                startActivity(galleryIntent);
                break;
            case R.id.events_card:
                Intent youFirstIntent = new Intent(getContext(), Events.class);
                startActivity(youFirstIntent);
                break;
            case R.id.ktt_yez_card:
                Intent yezIntent = new Intent(getContext(), YOUFIRST.class);
                startActivity(yezIntent);
                break;
        }
    }
}
