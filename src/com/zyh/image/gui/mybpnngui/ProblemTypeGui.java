package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyComboBox;
import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;

public class ProblemTypeGui extends MyPanel{

    private JLabel title;
    private MyComboBox problemType;

    public ProblemTypeGui()
    {
        super();
        initGui();
        setCustomLayout();
    }

    private void setCustomLayout()
    {
        setLayout(new GridLayout(2, 1));
        add(title);
        add(problemType);
    }

    private void initGui()
    {
        title = new JLabel();
        title.setPreferredSize(new Dimension(120, 10));
        title.setText("Problem type");


        String[] problemTypesStrs = {"Classification"};//暂时为分类问题
        problemType = new MyComboBox(problemTypesStrs);
        problemType.setMaximumRowCount(1);
    }
}
