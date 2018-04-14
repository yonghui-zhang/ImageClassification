package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 加号和减号的top bar
 */
public class ButtonTopBarGui extends JPanel{

    private MyButton addbtn;
    private MyButton subbtn;

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

        addbtn.setIcon(getScaledIcon(getClass().getResource("/images/add.png")));
        subbtn.setIcon(getScaledIcon(getClass().getResource("/images/sub.png")));

        add(addbtn);
        add(subbtn);
    }
    private ImageIcon getScaledIcon(URL path)
    {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}
