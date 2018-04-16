package com.zyh.image.gui;

import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;
import com.bitagentur.renderer.JChartLibPanel;
import com.zyh.image.mycomponents.MyPanel;
import com.zyh.image.mycomponents.MyProgressBar;
import com.zyh.image.tools.*;
import org.hyperic.sigar.SigarException;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
  神经网络的性能监控
 */
public class NetworkMonitorGui extends MyPanel{

    public NetworkMonitorGui()
    {
        initGui();
    }

    private void initGui() {
        JButton button = new JButton("TEST");
        add(button);

        /*************神经网络平台监控面板***************/
        //改用GridBagLayout灵活变动布局
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();


        /**************先加入图表样例************/
        JChartLibDataSet dataSet = new JChartLibDataSet();

        JChartLibSerie values = new JChartLibSerie("图像分类误差率");
        dataSet.addDataSerie(values);
 //       values.addValue(new Date(), 5);
        HackJChartLibLineChart chart = new HackJChartLibLineChart("BP神经网络训练情况", "迭代次数", "训练误差率", dataSet);


        gridBagConstraints.gridwidth = 0;
        JChartLibPanel chartPanel = new JChartLibPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        gridBagLayout.setConstraints(chartPanel, gridBagConstraints);
        chartPanel.setBackground(Color.PINK);
        add(chartPanel);


        Random random = new Random();
        final int[] flag = {0};

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    values.addValue(random.nextInt(100) + 1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    chartPanel.updateUI();
                }
            }
        }).start();


            /****************加入计算机的信息********************/
            gridBagConstraints.gridwidth = 4;
            JPanel comInfo = null;
            try {
                comInfo = getComputerInfoPanel();
            } catch (SigarException e) {
                e.printStackTrace();
            }
            gridBagLayout.setConstraints(comInfo, gridBagConstraints);
            add(comInfo);
            /************加入对jvm的内存监控***************/
            gridBagConstraints.gridwidth = 2;
            MyProgressBar myProgressBar0 = new MyProgressBar();
            JPanel panel0 = myProgressBar0.getChildpanel();
            gridBagLayout.setConstraints(panel0, gridBagConstraints);
            add(panel0);

            /************加入计算机的CPU监控************/
            gridBagConstraints.gridwidth = 2;
            MyProgressBar myProgressBar1 = new MyProgressBar();
            JPanel panel1 = myProgressBar1.getChildpanel();
            gridBagLayout.setConstraints(panel1, gridBagConstraints);
            add(panel1);


            /************加入计算机的内存监控************/
            gridBagConstraints.gridwidth = 0;
            MyProgressBar myProgressBar2 = new MyProgressBar();
            JPanel panel2 = myProgressBar2.getChildpanel();
            gridBagLayout.setConstraints(panel2, gridBagConstraints);
            add(panel2);

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
