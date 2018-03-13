package com.example.ayushkumar.graph3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private BarChart chart;
    float barWidth;
    float barSpace;
    float groupSpace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barWidth = 0.3f;
        barSpace = 0f;
        groupSpace = 0.4f;

        chart = (BarChart)findViewById(R.id.barChart);
        chart.setDescription(null);
        chart.setPinchZoom(false);
        chart.setScaleEnabled(false);
        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        int groupCount = 11;

        ArrayList xVals = new ArrayList();

        xVals.add("2 Aug");
        xVals.add("3 Aug");
        xVals.add("4 Aug");
        xVals.add("5 Aug");
        xVals.add("6 Aug");
        xVals.add("7 Aug");
        xVals.add("8 Aug");
        xVals.add("9 Aug");
        xVals.add("10 Aug");
        xVals.add("11 Aug");
        xVals.add("12 Aug");


        ArrayList yVals1 = new ArrayList();
        ArrayList yVals2 = new ArrayList();

        yVals1.add(new BarEntry(1, (float) 38));

        yVals1.add(new BarEntry(2, (float) 25));

        yVals1.add(new BarEntry(3, (float) 39));

        yVals1.add(new BarEntry(4, (float) 30));

        yVals1.add(new BarEntry(5, (float) 22));

        yVals1.add(new BarEntry(6, (float) 28));

        yVals1.add(new BarEntry(7, (float) 28));

        yVals1.add(new BarEntry(8, (float) 34));

        yVals1.add(new BarEntry(9, (float) 31));

        yVals1.add(new BarEntry(10, (float) 21));

        yVals1.add(new BarEntry(11, (float) 50));

        chart.setHorizontalScrollBarEnabled(true);

        BarDataSet set1, set2;
        set1 = new BarDataSet(yVals1, "2017");
        set1.setColor(Color.RED);
        set2 = new BarDataSet(yVals2, "B");
        set2.setColor(Color.BLUE);
        BarData data = new BarData(set1, set2);
        data.setValueFormatter(new LargeValueFormatter());
        chart.setData(data);
        chart.getBarData().setBarWidth(barWidth);
        chart.getXAxis().setAxisMinimum(0);
        chart.getXAxis().setAxisMaximum(0 + chart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
        chart.groupBars(0, groupSpace, barSpace);
        chart.getData().setHighlightEnabled(false);
        chart.invalidate();

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setYOffset(20f);
        l.setXOffset(0f);
        l.setYEntrySpace(0f);
        l.setTextSize(18f);

        //X-axis
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(11);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));
//Y-axis
        chart.getAxisRight().setEnabled(false);
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(true);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);
    }
}
