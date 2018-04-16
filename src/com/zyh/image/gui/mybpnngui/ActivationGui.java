package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyComboBox;
import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;

public class ActivationGui extends MyPanel {

    private JLabel title;
    private MyComboBox activation;

    public ActivationGui()
    {
        initGui();
        setCustomLayout();
    }

    private void setCustomLayout()
    {
        setLayout(new GridLayout(2, 1));
        add(title);
        add(activation);
    }

    private void initGui()
    {
        title = new JLabel();
        title.setText("Activation");

        String[] activationStrs = {"ReLU", "Tanh", "Sigmoid", "Linear"};
        activation = new MyComboBox(activationStrs);
        activation.setMaximumRowCount(4);

    }
}
