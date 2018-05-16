package com.example.nandom.kkt4president.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.nandom.kkt4president.LastPollsQuery;
import com.example.nandom.kkt4president.R;
import com.example.nandom.kkt4president.apollographql.MyApolloClient;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import org.w3c.dom.Text;

import java.util.ArrayList;

import javax.annotation.Nonnull;

import pl.droidsonroids.gif.GifImageView;


public class ResultFragment extends Fragment{

    public ResultFragment() {

        // Required empty public constructor
    }

    BarChart chart;
    ArrayList<BarEntry> BARENTRY;
    ArrayList<String> BarEntryLabels;
    BarDataSet Bardataset;
    BarData BARDATA;

    private String selectedTagLine;

    private TextView tvTagLine;
    private TextView tvLastQuestion;

    private String Aquestion1, AoptionA, AoptionB, AoptionC, AoptionD;

    private double AtotalVotes, AVotesa, AVotesb, AVotesc, AVotesd;
    private double BtotalVotes, BVotesa, BVotesb, BVotesc, BVotesd;

    private String Bquestion1, BoptionA, BoptionB, BoptionC, BoptionD;
    private String AtagLine1, AtagLine2, AtagLine3, AtagLine4;
    private String BtagLine1, BtagLine2, BtagLine3, BtagLine4;

    GifImageView loadingGif;
    private ScrollView llQuestion;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        loadingGif = (GifImageView) view.findViewById(R.id.loadingGif);
        llQuestion = (ScrollView) view.findViewById(R.id.svLayout);

        tvTagLine = (TextView) view.findViewById(R.id.tvTextResult);
        tvLastQuestion = (TextView) view.findViewById(R.id.tvLastQuestion);


        chart = (BarChart) view.findViewById(R.id.chart1);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY(80f, 60f, 40f, 20f);

        AddValuesToBarEntryLabels("Yes", "No", "Sure", "Maybe");

        Bardataset = new BarDataSet(BARENTRY, "Answers");

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.setBorderWidth(1f);
        chart.getYChartMax();
        chart.setVisibleYRangeMaximum(88f, null);

        chart.animateY(3000);

        getLastPoll();

        return view;
    }

    private void AddValuesToBarEntryLabels(String option1, String option2,
                                           String option3, String option4) {
        BarEntryLabels.add(option1);
        BarEntryLabels.add(option2);
        BarEntryLabels.add(option3);
        BarEntryLabels.add(option4);
        BarEntryLabels.size();
    }

    private void AddValuesToBARENTRY(Float value1, Float value2, Float value3, Float value4) {

        BARENTRY.add(new BarEntry(value1, 0));
        BARENTRY.add(new BarEntry(value2, 1));
        BARENTRY.add(new BarEntry(value3, 2));
        BARENTRY.add(new BarEntry(value4, 3));

    }

    public float getYChartMax() {
        return 88f;
    }

    public void getLastPoll() {

        MyApolloClient.getMyApolloClient().query(LastPollsQuery.builder().build()).enqueue(new ApolloCall.Callback<LastPollsQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<LastPollsQuery.Data> response) {

                Aquestion1 = response.data().lastPolls().get(0).title().toString();
                AtotalVotes = response.data().lastPolls().get(0).totalVotes();

                AtagLine1 = response.data().lastPolls().get(0).option1().tagLine();
                AtagLine2 = response.data().lastPolls().get(0).option2().tagLine();
                AtagLine3 = response.data().lastPolls().get(0).option3().tagLine();
                AtagLine4 = response.data().lastPolls().get(0).option4().tagLine();

                AVotesa = response.data().lastPolls().get(0).aVotes();
                AVotesb = response.data().lastPolls().get(0).bVotes();
                AVotesc = response.data().lastPolls().get(0).cVotes();
                AVotesd = response.data().lastPolls().get(0).dVotes();

                AoptionA = response.data().lastPolls().get(0).option1().text();
                AoptionB = response.data().lastPolls().get(0).option2().text();
                AoptionC = response.data().lastPolls().get(0).option3().text();
                AoptionD = response.data().lastPolls().get(0).option4().text();

                Aquestion1 = response.data().lastPolls().get(0).title().toString();
                AtotalVotes = response.data().lastPolls().get(0).totalVotes();

                Bquestion1 = response.data().lastPolls().get(1).title().toString();
                BtotalVotes = response.data().lastPolls().get(1).totalVotes();

                BtagLine1 = response.data().lastPolls().get(1).option1().tagLine();
                BtagLine2 = response.data().lastPolls().get(1).option2().tagLine();
                BtagLine3 = response.data().lastPolls().get(1).option3().tagLine();
                BtagLine4 = response.data().lastPolls().get(1).option4().tagLine();

                BVotesa = response.data().lastPolls().get(1).aVotes();
                BVotesb = response.data().lastPolls().get(1).bVotes();
                BVotesc = response.data().lastPolls().get(1).cVotes();
                BVotesd = response.data().lastPolls().get(1).dVotes();

                BoptionA = response.data().lastPolls().get(1).option1().text();
                BoptionB = response.data().lastPolls().get(1).option2().text();
                BoptionC = response.data().lastPolls().get(1).option3().text();
                BoptionD = response.data().lastPolls().get(1).option4().text();

                Aquestion1 = response.data().lastPolls().get(1).title().toString();
                AtotalVotes = response.data().lastPolls().get(1).totalVotes();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadingGif.setVisibility(View.GONE);
                        llQuestion.setVisibility(View.VISIBLE);

                        Double maxNumber = Math.max((Math.max(BVotesa, BVotesb)), (Math.max(BVotesc, BVotesd)));

                        if(BVotesa == maxNumber){
                            selectedTagLine = BtagLine1;
                        }else if(BVotesb == maxNumber){
                            selectedTagLine = BtagLine2;
                        }else if(BVotesc == maxNumber){
                            selectedTagLine = BtagLine3;
                        }else if(BVotesd == maxNumber){
                            selectedTagLine = BtagLine4;
                        }

                        double percentage = Math.floor((maxNumber / AtotalVotes) * 100);
                        Double d = new Double(percentage);
                        int another = d.intValue();

                        tvTagLine.setText(another + "% of Responsdents " + selectedTagLine);
                        tvLastQuestion.setText(Bquestion1);
                        System.out.println("question:"+ selectedTagLine);
//                        System.out.println("question:" + Aquestion1 + "  " + AtotalVotes + " " + AoptionA + " " + AoptionB + " " + AoptionC + " " + AoptionD);

                    }
                });
            }

            @Override
            public void onFailure(@Nonnull final ApolloException e) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Nothing is working" + e, Toast.LENGTH_LONG).show();
                        System.out.println("something " + e);
                    }
                });
            }
        });
    }

}