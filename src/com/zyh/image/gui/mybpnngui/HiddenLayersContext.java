package com.zyh.image.gui.mybpnngui;

import com.zyh.image.gui.WidgetPool;
import com.zyh.image.gui.mybpnngui.entity.Neural;
import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 隐藏层的正文
 */
public class HiddenLayersContext extends MyPanel{

    private ArrayList<OneHiddenLayerGui> hiddenLayers;

    private int DEFAULT_HIDDEN_LAYERS = 2;

    public HiddenLayersContext()
    {
        setLayout(new GridLayout(1, DEFAULT_HIDDEN_LAYERS, 0, 10));
        initGui();
    }

    public ArrayList<OneHiddenLayerGui> getHiddenLayers() {
        return hiddenLayers;
    }

    public int getDEFAULT_HIDDEN_LAYERS() {
        return DEFAULT_HIDDEN_LAYERS;
    }

    private void initGui()
    {
        hiddenLayers = new ArrayList<>();
        createHiddenLayers(DEFAULT_HIDDEN_LAYERS);
        drawLineLayer2Layer();
    }

    /**
     * 创建隐藏层
     */
    private void createHiddenLayers(int layers)
    {
        /***************动态生成的每一层隐藏层panel***********/
        for(int i=0;i<layers;i++)
        {
            OneHiddenLayerGui oneHiddenLayerGui = new OneHiddenLayerGui();
            add(oneHiddenLayerGui);

            hiddenLayers.add(oneHiddenLayerGui);
        }
    }

    /**
     * 相邻两个隐藏层两两神经元画线
     */
    private void drawLineLayer2Layer()
    {
        OneHiddenLayerGui srcHiddenLayer;
        Iterator<OneHiddenLayerGui> iterator = hiddenLayers.iterator();
        if (iterator.hasNext())
        {
            srcHiddenLayer = iterator.next();
        }else{
            return;
        }

        while (iterator.hasNext())
        {
            OneHiddenLayerGui nextHiddenLayer = iterator.next();
            /**********对两个隐藏层进行画线处理******/
            drawLineNeural2Neural(srcHiddenLayer, nextHiddenLayer);
            srcHiddenLayer = nextHiddenLayer;
        }
    }
    /**
     * 两个隐藏层之间的神经元具体画线逻辑
     */
    private void drawLineNeural2Neural(OneHiddenLayerGui src, OneHiddenLayerGui target)
    {
        Iterator<Neural> srcNeuralList = src.getOneContext().getNeuralList().iterator();
        Iterator<Neural> targetNeuralList = target.getOneContext().getNeuralList().iterator();
        while (srcNeuralList.hasNext())
        {
            Neural srcNeural = srcNeuralList.next();
            while (targetNeuralList.hasNext())
            {
                Neural targetNeural = targetNeuralList.next();
                /********执行画线逻辑********/
                NeuralLine2Neural rect = new NeuralLine2Neural(srcNeural, targetNeural);
                MyBpnnMainContextUpCard upCard = (MyBpnnMainContextUpCard) WidgetPool.getInstance().getWidget("MyBpnnMainContextUpCard");

                upCard.add(rect);
            }
        }
    }
}
