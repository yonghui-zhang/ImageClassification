package com.zyh.image.gui;

import com.bitagentur.chart.JChartLibLineChart;
import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;
import com.bitagentur.renderer.I_JChartLibRenderer;
import com.bitagentur.renderer.JChartLibLinechartRenderer;
import com.bitagentur.renderer.JChartLibPanel;
import com.bitagentur.renderer.JChartLibRender;
import com.zyh.image.mycomponents.MyProgressBar;
import com.zyh.image.tools.*;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;
import jdk.internal.org.objectweb.asm.tree.MethodNode;
import org.hyperic.sigar.SigarException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/*
  神经网络的性能监控
 */
public class NetworkMonitorGui implements FunctionGui{

    private static NetworkMonitorGui networkMonitorGui = new NetworkMonitorGui();

    private NetworkMonitorGui()
    {

    }

    public static NetworkMonitorGui getInstance()
    {
        return networkMonitorGui;
    }

    @Override
    public void settingGui(JPanel panel) {

        /*************神经网络平台监控面板***************/

        //改用GridBagLayout灵活变动布局
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        panel.setBackground(Color.WHITE);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

//        /***********利用反射干掉恶心的作者note*******/
//        //JChartLibLinechartRenderer chartLibLinechartRenderer = (JChartLibLinechartRenderer);
//        //   chartLibLinechartRenderer
//        Class clazz = JChartLibRender.class;
//        Field field = null;
//        try {
//            field = clazz.getDeclaredField("note");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        field.setAccessible(true);
//        try {
//            field.set("note", "");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        System.out.println(field);
//
//        /**************************************************/

        /**************先加入图表样例************/
        JChartLibDataSet dataSet = new JChartLibDataSet();

        JChartLibSerie values = new JChartLibSerie("BP神经网络训练数据");
        dataSet.addDataSerie(values);
        values.addValue(new Date(), 5);
        JChartLibLineChart chart = new JChartLibLineChart("BP神经网络训练情况", "时间", "训练误差", dataSet);


        gridBagConstraints.gridwidth = 0;
        JChartLibPanel chartPanel = new JChartLibPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        gridBagLayout.setConstraints(chartPanel, gridBagConstraints);
        chartPanel.setBackground(Color.PINK);
        panel.add(chartPanel);

//        JChartLibDataSet dataSet2 = new JChartLibDataSet();
//
//        JChartLibSerie values2 = new JChartLibSerie("BP神经网络训练数据");
//        dataSet2.addDataSerie(values2);
//        values.addValue(new Date(), 5);
//        JChartLibLineChart chart2 = new JChartLibLineChart("BP神经网络训练情况", "时间", "训练正确率", dataSet);
//
//        gridBagConstraints.gridwidth = 0;
//        JChartLibPanel chartPanel2 = new JChartLibPanel(chart);
//        chartPanel2.setPreferredSize(new Dimension(400, 300));
//        chartPanel2.setBackground(Color.PINK);
//        gridBagLayout.setConstraints(chartPanel2, gridBagConstraints);
//        panel.add(chartPanel2);
//        Random random = new Random();
//        Random random2 = new Random(4);
//        int[] i = new int[1];
//        i[0] = 10;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true)
//                {
//                    values.addValue(new Date(), random.nextInt(50) - 25);
//                    values2.addValue(new Date(), random2.nextInt(100));
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    chartPanel.updateUI();
//                    chartPanel2.updateUI();
//                }
//            }
//        }).start();


//        /************填充***************/
//        gridBagConstraints.gridwidth = 2;
//        JLabel nopLabel0 = new JLabel();
//        gridBagLayout.setConstraints(nopLabel0, gridBagConstraints);
//        panel.add(nopLabel0);
            /****************加入计算机的信息********************/
            gridBagConstraints.gridwidth = 4;
            JPanel comInfo = null;
            try {
                comInfo = getComputerInfoPanel();
            } catch (SigarException e) {
                e.printStackTrace();
            }
            gridBagLayout.setConstraints(comInfo, gridBagConstraints);
            panel.add(comInfo);
            /************加入对jvm的内存监控***************/
            gridBagConstraints.gridwidth = 2;
            MyProgressBar myProgressBar0 = new MyProgressBar();
            JPanel panel0 = myProgressBar0.getChildpanel();
            gridBagLayout.setConstraints(panel0, gridBagConstraints);
            panel.add(panel0);

            /************加入计算机的CPU监控************/
            gridBagConstraints.gridwidth = 2;
            MyProgressBar myProgressBar1 = new MyProgressBar();
            JPanel panel1 = myProgressBar1.getChildpanel();
            gridBagLayout.setConstraints(panel1, gridBagConstraints);
            panel.add(panel1);


            /************加入计算机的内存监控************/
            gridBagConstraints.gridwidth = 0;
            MyProgressBar myProgressBar2 = new MyProgressBar();
            JPanel panel2 = myProgressBar2.getChildpanel();
            gridBagLayout.setConstraints(panel2, gridBagConstraints);
            panel.add(panel2);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {

                            int jvmMemUsedRate = JvmMemMonitor.getJvmMemoryUsedRate();
                            double jvmMemUsed = JvmMemMonitor.getJvmMemoryUsed();
                            myProgressBar0.getProgressBar().setValue(jvmMemUsedRate);
                            myProgressBar0.getLabel().setText("jvm内存已用 " + jvmMemUsed + " MB");

                            int cpuUsedRate = CpuMonitor.getCurrentCpuUsedRate();
                            myProgressBar1.getProgressBar().setValue(cpuUsedRate);
                            myProgressBar1.getLabel().setText("cpu使用率 " + cpuUsedRate + "%");

                            double memUsed = MemoryMonitor.getCurrentMemoryUsed();
                            int memUsedRate = MemoryMonitor.getMemoryUsedRate();
                            myProgressBar2.getProgressBar().setValue(memUsedRate);
                            myProgressBar2.getLabel().setText("计算机内存已用 " + memUsed + " GB");

                            Thread.sleep(200);
                        } catch (SigarException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();

            /**************显示神经网络的实时训练图表**********/
    }

    private JPanel getComputerInfoPanel() throws SigarException {
        JPanel computerInfo = new JPanel();
        computerInfo.setPreferredSize(new Dimension(260, 250));
        computerInfo.setBackground(Color.WHITE);
        /***********填充***********/
        JLabel nopLabel = new JLabel();
        nopLabel.setPreferredSize(new Dimension(260, 80));
        nopLabel.setFont(new Font("宋体", Font.BOLD, 20));
        nopLabel.setText("计算机的配置信息");
        computerInfo.add(nopLabel);

        JLabel osnameLabel = new JLabel();
        JLabel cpuInfoLabel = new JLabel();
        JLabel cpusLabel = new JLabel();
        JLabel jvmLabel = new JLabel();
        JLabel jvmmemLabel = new JLabel();
        JLabel memLabel = new JLabel();

        osnameLabel.setPreferredSize(new Dimension(260, 13));
        cpuInfoLabel.setPreferredSize(new Dimension(260, 13));
        cpusLabel.setPreferredSize(new Dimension(260, 13));
        jvmLabel.setPreferredSize(new Dimension(260, 13));
        jvmmemLabel.setPreferredSize(new Dimension(260, 13));
        memLabel.setPreferredSize(new Dimension(260, 13));

        computerInfo.add(osnameLabel);
        computerInfo.add(cpuInfoLabel);
        computerInfo.add(cpusLabel);
        computerInfo.add(jvmLabel);
        computerInfo.add(jvmmemLabel);
        computerInfo.add(memLabel);

        osnameLabel.setText("操作系统:  " + ComputerInfo.getComputerOsInfo());
        cpuInfoLabel.setText("型号: " + ComputerInfo.getComputerCpuInfo());
        cpusLabel.setText("处理器个数:  " + ComputerInfo.getComputerCpuNum());
        jvmLabel.setText("Java Version:  " + JvmInfo.getJvmVersion());
        jvmmemLabel.setText("JVM总内存: " + JvmInfo.getJvmTotalMemory() + " MB");
        memLabel.setText("计算机总内存: " + ComputerInfo.getComputerTotalMemory() + " GB");

        return computerInfo;
    }
}
