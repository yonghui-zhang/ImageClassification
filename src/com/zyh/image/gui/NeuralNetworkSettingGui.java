package com.zyh.image.gui;

import com.zyh.image.gui.WidgetPool;
import com.zyh.image.gui.mybpnngui.MyBpnnMainContext;
import com.zyh.image.gui.mybpnngui.ParameterTopBarGui;
import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义的神经网络训练图解（模仿tensorflow的playground online）
 */
public class NeuralNetworkSettingGui extends MyPanel{

    public NeuralNetworkSettingGui()
    {
       initMainGui();
    }

    private void initMainGui()
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        /******显示顶部神经网络参数栏*****/
        gridBagConstraints.gridwidth = 0;
        ParameterTopBarGui topBarGui = new ParameterTopBarGui();
        gridBagLayout.setConstraints(topBarGui, gridBagConstraints);
        /******神经网络可视化************/
        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.gridheight = 0;
        MyBpnnMainContext bpnnMainContext = new MyBpnnMainContext();
        gridBagLayout.setConstraints(bpnnMainContext, gridBagConstraints);

        add(topBarGui);
        add(bpnnMainContext);
    }
}
