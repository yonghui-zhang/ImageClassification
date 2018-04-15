package com.zyh.image.gui.mybpnngui;

import com.zyh.image.gui.WidgetPool;
import com.zyh.image.gui.mybpnngui.entity.Neural;

import javax.swing.*;
import java.awt.*;

/**
 * 两个神经元之间画线
 */
public class NeuralLine2Neural extends JPanel {

    private Neural src;
    private Neural target;

    private int RECT_X = 0;
    private int RECT_Y = 0;
    private int RECT_WIDTH = 0;
    private int RECT_HEIGHT = 0;

    public NeuralLine2Neural(Neural src, Neural target)
    {
        init(src, target);
        initGui();
    }

    private void init(Neural src, Neural target)
    {
        this.src = src;
        this.target = target;
        RECT_X = Math.min(this.src.getX(), this.target.getX());
        RECT_Y = Math.min(this.target.getY(), this.target.getY());
        RECT_WIDTH = Math.abs(this.src.getX() - this.target.getX());
        RECT_HEIGHT = Math.abs(this.src.getY() - this.target.getY());
    }

    private void initGui()
    {
         setBounds(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);//设置矩形的位置
         MyBpnnMainContextBottomCard bpnnMainContext = (MyBpnnMainContextBottomCard) WidgetPool.getInstance().getWidget("MyBpnnMainContextBottomCard");
      //   bpnnMainContext.add(this);
         /*******设置该矩形为透明*****/
         setBackground(null);
         setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        /**********画线***********/
        super.paintComponent(g);
        g.setColor(Color.RED);
        drawStraightLine(g);
    }

    /**
     * 画直线（目前先画直线，之后用曲线来优化）
     */
    private void drawStraightLine(Graphics g)
    {
        g.drawLine(src.getX(), src.getY(), target.getX(), target.getY());
    }
}
