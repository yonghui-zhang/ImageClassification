package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;

public class MyBpnnMainContextBottomCard extends MyPanel {

    public MyBpnnMainContextBottomCard()
    {
        initGui();
    }

    private void initGui()
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        /************左部特征输入**********/
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 0;
        FeaturesInputLayerGui inputLayerGui = new FeaturesInputLayerGui();
        gridBagLayout.setConstraints(inputLayerGui, gridBagConstraints);
        /*************中部隐藏层*************/
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 0;
        HiddenLayersGui hiddenLayersGui = new HiddenLayersGui();
        gridBagLayout.setConstraints(hiddenLayersGui, gridBagConstraints);

        /************右部输出层*************/
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 0;
        OutputLayerGui outputLayerGui = new OutputLayerGui();
        gridBagLayout.setConstraints(outputLayerGui, gridBagConstraints);

        add(inputLayerGui);
        add(hiddenLayersGui);
        add(outputLayerGui);
    }
}
