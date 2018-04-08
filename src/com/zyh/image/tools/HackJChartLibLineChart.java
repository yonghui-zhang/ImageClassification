package com.zyh.image.tools;

import com.bitagentur.chart.JChartLibBaseChart;
import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.renderer.JChartLibLinechartRenderer;

public class HackJChartLibLineChart extends JChartLibBaseChart {

    public HackJChartLibLineChart(String title, String xAxis, String yAxis, JChartLibDataSet dataSet) {
        super(title, xAxis, yAxis, dataSet);
        this.setRender(new HackJChartLibLinechartRenderer(this));
    }
}
