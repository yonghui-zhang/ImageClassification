package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;

public class OutputLayerGui extends MyPanel {

    public OutputLayerGui()
    {
        initGui();
    }

    private void initGui()
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        /*******大标题******/
        gridBagConstraints.gridwidth = 0;
        JLabel topTitle = new JLabel();
        topTitle.setText("OUTPUT");
        topTitle.setPreferredSize(new Dimension(100, 30));
        topTitle.setFont(new Font("宋体", Font.BOLD, 20));
        gridBagLayout.setConstraints(topTitle, gridBagConstraints);

        /*******小描述*********/
        gridBagConstraints.gridwidth = 0;
        JLabel descripts = new JLabel();
        descripts.setPreferredSize(new Dimension(100, 30));
        descripts.setText("Test loss 0.498");
        gridBagLayout.setConstraints(descripts, gridBagConstraints);

        /*******展示数据训练情况*****/
        gridBagConstraints.gridwidth = 0;
        OutputLayerContext outputLayerContext = new OutputLayerContext();
        gridBagLayout.setConstraints(outputLayerContext, gridBagConstraints);

        add(topTitle);
        add(descripts);
        add(outputLayerContext);
    }
}
