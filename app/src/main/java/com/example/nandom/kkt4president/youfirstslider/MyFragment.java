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
import com.example.nandom.kkt4president.PoliticalAgendas;
import com.example.nandom.kkt4president.UrgentIssues;
import com.example.nandom.kkt4president.YOUFIRST;
import com.example.nandom.kkt4president.R;

public class MyFragment extends Fragment {

    private String currentNumber, currentTitle, currentColor;
    private int currentImage;
    private Intent currentIntent;

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
            currentNumber = "#1";
            currentTitle = "Leadership Governance & Anti-Corruption";
            currentColor = "#dc3545";
            currentImage = R.drawable.leadership;

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#1");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);

                }
            });
            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#1");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

        }else if (pos == 1) {

            currentNumber = "#2";
            currentTitle = "Security, Law & Order";
            currentColor = "#673AB7";
            currentImage = R.drawable.security_centre;

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#2");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#2");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

        }else if (pos == 2) {

            currentNumber = "#3";
            currentTitle = "Infrastructure";
            currentColor = "#aaaaaa";
            currentImage = R.drawable.infrastructure;

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#3");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#3");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });
        }else if (pos == 3) {

            currentNumber = "#4";
            currentTitle = "Education";
            currentColor = "#FF5722";
            currentImage = R.drawable.education;

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#4");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#4");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });
        }else if (pos == 4) {

            currentNumber = "#5";
            currentTitle = "Economy";
            currentColor = "#4CAF50";
            currentImage = R.drawable.economy;

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#5");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#5");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });
        }else if (pos == 5) {

            currentNumber = "#6";
            currentTitle = "Health & Wellbeing";
            currentColor = "#00BCD4";
            currentImage = R.drawable.health;

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#6");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#6");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });
        }else if (pos == 6) {

            currentNumber = "#7";
            currentTitle = "Technology";
            currentColor = "#F44336";
            currentImage = R.drawable.technology;

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#7");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#7");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });
        }else if (pos == 7) {

            currentNumber = "#8";
            currentTitle = "Implementation";
            currentColor = "#03183a";
            currentImage = R.drawable.implementation;

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#8");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#8");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });
        }else if (pos == 8) {

            currentNumber = "#9";
            currentTitle = "Impact Assessment & Results";
            currentColor = "#aaaaaa";
            currentImage = R.drawable.results;

            bView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#9");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });

            rlContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIntent = new Intent(getContext(), PoliticalAgendas.class);
                    currentIntent.putExtra("agenda", "#9");
                    currentIntent.putExtra("title", currentTitle);
                    startActivity(currentIntent);
                }
            });
        }

        tvTitle.setText(currentNumber);
        tvSubtitle.setText(currentTitle);
        rlContent.setBackgroundColor(Color.parseColor(currentColor));
        ivYouFirst.setImageResource(currentImage);
        bView.setBackgroundColor(Color.parseColor(currentColor));

        MyLinearLayout root = (MyLinearLayout) l.findViewById(R.id.root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return l;
    }
}
