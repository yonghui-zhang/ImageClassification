package com.zyh.image.gui.mybpnngui;

import com.zyh.image.gui.mybpnngui.entity.Neural;
import com.zyh.image.mycomponents.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 动态生成的hidden layer neural
 */
public class OneHiddenLayerNeuralContext extends MyPanel{

    private ArrayList<Neural> neuralList;
    private int DEFAULT_NEURALS = 8;
    private int DEFAULT_MINNEURALS = 1;
    private int neurals = DEFAULT_NEURALS;

    private JButton addbtn;
    private JButton subbtn;
    private JLabel title;

    public OneHiddenLayerNeuralContext(JButton addbtn, JButton subbtn, JLabel title)
    {
         initItems(addbtn, subbtn, title);
         setLayout(new GridLayout(neurals, 1, 0, 10));
         initGui();
         addOneHiddenLayerNeuralsListener();
         subOneHiddenLayerNeuralsListener();
    }

    public ArrayList<Neural> getNeuralList() {
        return neuralList;
    }

    private void initItems(JButton addbtn, JButton subbtn, JLabel title)
    {
        neuralList = new ArrayList<>();
        this.addbtn = addbtn;
        this.subbtn = subbtn;
        this.title = title;
    }

    private void initGui()
    {
          /********动态添加neural*********/
          for (int i=0;i<neurals;i++)
          {
             addOneNeural();
          }
    }
    /**
     * 增加一个隐藏层上的神经元(监听事件)
     */
    private void addOneHiddenLayerNeuralsListener()
    {
        /********生成一个新的Neural，并添加到Neural List中*****/
        addbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                neurals++;
                if (neurals > DEFAULT_NEURALS)
                {
                    fixOneHiddenLayerNeurals();
                }else{
                    addOneNeural();
                }
                title.setText(neurals + " neurals");
                updateUI();
            }
        });
    }

    /**
     * 减少一个隐藏层上的神经元（监听事件）
     */
    private void subOneHiddenLayerNeuralsListener()
    {
        /********从Neural List中获取并任意移除一个*****/
        subbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                neurals--;
                if(neurals < DEFAULT_MINNEURALS)
                {
                    fixOneHiddenLayerNeurals();
                }else{
                    subOneNeural();
                }
                title.setText(neurals + " neurals");
                updateUI();
            }
        });
    }

    /**
     * 添加一个神经元
     */
    private void addOneNeural()
    {
        Neural neural = new Neural(false);
        neuralList.add(neural);
        add(neural);
    }

    /**
     * 移除任意一个神经元
     */
    private void subOneNeural()
    {
        Iterator<Neural> iterator = neuralList.iterator();
        if(iterator.hasNext())
        {
            Neural neural = iterator.next();
            neuralList.remove(neural);
            remove(neural);
        }
    }
    /**
     * 检查神经元的个数（默认为1到n）
     */
    private void fixOneHiddenLayerNeurals()
    {
        if(neurals < DEFAULT_MINNEURALS)
        {
            neurals = DEFAULT_MINNEURALS;
        }else if(neurals > DEFAULT_NEURALS)
        {
            neurals = DEFAULT_NEURALS;
        }
    }
}
