package com.zyh.image.gui;

import com.zyh.image.mycomponents.MyButton;
import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindowTopBar extends MyPanel{

    public MainWindowTopBar()
    {
        initGui();
    }

    private void initGui()
    {
        //改用GridBagLayout灵活变动布局
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridwidth = 1;
        JLabel logoLabel = new JLabel();

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo.png"));
        logoLabel.setIcon(logoIcon);
        logoLabel.setPreferredSize(new Dimension(200, 60));
        gridBagLayout.setConstraints(logoLabel, gridBagConstraints);
        add(logoLabel);

        gridBagConstraints.gridwidth = 4;
        JLabel title = new JLabel("BP神经网络训练平台", JLabel.CENTER);
        title.setFont(new Font("宋体", Font.BOLD, 20));
        title.setPreferredSize(new Dimension(604, 60));
        gridBagLayout.setConstraints(title, gridBagConstraints);
        add(title);


        ImageIcon closeIcon = new ImageIcon(getClass().getResource("/images/close.png"));
        closeIcon.setImage(closeIcon.getImage().getScaledInstance(29, 30, Image.SCALE_DEFAULT));

        gridBagConstraints.gridwidth = 0;
        MyButton closeBtn = new MyButton(closeIcon);
        gridBagLayout.setConstraints(closeBtn, gridBagConstraints);
        add(closeBtn);

        ArrayList<JButton> btns = new ArrayList<>();
        btns.add(closeBtn);

        closeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);//系统退出
            }
        });
    }
}
