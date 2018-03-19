package com.example.nandom.kkt4president.youfirstslider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nandom.kkt4president.FirstThirtyDays;
import com.example.nandom.kkt4president.Manifesto;
import com.example.nandom.kkt4president.UrgentIssues;
import com.example.nandom.kkt4president.YOUFIRST;
import com.example.nandom.kkt4president.R;

public class MyFragment extends Fragment {

    public static Fragment newInstance(YOUFIRST context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        b.putFloat("scale", scale);
        return Fragment.instantiate(context, MyFragment.class.getName(), b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout l = (LinearLayout)
                inflater.inflate(R.layout.mf, container, false);

        int pos = this.getArguments().getInt("pos");
        RelativeLayout rlContent = (RelativeLayout) l.findViewById(R.id.content);
        Button bView = (Button) l.findViewById(R.id.bView);
        ImageView ivYouFirst = (ImageView) l.findViewById(R.id.iv_you_first);
        TextView tvTitle = (TextView) l.findViewById(R.id.you_first_title);
        TextView tvSubtitle = (TextView) l.findViewById(R.id.you_first_subtitle);

        if (pos == 0) {
            tvTitle.setText("Urgent Issues");
            tvSubtitle.setText("Critical Issues Facing Nigeria");
            rlContent.setBackgroundColor(Color.parseColor("#dc3545"));
            ivYouFirst.setImageResource(R.drawable.urgent_issues);
            bView.setBackgroundColor(Color.parseColor("#dc3545"));

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent issuesIntent = new Intent(getContext(), UrgentIssues.class);
                    startActivity(issuesIntent);
                }
            });
            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent issuesIntent = new Intent(getContext(), UrgentIssues.class);
                    startActivity(issuesIntent);
                }
            });

        }else if (pos == 1) {
            tvTitle.setText("First 30 days");
            tvSubtitle.setText("Course of Action within the First 30 days");
            rlContent.setBackgroundColor(Color.parseColor("#03183a"));
            ivYouFirst.setImageResource(R.drawable.thirty_days);
            bView.setBackgroundColor(Color.parseColor("#03183a"));

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent issuesIntent = new Intent(getContext(), FirstThirtyDays.class);
                    startActivity(issuesIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent issuesIntent = new Intent(getContext(), FirstThirtyDays.class);
                    startActivity(issuesIntent);
                }
            });

        }else if (pos == 2) {
            tvTitle.setText("Manifesto");
            tvSubtitle.setText("Agenda");
            rlContent.setBackgroundColor(Color.parseColor("#aaaaaa"));
            ivYouFirst.setImageResource(R.drawable.agenda_white);
            bView.setBackgroundColor(Color.parseColor("#aaaaaa"));

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent manifestoIntent = new Intent(getContext(), Manifesto.class);
                    startActivity(manifestoIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent manifestoIntent = new Intent(getContext(), Manifesto.class);
                    startActivity(manifestoIntent);
                }
            });


        }

        MyLinearLayout root = (MyLinearLayout) l.findViewById(R.id.root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return l;
    }
}
