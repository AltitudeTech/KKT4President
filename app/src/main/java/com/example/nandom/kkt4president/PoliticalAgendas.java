package com.example.nandom.kkt4president;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PoliticalAgendas extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    private TextView tvAgendaTitle;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_political_agendas);

        Bundle bundle = getIntent().getExtras();

        String agendaNumber = bundle.getString("agenda");
        String title = bundle.getString("title");

        String text2 = "<font color=#fff>Policy </font> <font color=#dc3545>"+ agendaNumber +"</font>";

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvAgendaTitle = (TextView) findViewById(R.id.tvAgendaTitle);

        tvAgendaTitle.setText(title);
//        tvAgendaTitle.setText(getResources().getText(R.string.hello));
//        tvAgendaTitle.setTextColor(R.color.ash);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Policy " + agendaNumber);


        dynamicToolbarColor();

        toolbarTextAppernce();
    }

    private void dynamicToolbarColor() {
        collapsingToolbarLayout.setContentScrimColor(Color.parseColor("#323e65"));
        collapsingToolbarLayout.setStatusBarScrimColor(Color.parseColor("#323e65"));
    }

    private void toolbarTextAppernce() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar_you_first);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
