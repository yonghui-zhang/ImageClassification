package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;

public class TimeCostGui extends MyPanel{

    private JLabel title;
    private JLabel timecost;

    /**
     * 设置实时时间
     * @return
     */
    public JLabel getTimecost() {
        return timecost;
    }

    public TimeCostGui()
    {
        super();
        initGui();
        setCustomLayout();
    }

    private void setCustomLayout()
    {
        setLayout(new GridLayout(2, 1));
        add(title);
        add(timecost);
    }

    private void initGui()
    {
        title = new JLabel();
        title.setText("Time Cost");
        timecost = new JLabel();
        timecost.setText("0 s");
        timecost.setFont(new Font("宋体", Font.BOLD, 25));
    }
}
