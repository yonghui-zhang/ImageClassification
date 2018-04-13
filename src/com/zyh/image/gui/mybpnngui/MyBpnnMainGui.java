package com.zyh.image.gui.mybpnngui;

import org.bytedeco.javacpp.opencv_core;

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
        ParameterTopBarGui topBarGui = new ParameterTopBarGui();

        /******显示顶部神经网络参数栏*****/
        add(topBarGui, BorderLayout.NORTH);
        /******神经网络可视化************/

    }
}
