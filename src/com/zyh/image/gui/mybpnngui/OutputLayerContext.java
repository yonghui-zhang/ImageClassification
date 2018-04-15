package com.zyh.image.gui.mybpnngui;

import com.zyh.image.gui.WidgetPool;
import com.zyh.image.tools.ImageIconTool;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class OutputLayerContext extends JPanel {

    private JLabel output;

    private int DEFAULT_WIDTH = 200;
    private int DEFAULT_HEIGHT = 200;

    public OutputLayerContext()
    {
        initGui();
    }

    private void initGui()
    {
        output = new JLabel();
        /*********添加进Widget Pool中*******/
        WidgetPool.getInstance().addWidget("OutputLayerContext.output", output);
        output.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/output.png"), DEFAULT_WIDTH, DEFAULT_HEIGHT));

        add(output);
    }
}