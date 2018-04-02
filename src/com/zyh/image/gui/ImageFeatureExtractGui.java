package com.zyh.image.gui;

import com.zyh.image.ImageHandler;

import javax.swing.*;

public class ImageFeatureExtractGui implements FunctionGui{

    private static ImageFeatureExtractGui imageFeature = new ImageFeatureExtractGui();

    private ImageFeatureExtractGui()
    {

    }
    public static ImageFeatureExtractGui getInstance()
    {
        return imageFeature;
    }
    @Override
    public void settingGui(JPanel panel) {
        /***********图像特征提取的面板***************/

        JButton btn = new JButton("图像特征提取的面板");
        panel.add(btn);
        /*************数字图像处理的几种特征的选取*****/
    }
}
