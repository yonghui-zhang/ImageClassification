package com.zyh.image.mycomponents;

import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;

public class MyProgressBar {

    private JProgressBar progressBar;
    private JLabel label;
    private JPanel childpanel;

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JLabel getLabel() {
        return label;
    }

    public JPanel getChildpanel() {
        return childpanel;
    }

    public MyProgressBar()
    {
        childpanel = new JPanel();
        childpanel.setPreferredSize(new Dimension(150, 250));
        childpanel.setBackground(Color.WHITE);

        progressBar = new JProgressBar(JProgressBar.VERTICAL);
        progressBar.setStringPainted(false);
        progressBar.setBorderPainted(false);
        progressBar.setBackground(Color.PINK);
        progressBar.setPreferredSize(new Dimension(100, 200));

        label = new JLabel();

        childpanel.add(progressBar, BorderLayout.CENTER);
        childpanel.add(label, BorderLayout.SOUTH);
    }
}
