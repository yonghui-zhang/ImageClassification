package com.zyh.image.gui;

import com.zyh.image.mycomponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindowMenu extends JPanel{

    private MainWindowContext context;
    private CardLayout cardLayout;

    public MainWindowMenu()
    {
        init();
        initGui();
    }

    private void init()
    {
        context = (MainWindowContext) WidgetPool.getInstance().getWidget("MainWindowContext");
        cardLayout = (CardLayout) WidgetPool.getInstance().getWidget("CardLayout");
    }

    private void initGui()
    {
        /*************************左部内容设置***********************************/
        setBackground(Color.PINK);
        setLayout(new GridLayout(10, 1));

        MyButton dataManagerBtn = new MyButton("图像数据集管理");
        MyButton imageFeatureBtn = new MyButton("图像特征提取");
        MyButton neuralSettingBtn = new MyButton("神经网络参数设置");
        MyButton trainTestBtn = new MyButton("数据训练和测试");
        MyButton networkMonitorBtn = new MyButton("性能监控");

        setButtonFont(dataManagerBtn);
        setButtonFont(imageFeatureBtn);
        setButtonFont(neuralSettingBtn);
        setButtonFont(trainTestBtn);
        setButtonFont(networkMonitorBtn);

        setButtonBackground(dataManagerBtn);
        setButtonBackground(imageFeatureBtn);
        setButtonBackground(neuralSettingBtn);
        setButtonBackground(trainTestBtn);
        setButtonBackground(networkMonitorBtn);

        add(dataManagerBtn);
        add(imageFeatureBtn);
        add(neuralSettingBtn);
        add(trainTestBtn);
        add(networkMonitorBtn);

        addMenuItemListener(dataManagerBtn, "DataManager");
        addMenuItemListener(imageFeatureBtn, "ImageFeatureExtract");
        addMenuItemListener(neuralSettingBtn, "NeuralNetworkSetting");
        addMenuItemListener(trainTestBtn, "TrainAndTest");
        addMenuItemListener(networkMonitorBtn, "NetworkMonitor");
    }

    /**
     * 给Menu选项添加监听
     */
    private void addMenuItemListener(JButton item, String cardname)
    {
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(context, cardname);
            }
        });
    }
    /**
     * 设置Menu的按钮字体
     * @param btn
     */
    private void setButtonFont(JButton btn)
    {
        btn.setFont(new Font("宋体", Font.BOLD, 14));
    }

    /**
     * 设置Menu的按钮背景颜色为粉色
     */
    private void setButtonBackground(JButton btn)
    {
        btn.setBackground(Color.PINK);
    }
}
