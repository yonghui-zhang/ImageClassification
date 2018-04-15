package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyButton;
import com.zyh.image.tools.ImageIconTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HiddenLayerTopBarGui extends JPanel {

    private MyButton addbtn;
    private MyButton subbtn;
    private JLabel title;

    private int DEFAULT_BUTTON_WIDTH = 32;
    private int DEFAULT_BUTTON_HEIGHT = 32;

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

        addbtn.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/add.png"), DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT));
        subbtn.setIcon(ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/sub.png"), DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT));

        /*********右部HiddenLayer title******/
        title = new JLabel();
        title.setText(" 1 HIDDEN LAYERS");
        title.setFont(new Font("宋体", Font.BOLD, 20));

        add(addbtn);
        add(subbtn);
        add(title);

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
