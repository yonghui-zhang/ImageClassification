package com.zyh.image.gui.mybpnngui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 神经网络隐藏层
 */
public class HiddenLayersGui extends JPanel{

    private int DEFAULT_HIDDEN_LAYERS = 2;
    private int hidden_layers = DEFAULT_HIDDEN_LAYERS;

    private HiddenLayersContext hiddenLayersContext;

    public HiddenLayersGui()
    {
        super();
        setBackground(Color.WHITE);
        initGui();
    }

    private void initGui()
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        /*********Hidden Layer顶部栏********/
        gridBagConstraints.gridwidth = 0;
        HiddenLayerTopBarGui hiddenLayerTopBarGui = new HiddenLayerTopBarGui();
        gridBagLayout.setConstraints(hiddenLayerTopBarGui, gridBagConstraints);

        /***********Hidden Layer底线********/
        gridBagConstraints.gridwidth = 0;
        HiddenLayerBottomLineGui bottomLineGui = new HiddenLayerBottomLineGui();
        gridBagLayout.setConstraints(bottomLineGui, gridBagConstraints);

        /**********Hidden Layer正文块**********/
        gridBagConstraints.gridwidth = 0;
        hiddenLayersContext = new HiddenLayersContext(hidden_layers);
        gridBagLayout.setConstraints(hiddenLayersContext, gridBagConstraints);

        add(hiddenLayerTopBarGui);
        add(bottomLineGui);
        add(hiddenLayersContext);

        /********增加对按钮的监听*******/
        addOneHiddenLayerListener(hiddenLayerTopBarGui.getAddbtn(), hiddenLayerTopBarGui.getTitle());
        subOneHiddenLayerListener(hiddenLayerTopBarGui.getSubbtn(), hiddenLayerTopBarGui.getTitle());
    }

    /**
     * 添加隐藏层
     */
    private void addOneHiddenLayerListener(JButton addbtn, JLabel title)
    {
        addbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              /******增加一层隐藏层***/
              hidden_layers++;
              fixHiddenLayers();
              updateHiddenLayers(title);

              updateUI();
            }
        });
    }
    /**
     * 减少隐藏层
     */
    private void subOneHiddenLayerListener(JButton subbtn, JLabel title)
    {
        subbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /******减少一层隐藏层******/
                hidden_layers--;
                fixHiddenLayers();
                updateHiddenLayers(title);

                updateUI();
            }
        });
    }

    /**
     * 更新隐藏层
     */
    private void updateHiddenLayers(JLabel title)
    {
        /***********更新隐藏层*************/
        remove(hiddenLayersContext);
        hiddenLayersContext = new HiddenLayersContext(hidden_layers);
        add(hiddenLayersContext);
        /**********更新隐藏层的层数*******/
        title.setText(" " + hidden_layers + " HIDDEN LAYERS");
    }

    /**
     * 检查隐藏层的边界（默认为1到5）
     */
    private void fixHiddenLayers()
    {
        if(hidden_layers < 1)
        {
            hidden_layers = 1;
        } else if (hidden_layers > 5)
        {
            hidden_layers = 5;
        }
    }
}
