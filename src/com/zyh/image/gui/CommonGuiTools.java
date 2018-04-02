package com.zyh.image.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class CommonGuiTools {

    public static void listenButtonClick(JButton btn, HashMap<JButton, JPanel> map, List<JPanel> panelList)
    {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel0 = map.get(btn);
                for (JPanel panel : panelList) {

                    if (panel0 == panel)
                    {
                        panel.setVisible(true);
                    }else {
                        panel.setVisible(false);
                    }
                }
            }
        });
    }

    public static void setJButtonsStyle(List<JButton> btnList, Color color)
    {
        for (JButton btn : btnList)
        {
            btn.setBackground(color);
            btn.setFocusPainted(false);//去掉button的文字焦点圈
            btn.setBorderPainted(false);//去掉button外边框
        }
    }

    public static void setJButtonFont(List<JButton> btnList, Font font)
    {
        for (JButton btn : btnList)
        {
            btn.setFont(font);
        }
    }
}
