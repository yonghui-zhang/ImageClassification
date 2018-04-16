package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 神经网络可视化之特征输入层
 */
public class FeaturesInputLayerGui extends MyPanel {

    public FeaturesInputLayerGui()
    {
        initGui();
    }
    /**
     * 初始化界面
     */
    private void initGui()
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        /*******大标题******/
        gridBagConstraints.gridwidth = 0;
        JLabel topTitle = new JLabel();
        topTitle.setText("FEATURES");
        topTitle.setFont(new Font("宋体", Font.BOLD, 20));
        gridBagLayout.setConstraints(topTitle, gridBagConstraints);

        /*******小描述*********/
        gridBagConstraints.gridwidth = 0;
        JLabel descripts = new JLabel();
        descripts.setText("<html>Which properties<br> do you want to<br> feed in ?<br><br></html>");
        gridBagLayout.setConstraints(descripts, gridBagConstraints);

        /*******特征数组(暂时写死)*****/
        gridBagConstraints.gridwidth = 0;
        InputNeuraslGui inputNeuraslGui = new InputNeuraslGui();
        gridBagLayout.setConstraints(inputNeuraslGui, gridBagConstraints);

        add(topTitle);
        add(descripts);
        add(inputNeuraslGui);
    }
}
