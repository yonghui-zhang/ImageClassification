package com.zyh.image.gui.mybpnngui;

import javax.swing.*;
import java.awt.*;

/**
 * 神经网络可视化之特征输入层
 */
public class FeaturesInputLayerGui extends JPanel{

    public FeaturesInputLayerGui()
    {
        initGui();
    }
    /**
     * 初始化界面
     */
    private void initGui()
    {
        /*******大标题******/
        JLabel topTitle = new JLabel();
        topTitle.setText("FEATURES");
        topTitle.setFont(new Font("宋体", Font.BOLD, 20));

        /*******小描述*********/
        JLabel descripts = new JLabel();
        descripts.setText("Which properties do you want to feed in ?");

        /*******特征数组(暂时写死)*****/
        InputNeuraslGui inputNeuraslGui = new InputNeuraslGui();

        add(topTitle);
        add(descripts);
        add(inputNeuraslGui);
    }
}
