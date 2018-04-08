package com.zyh.image.tools;

import com.bitagentur.chart.JChartLibBaseChart;
import com.bitagentur.renderer.JChartLibLinechartRenderer;

public class HackJChartLibLinechartRenderer extends JChartLibLinechartRenderer{

    public HackJChartLibLinechartRenderer(JChartLibBaseChart chart) {
        super(chart);
        /*****干掉恶心的作者版权说明****/
        this.note = "";
    }
}
