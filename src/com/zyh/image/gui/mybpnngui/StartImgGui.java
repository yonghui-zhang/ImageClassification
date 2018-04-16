package com.zyh.image.gui.mybpnngui;

import com.sun.xml.internal.fastinfoset.algorithm.DoubleEncodingAlgorithm;
import com.zyh.image.mycomponents.CustomButtonUi;
import com.zyh.image.mycomponents.MyButton;
import com.zyh.image.tools.ImageIconTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class StartImgGui extends MyButton{

    private static boolean imgSwitch = true;

    private int DEFAULT_WIDTH = 61;
    private int DEFAULT_HEIGHT = 62;

    public StartImgGui()
    {
        super();
        initGui();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (imgSwitch)
                {
                    /******显示pause图片*******/
                    setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/pause.png"), DEFAULT_WIDTH, DEFAULT_HEIGHT));
                }else {
                    /*******显示start图片******/
                    setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/start.png"), DEFAULT_WIDTH, DEFAULT_HEIGHT));
                }
                doImgSwitch();
            }
        });
    }
    /**
     *  开关的转换
     */
    private void doImgSwitch()
    {
        imgSwitch = imgSwitch ? false : true;
    }
    /**
     * 初始化按钮的状态为start背景图片
     */
    private void initGui()
    {
        setPreferredSize(new Dimension(61, 62));
        setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/start.png"), DEFAULT_WIDTH, DEFAULT_HEIGHT));
    }
}
