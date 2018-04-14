package com.zyh.image.gui.mybpnngui;

import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 输入层的神经元
 */
public class InputNeuraslGui extends JPanel{

    public InputNeuraslGui()
    {
        setBackground(Color.WHITE);
        initGui();
    }

    /**
     * 初始化界面
     */
    private void initGui()
    {
        /*********暂时为10个特征*******/
        setLayout(new GridLayout(9, 2, 5, 10));
        JLabel label0 = new JLabel();
        label0.setText("特征1");
        JLabel label1 = new JLabel();
        label1.setText("特征2");
        JLabel label2 = new JLabel();
        label2.setText("特征3");
        JLabel label3 = new JLabel();
        label3.setText("特征4");
        JLabel label4 = new JLabel();
        label4.setText("特征5");
        JLabel label5 = new JLabel();
        label5.setText("特征6");
        JLabel label6 = new JLabel();
        label6.setText("特征7");
        JLabel label7 = new JLabel();
        label7.setText("特征8");
        JLabel label8 = new JLabel();
        label8.setText("特征9");

        JLabel neural0 = new JLabel();
        JLabel neural1 = new JLabel();
        JLabel neural2 = new JLabel();
        JLabel neural3 = new JLabel();
        JLabel neural4 = new JLabel();
        JLabel neural5 = new JLabel();
        JLabel neural6 = new JLabel();
        JLabel neural7 = new JLabel();
        JLabel neural8 = new JLabel();

        neural0.setIcon(getScaledIcon(getClass().getResource("/images/neural.png")));
        neural1.setIcon(getScaledIcon(getClass().getResource("/images/neural.png")));
        neural2.setIcon(getScaledIcon(getClass().getResource("/images/neural.png")));
        neural3.setIcon(getScaledIcon(getClass().getResource("/images/neural.png")));
        neural4.setIcon(getScaledIcon(getClass().getResource("/images/neural.png")));
        neural5.setIcon(getScaledIcon(getClass().getResource("/images/neural.png")));
        neural6.setIcon(getScaledIcon(getClass().getResource("/images/neural.png")));
        neural7.setIcon(getScaledIcon(getClass().getResource("/images/neural.png")));
        neural8.setIcon(getScaledIcon(getClass().getResource("/images/neural.png")));

        add(label0);
        add(neural0);
        add(label1);
        add(neural1);
        add(label2);
        add(neural2);
        add(label3);
        add(neural3);
        add(label4);
        add(neural4);
        add(label5);
        add(neural5);
        add(label6);
        add(neural6);
        add(label7);
        add(neural7);
        add(label8);
        add(neural8);
    }

    /**
     * 获取特定大小的Icon
     * @param path
     * @return
     */
    private ImageIcon getScaledIcon(URL path)
    {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        return imageIcon;
    }

}
