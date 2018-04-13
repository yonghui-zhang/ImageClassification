package com.zyh.image.mycomponents;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

/**
 * 自定义Button的背景色
 */
public class CustomButtonUi extends BasicButtonUI{

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, b.getWidth(), b.getHeight());
    }
}
