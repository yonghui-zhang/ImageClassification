package com.zyh.image.gui.mybpnngui;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义神经网络GUI的顶部参数设置
 */
public class ParameterTopBarGui extends JPanel {

    public ParameterTopBarGui()
    {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(1, 5, 20, 0));
        initTopBarGui();
    }

    private void initTopBarGui()
    {
        StartImgGui startImgGui = new StartImgGui();
        TimeCostGui timeCostGui = new TimeCostGui();
        LearningRateGui learningRateGui = new LearningRateGui();
        ActivationGui activationGui = new ActivationGui();
        ProblemTypeGui problemTypeGui = new ProblemTypeGui();

        /***********显示start 按钮*********/
        add(startImgGui);
        /***********显示训练时间***********/
        add(timeCostGui);
        /**********显示Learning rate*******/
        add(learningRateGui);
        /*********显示Activation 激活函数***/
        add(activationGui);
        /************显示Problem type******************/
        add(problemTypeGui);
    }
}
