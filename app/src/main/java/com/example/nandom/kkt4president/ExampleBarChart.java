package com.example.nandom.kkt4president;

import android.content.Context;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.BarChart;

/**
 * Created by Nandom on 3/9/2018.
 */

public class ExampleBarChart extends BarChart {
    public ExampleBarChart(Context context) {
        super(context);
    }
    public ExampleBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExampleBarChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public float getYChartMax() {
        return 89f;
    }
}
