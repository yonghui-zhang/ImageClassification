package com.zyh.image.mycomponents;

import com.zyh.image.tools.ImageIconTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame{

    private int DEFAULT_WINDOW_WIDTH = 900;
    private int DEFAULT_WINDOW_HEIGHT = 600;

    private int DEFAULT_SOFTWAREICON_WIDTH = 256;
    private int DEFAULT_SOFTWAREICON_HEIGHT = 190;

    private int first_x, first_y;

    public MyFrame()
    {
       initGui();
       setSoftwareIcon();
       addFrameDragListener();
    }

    private void initGui()
    {
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds((screenWidth-DEFAULT_WINDOW_WIDTH)/2, (screenHeight-DEFAULT_WINDOW_HEIGHT)/2,
                DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        setTitle("BP神经网络图像分类");
        setUndecorated(true);//去掉边框
    }

    /**
     * 添加鼠标拖动事件监听
     */
    private void addFrameDragListener()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) {
                first_x = e.getX();//记录鼠标初始点
                first_y = e.getY();
            }
        });
        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() - first_x;
                int y = e.getY() - first_y;
                setBounds(getX()+x, getY()+y, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
            }
        });
    }

    /**
     * 设置软件的图标
     */
    private void setSoftwareIcon()
    {
        /***************设置软件图标*****************/
        ImageIcon imageIcon = ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/icon.jpg"),
                DEFAULT_SOFTWAREICON_WIDTH, DEFAULT_SOFTWAREICON_HEIGHT);
        setIconImage(imageIcon.getImage());
    }
}
