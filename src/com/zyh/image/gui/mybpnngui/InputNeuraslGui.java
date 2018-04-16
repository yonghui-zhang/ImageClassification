package com.zyh.image.gui.mybpnngui;

import com.zyh.image.gui.WidgetPool;
import com.zyh.image.gui.mybpnngui.entity.Neural;
import com.zyh.image.mycomponents.MyPanel;
import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * 输入层的神经元
 */
public class InputNeuraslGui extends MyPanel{

    private int DEFAULT_FEATURES = 8;
    private ArrayList<Neural> neurals;

    public InputNeuraslGui()
    {
        initGui();
    }
    /**
     * 初始化界面
     */
    private void initGui()
    {
        /*********暂时为8个特征*******/
        setLayout(new GridLayout(DEFAULT_FEATURES, 2, 5, 10));

        neurals = new ArrayList<>();

        for (int i=0;i<DEFAULT_FEATURES;i++)
        {
            JLabel label = new JLabel();
            label.setText("特征" + (i+1));
            Neural neural = new Neural(true);

            add(label);
            add(neural);

            neurals.add(neural);
        }
        /**********添加到Widget Pool*********/
        WidgetPool.getInstance().addWidget("InputNeurals", neurals);
    }
}
