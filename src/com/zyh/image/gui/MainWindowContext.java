package com.zyh.image.gui;

import com.zyh.image.mycomponents.MyPanel;

import java.awt.*;

public class MainWindowContext extends MyPanel{

    public MainWindowContext()
    {
        initGui();
    }

    private void initGui()
    {
        /***********利用卡片布局(重构)***********/
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);

        /************图像数据集管理***********************/
        DataManagerGui dataManagerGui = new DataManagerGui();
        /****************图像特征提取****************/
        ImageFeatureExtractGui imageFeature = new ImageFeatureExtractGui();
        /*************神经网络参数设置**************/
        NeuralNetworkSettingGui nnGui = new NeuralNetworkSettingGui();
        /**************训练和测试***********************/
        TrainAndTestGui trainAndTest = new TrainAndTestGui();
        /***************性能监控******************/
        NetworkMonitorGui networkMonitorGui = new NetworkMonitorGui();

        add("DataManager", dataManagerGui);
        add("ImageFeatureExtract", imageFeature);
        add("NeuralNetworkSetting", nnGui);
        add("TrainAndTest", trainAndTest);
        add("NetworkMonitor", networkMonitorGui);

        /*************加入Widget Pool池*******/
        WidgetPool.getInstance().addWidget("MainWindowContext", this);
        WidgetPool.getInstance().addWidget("CardLayout", cardLayout);
    }
}
