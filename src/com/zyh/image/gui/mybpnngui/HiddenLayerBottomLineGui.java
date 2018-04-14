package com.zyh.image.gui.mybpnngui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class HiddenLayerBottomLineGui extends JPanel{

    public HiddenLayerBottomLineGui()
    {
        setBackground(Color.WHITE);
        initGui();
    }

    private void initGui()
    {
        JLabel line = new JLabel();
        line.setIcon(getScaledIcon(getClass().getResource("/images/line.png")));

        add(line);
    }

    private ImageIcon getScaledIcon(URL path)
    {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(336, 18, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}
