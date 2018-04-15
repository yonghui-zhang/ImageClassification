package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyButton;
import com.zyh.image.tools.ImageIconTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * 加号和减号的top bar
 */
public class ButtonTopBarGui extends JPanel{

    private MyButton addbtn;
    private MyButton subbtn;

    private int DEFAULT_BUTTON_WIDTH = 32;
    private int DEFAULT_BUTTON_HEIGHT = 32;

    public MyButton getAddbtn() {
        return addbtn;
    }

    public MyButton getSubbtn() {
        return subbtn;
    }

    public ButtonTopBarGui()
    {
        initGui();
    }

    private void initGui()
    {
        setLayout(new GridLayout(1, 2));
        /************上部的add button*******/
        addbtn = new MyButton();
        addbtn.setPreferredSize(new Dimension(32, 32));
        addbtn.setBackground(Color.WHITE);
        /***********上部的sub button********/
        subbtn = new MyButton();
        subbtn.setPreferredSize(new Dimension(32, 32));
        subbtn.setBackground(Color.WHITE);

        addbtn.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/add.png"), DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT));
        subbtn.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/sub.png"), DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT));

        add(addbtn);
        add(subbtn);

        addBtnSwitchImgListener();
        subBtnSwitchImgListener();
    }


    /**
     * 加号按钮监听器（实现UI的变换效果）
     */
    private void addBtnSwitchImgListener()
    {
        addbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addbtn.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/add_focus.png"), DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addbtn.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/add.png"), DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT));
            }
        });
    }

    /**
     * 减号按钮监听器（实现UI的变换效果）
     */
    private void subBtnSwitchImgListener()
    {
        subbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                subbtn.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/sub_focus.png"), DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                subbtn.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/sub.png"), DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT));
            }
        });
    }
}
