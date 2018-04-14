package com.zyh.image.gui;

import com.zyh.image.gui.mybpnngui.MyBpnnMainGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/*
  神经网络参数的设置
 */
public class NeuronNetworkSettingGui implements FunctionGui{

    private static NeuronNetworkSettingGui neuronNetworkSettingGui = new NeuronNetworkSettingGui();
    private NeuronNetworkSettingGui()
    {
    }

    public static NeuronNetworkSettingGui getInstance()
    {
        return neuronNetworkSettingGui;
    }

    @Override
    public void settingGui(JPanel panel) {

//        panel.setLayout(new GridLayout(3, 2));
//
//        /***************神经网络参数设置面板****************/
//        JLabel label0 = new JLabel("输入层的特征个数");
//        JTextField textField0 = new JTextField("160");
//        label0.setBackground(Color.WHITE);
//        textField0.setBackground(Color.WHITE);
//
//
//        JLabel label1 = new JLabel("隐藏层的神经元个数");
//        JTextField textField1 = new JTextField("200");
//        label1.setBackground(Color.WHITE);
//        textField1.setBackground(Color.WHITE);
//
//        JLabel label2 = new JLabel("输出层的图像分类个数");
//        JTextField textField2 = new JTextField("4");
//        label2.setBackground(Color.WHITE);
//        textField2.setBackground(Color.WHITE);
//
//        textField0.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//
//                    textField0.setText("");
//            }
//        });
//        textField1.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//
//                    textField1.setText("");
//            }
//        });
//        textField2.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//
//                    textField2.setText("");
//            }
//        });
//
//        panel.add(label0);
//        panel.add(textField0);
//        panel.add(label1);
//        panel.add(textField1);
//        panel.add(label2);
//        panel.add(textField2);

        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        /***********模拟tensorflow的playground的界面********/
        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.gridheight = 0;
        MyBpnnMainGui bpnnMainGui = new MyBpnnMainGui();
        gridBagLayout.setConstraints(bpnnMainGui, gridBagConstraints);
     //   bpnnMainGui.setBackground(Color.PINK);
        panel.add(bpnnMainGui);
    }
}
