package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.CustomButtonUi;
import com.zyh.image.mycomponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class StartImgGui extends MyButton{

    private static boolean imgSwitch = true;

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
                    setIcon(getScaledIcon(getClass().getResource("/images/pause.png")));
                }else {
                    /*******显示start图片******/
                    setIcon(getScaledIcon(getClass().getResource("/images/start.png")));
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
        setBackground(Color.WHITE);
        setIcon(getScaledIcon(getClass().getResource("/images/start.png")));
    }
    /**
     * 对图片进行缩放
     * @param path
     * @return
     */
    private ImageIcon getScaledIcon(URL path)
    {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(61, 62, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}
