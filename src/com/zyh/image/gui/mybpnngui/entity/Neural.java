package com.zyh.image.gui.mybpnngui.entity;

import com.zyh.image.gui.WidgetPool;
import com.zyh.image.tools.ImageIconTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * 神经元实体
 */
public class Neural extends JLabel {

    private boolean isInputNeural;
    private boolean immune = false;//未免疫

    private int DEFAULT_NEURAL_WIDTH = 30;
    private int DEFAULT_NEURAL_HEIGHT = 30;

    private int DEFAULT_DETAILS_WIDTH = 200;
    private int DEFAULT_DETAILS_HEIGHT = 200;

    public Neural(boolean isInputNeural)
    {
        init(isInputNeural);
        initGui();
        addNeuralMouseEventListener();
    }

    private void init(boolean isInputNeural)
    {
        this.isInputNeural = isInputNeural;
    }

    private void initGui()
    {
        if(isInputNeural)
        {
            setNeuralShadow();
        }else {
            setNeuralHighlight();
        }
    }

    /**
     * 设置神经元高亮
     */
    private void setNeuralHighlight()
    {
        ImageIcon icon = ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/neural.png"), DEFAULT_NEURAL_WIDTH, DEFAULT_NEURAL_HEIGHT);
        setIcon(icon);
        /*********高亮加黑色粗体边框********/
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    }

    /**
     * 设置神经元阴影
     */
    private void setNeuralShadow()
    {
        ImageIcon icon = ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/neural_none.png"), DEFAULT_NEURAL_WIDTH, DEFAULT_NEURAL_HEIGHT);
        setIcon(icon);
        /*********阴影加白色粗体边框（为了隐藏边框）**********/
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
    }


    /**
     * 对于Neural的点击事件处理
     */
    private void addNeuralMouseEventListener()
    {
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                /********只针对Input Layer Neural有效*******/
                if (isInputNeural)
                {
                    if (!immune)
                    {
                        setNeuralHighlight();
                    }else{
                        setNeuralShadow();
                    }
                    immune = immune ? false : true;
                }
                /********显示高亮并且对Exited方法免疫********/

                /*********进行连线操作*******/
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                /***********显示高亮**********/
                if (isInputNeural)
                {
                    if (!immune)
                    {
                        setNeuralHighlight();
                    }
                }
                /**********显示该神经元的大图********/
                showNeuralDetails();
       //         updateUI();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                /**********显示阴影*********/
                if (isInputNeural)
                {
                    if (!immune)
                    {
                        setNeuralShadow();
                    }
                }
                /**********复原Output层的大图*******/
                showSourceImg();
        //        updateUI();
            }
        });
    }


    /**
     * 在Ouput层显示神经元情况的大图
     */
    private void showNeuralDetails()
    {
        JLabel output = (JLabel) WidgetPool.getInstance().getWidget("OutputLayerContext.output");
        if (null != output)
        {
            ImageIcon icon = (ImageIcon) getIcon();
            ImageIcon cloneIcon = ImageIconTool.cloneImageIcon(icon);
            cloneIcon = ImageIconTool.getScaledIcon(cloneIcon, DEFAULT_DETAILS_WIDTH, DEFAULT_DETAILS_HEIGHT);
            output.setIcon(cloneIcon);
            output.updateUI();
        }
    }

    /**
     * Output层大图复原
     */
    private void showSourceImg()
    {
        JLabel output = (JLabel) WidgetPool.getInstance().getWidget("OutputLayerContext.output");
        ImageIcon icon = ImageIconTool.getScaledIconFromUrl(getClass().getResource("/images/output.png"), DEFAULT_DETAILS_WIDTH, DEFAULT_DETAILS_HEIGHT);
        output.setIcon(icon);
        output.updateUI();
    }

}
