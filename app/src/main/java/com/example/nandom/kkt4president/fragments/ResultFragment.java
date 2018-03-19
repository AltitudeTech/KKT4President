package com.example.nandom.kkt4president.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nandom.kkt4president.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;


public class ResultFragment extends Fragment{

    public ResultFragment() {

        // Required empty public constructor
    }

    BarChart chart;
    ArrayList<BarEntry> BARENTRY;
    ArrayList<String> BarEntryLabels;
    BarDataSet Bardataset;
    BarData BARDATA ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        chart = (BarChart) view.findViewById(R.id.chart1);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Answers");

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.setBorderWidth(1f);
        chart.getYChartMax();
        chart.setVisibleYRangeMaximum(88f, null);

        Toast.makeText(getContext(), chart.getYChartMax()+"", Toast.LENGTH_LONG).show();


        chart.animateY(3000);

        // Inflate the layout for this fragment
        return view;
    }

    private void AddValuesToBarEntryLabels() {
        BarEntryLabels.add("Excellent");
        BarEntryLabels.add("Good");
        BarEntryLabels.add("Fair");
        BarEntryLabels.add("Bad");
        BarEntryLabels.size();
    }

    private void AddValuesToBARENTRY() {

        BARENTRY.add(new BarEntry(20f, 0));
        BARENTRY.add(new BarEntry(40f, 1));
        BARENTRY.add(new BarEntry(60f, 2));
        BARENTRY.add(new BarEntry(80f, 3));

    }

    public float getYChartMax() {
        return 88f;
    }

}