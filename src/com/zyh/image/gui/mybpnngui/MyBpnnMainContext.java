package com.zyh.image.gui.mybpnngui;

import com.zyh.image.gui.WidgetPool;

import javax.swing.*;
import java.awt.*;

public class MyBpnnMainContext extends JPanel{

    public MyBpnnMainContext()
    {
        initGui();
    }

    private void initGui()
    {
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);
        /********添加Up Card******/
        MyBpnnMainContextUpCard upCard = new MyBpnnMainContextUpCard();
        /*********把Up Card添加到Widget Pool中*********/
        WidgetPool.getInstance().addWidget("MyBpnnMainContextUpCard", upCard);
        /*********添加Bottom Card*********/
        MyBpnnMainContextBottomCard bottomCard = new MyBpnnMainContextBottomCard();

        add(bottomCard);
        add(upCard);

        cardLayout.first(this);
        cardLayout.first(this);
    }
}
