package com.zyh.image.mycomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 自定义button，主要是风格的设置
 */
public class MyButton extends JButton {

    public MyButton()
    {
        super();
        setUI(new CustomButtonUi());//自定义点击背景色
        customStyle();
    }

    public MyButton(String text)
    {
        super(text);
        customStyle();
    }

    public MyButton(Icon icon)
    {
        super(icon);
        /******自定义风格*****/
        setUI(new CustomButtonUi());//自定义点击背景色
        customStyle();
    }

    /**
     * 自定义按钮风格
     */
    private void customStyle()
    {
        setBackground(Color.WHITE);
        setFocusPainted(false);//去掉button的文字焦点圈
        setBorderPainted(false);//去掉button外边框
    }
}
