package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyButton;
import com.zyh.image.mycomponents.MyPanel;
import com.zyh.image.tools.ImageIconTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HiddenLayerTopBarGui extends MyPanel {

    private MyButton addbtn;
    private MyButton subbtn;
    private JLabel title;

    private ButtonTopBarGui btnTopBar;

    private int DEFAULT_BUTTON_WIDTH = 32;
    private int DEFAULT_BUTTON_HEIGHT = 32;

    public HiddenLayerTopBarGui()
    {
        init();
        initGui();
    }

    public MyButton getSubbtn() {
        return subbtn;
    }

    public MyButton getAddbtn() {
        return addbtn;
    }

    public JLabel getTitle() {
        return title;
    }

    private void init()
    {
        /*****生成一个按钮组件********/
        btnTopBar = new ButtonTopBarGui();
        addbtn = btnTopBar.getAddbtn();
        subbtn = btnTopBar.getSubbtn();
    }

    private void initGui()
    {
        /*********右部HiddenLayer title******/
        title = new JLabel();
        title.setText(" 1 HIDDEN LAYERS");
        title.setFont(new Font("宋体", Font.BOLD, 20));

        add(btnTopBar);
        add(title);
    }
}
