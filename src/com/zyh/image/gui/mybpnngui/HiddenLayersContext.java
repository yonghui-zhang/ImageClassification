package com.zyh.image.gui.mybpnngui;

import javax.swing.*;
import java.awt.*;

/**
 * 隐藏层的正文
 */
public class HiddenLayersContext extends JPanel{


    public HiddenLayersContext(int layers)
    {
        setLayout(new GridLayout(1, layers, 0, 10));
        setBackground(Color.WHITE);
        initGui(layers);
    }

    private void initGui(int layers)
    {
        /***************动态生成的每一层隐藏层panel(默认为2层)***********/
        for(int i=0;i<layers;i++)
        {
            OneHiddenLayerGui oneHiddenLayerGui = new OneHiddenLayerGui(4);
            add(oneHiddenLayerGui);
        }
    }
}
