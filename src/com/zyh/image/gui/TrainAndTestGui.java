package com.zyh.image.gui;

import javax.swing.*;

public class TrainAndTestGui implements FunctionGui{

    private static TrainAndTestGui trainAndTest = new TrainAndTestGui();

    private TrainAndTestGui()
    {

    }

    public static TrainAndTestGui getInstance()
    {
        return trainAndTest;
    }

    @Override
    public void settingGui(JPanel panel) {

        /*********神经网络的训练和测试集的验证***********/
        JButton btn = new JButton("神经网络的训练和测试集的验证");
        panel.add(btn);
    }
}
