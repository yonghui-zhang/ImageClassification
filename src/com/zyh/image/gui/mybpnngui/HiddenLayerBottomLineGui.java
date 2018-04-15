package com.zyh.image.gui.mybpnngui;

import com.zyh.image.tools.ImageIconTool;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class HiddenLayerBottomLineGui extends JPanel{

    private int DEFAULT_LINE_WIDTH = 336;
    private int DEFAULT_LINE_HEIGHT = 18;

    public HiddenLayerBottomLineGui()
    {
        setBackground(Color.WHITE);
        initGui();
    }

    private void initGui()
    {
        JLabel line = new JLabel();
        line.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/line.png"), DEFAULT_LINE_WIDTH, DEFAULT_LINE_HEIGHT));

        add(line);
    }
}
