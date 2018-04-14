package com.zyh.image.gui.mybpnngui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class OutputLayerContext extends JPanel {

    private JLabel output;

    public OutputLayerContext()
    {
        initGui();
    }

    private void initGui()
    {
        output = new JLabel();
        output.setIcon(getScaledIcon(getClass().getResource("/images/output.png")));

        add(output);
    }

    private ImageIcon getScaledIcon(URL path)
    {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}
