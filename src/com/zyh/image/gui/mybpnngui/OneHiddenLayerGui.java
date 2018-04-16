package com.zyh.image.gui.mybpnngui;

import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 每一层隐藏层的GUI
 */
public class OneHiddenLayerGui extends MyPanel{

    private  OneHiddenLayerNeuralContext oneContext ;

    public OneHiddenLayerGui()
    {
        initGui();
    }

    public OneHiddenLayerNeuralContext getOneContext() {
        return oneContext;
    }

    private void initGui()
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        /**********上部的neurals title******/
        gridBagConstraints.gridwidth = 0;
        ButtonTopBarGui topBarGui = new ButtonTopBarGui();
        gridBagLayout.setConstraints(topBarGui, gridBagConstraints);

        gridBagConstraints.gridwidth = 0;
        JLabel title = new JLabel();
        title.setText("8 neurals");
        gridBagLayout.setConstraints(title, gridBagConstraints);
        /*************下部的神经元**********/
        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.gridheight = 0;
        oneContext = new OneHiddenLayerNeuralContext(topBarGui.getAddbtn(),
                topBarGui.getSubbtn(),
                title);
        gridBagLayout.setConstraints(oneContext, gridBagConstraints);

        add(topBarGui);
        add(title);
        add(oneContext);
    }
}
