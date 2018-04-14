package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class HiddenLayerTopBarGui extends JPanel {

    private MyButton addbtn;
    private MyButton subbtn;
    private JLabel title;

    public HiddenLayerTopBarGui()
    {
        setBackground(Color.WHITE);
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

    private void initGui()
    {
        /*********左部+按钮********/
        addbtn = new MyButton();
        addbtn.setBackground(Color.WHITE);
        addbtn.setPreferredSize(new Dimension(32, 32));
        /***********左部-按钮*****/
        subbtn = new MyButton();
        subbtn.setBackground(Color.WHITE);
        subbtn.setPreferredSize(new Dimension(32, 32));

        addbtn.setIcon(getScaledIcon(getClass().getResource("/images/add.png")));
        subbtn.setIcon(getScaledIcon(getClass().getResource("/images/sub.png")));

        /*********右部HiddenLayer title******/
        title = new JLabel();
        title.setText(" 2 HIDDEN LAYERS");
        title.setFont(new Font("宋体", Font.BOLD, 20));

        add(addbtn);
        add(subbtn);
        add(title);
    }

    private ImageIcon getScaledIcon(URL path)
    {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}
