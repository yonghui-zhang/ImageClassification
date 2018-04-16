package com.zyh.image.gui;

import com.zyh.image.mycomponents.MyButton;
import com.zyh.image.mycomponents.MyFrame;
import com.zyh.image.tools.ImageIconTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MainWindowGui extends MyFrame {

    /**
     * 初始化组件池
     */
    static {
        WidgetPool.getInstance();//保证池子肯定被初始化
    }

    public MainWindowGui()
    {
        initGui();
        setVisible(true);//只显示自身，不显示父体
    }

    private void initGui()
    {
        /*********主窗体Top Bar**********/
        MainWindowTopBar topBar = new MainWindowTopBar();
        /*********主窗体 Context**************/
        MainWindowContext context = new MainWindowContext();
        /********主窗体 Menu**********/
        MainWindowMenu menu = new MainWindowMenu();

        add(topBar, BorderLayout.NORTH);
        add(menu, BorderLayout.WEST);
        add(context, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
       new MainWindowGui();
    }
}