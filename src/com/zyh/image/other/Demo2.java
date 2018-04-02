package com.zyh.image.other;

import com.bitagentur.chart.JChartLibBarchart;
import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;
import com.bitagentur.renderer.JChartLibPanel;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;

public class Demo2 {

    public static void main(String[] args)
    {
//        JChartLibSerie values = new JChartLibSerie("张三");
//        values.addValue(1);
//        values.addValue(5);
//        values.addValue(3);
//        JChartLibDataSet dataSet = new JChartLibDataSet();
//        dataSet.addDataSerie(values);
//
//        JChartLibBarchart chart = new JChartLibBarchart("图表1",
//                "横坐标", "纵坐标", dataSet);
//        JChartLibPanel chartLibPanel = new JChartLibPanel(chart);
//
//        JFrame frame = new JFrame();
//        frame.add(chartLibPanel);
//        frame.setBounds(200, 200, 400, 400);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

        System.out.println(Demo2.class.getResource("/images").getPath());


    }
}
