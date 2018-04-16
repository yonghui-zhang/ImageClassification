package com.zyh.image.gui;

import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;

public class TrainAndTestGui extends MyPanel{

    public TrainAndTestGui()
    {
        initGui();
    }

    private void initGui() {

        /*********神经网络的训练和测试集的验证***********/
        JButton btn = new JButton("神经网络的训练和测试集的验证");
        add(btn);
    }
}
