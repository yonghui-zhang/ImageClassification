package com.zyh.image.gui.mybpnngui;

import com.zyh.image.gui.WidgetPool;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义的神经网络训练图解（模仿tensorflow的playground online）
 */
public class MyBpnnMainGui extends JPanel{

    public MyBpnnMainGui()
    {
       super();
       initMainGui();
    }

    private void initMainGui()
    {
        setBackground(Color.WHITE);
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
