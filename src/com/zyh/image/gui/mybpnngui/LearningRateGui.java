package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyComboBox;

import javax.swing.*;
import java.awt.*;

public class LearningRateGui extends JPanel{

    private JLabel title;
    private MyComboBox learnningRate;

    public LearningRateGui()
    {
        super();
        initGui();
        setCustomLayout();
    }

    private void setCustomLayout()
    {
        setLayout(new GridLayout(2, 1));
        add(title);
        add(learnningRate);
    }
    private void initGui()
    {
        setBackground(Color.WHITE);
        title = new JLabel();
        title.setText("Learning rate");

        String[] learningRatesStrs = {"0.00001", "0.0001", "0.001", "0.003", "0.01", "0.03", "0.1", "0.3", "1", "3", "10"};
        learnningRate = new MyComboBox(learningRatesStrs);
        learnningRate.setMaximumRowCount(11);
    }

}
