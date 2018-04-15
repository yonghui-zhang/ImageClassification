package com.zyh.image.gui.mybpnngui;

import com.zyh.image.gui.WidgetPool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

/**
 * 神经网络隐藏层
 */
public class HiddenLayersGui extends JPanel{

    private int DEFAULT_HIDDEN_LAYERS_MIN = 1;
    private int DEFAULT_HIDDEN_LAYERS_MAX = 5;

    private int hidden_layers;

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
        hiddenLayersContext = new HiddenLayersContext();
        hidden_layers = hiddenLayersContext.getDEFAULT_HIDDEN_LAYERS();
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
              if (!isFixHiddenLayers())
              {
                  addOneHiddenLayer();
              }
              title.setText(" " + hidden_layers + " HIDDEN LAYERS");
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
                if (!isFixHiddenLayers())
                {
                    subOneHiddenLayer();
                }
                title.setText(" " + hidden_layers + " HIDDEN LAYERS");
            }
        });
    }
    /**
     * 增加一层隐藏层
     */
    private void addOneHiddenLayer()
    {
        /*********增加一层隐藏层*******/
        OneHiddenLayerGui oneHiddenLayerGui = new OneHiddenLayerGui();
        hiddenLayersContext.add(oneHiddenLayerGui);
        hiddenLayersContext.getHiddenLayers().add(oneHiddenLayerGui);

        hiddenLayersContext.updateUI();
    }

    /**
     * 减少一层隐藏层
     */
    private void subOneHiddenLayer()
    {
        /*********减少一层隐藏层（默认减去第一个隐藏层）******/
        Iterator<OneHiddenLayerGui> iterator = hiddenLayersContext.getHiddenLayers().iterator();
        if (iterator.hasNext())
        {
            OneHiddenLayerGui oneHiddenLayerGui = iterator.next();
            hiddenLayersContext.remove(oneHiddenLayerGui);
            hiddenLayersContext.getHiddenLayers().remove(oneHiddenLayerGui);
        }
        hiddenLayersContext.updateUI();
    }

    /**
     * 检查隐藏层的边界（默认为1到5）
     */
    private boolean isFixHiddenLayers()
    {
        if(hidden_layers < DEFAULT_HIDDEN_LAYERS_MIN)
        {
            hidden_layers = DEFAULT_HIDDEN_LAYERS_MIN;
            return true;
        } else if (hidden_layers > DEFAULT_HIDDEN_LAYERS_MAX)
        {
            hidden_layers = DEFAULT_HIDDEN_LAYERS_MAX;
            return true;
        }else {
            return false;
        }
    }
}
