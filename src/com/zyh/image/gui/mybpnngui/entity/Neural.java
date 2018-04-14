package com.zyh.image.gui.mybpnngui.entity;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 神经元实体
 */
public class Neural extends JLabel {

    private ImageIcon icon;
    public Neural()
    {
        init();
    }

    private void init()
    {
        icon = getScaledIcon(getClass().getResource("/images/neural.png"));
        setIcon(icon);
    }

    private ImageIcon getScaledIcon(URL path)
    {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}
