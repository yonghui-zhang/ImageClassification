package com.zyh.image.tools;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 关于ImageIcon的公共工具类
 */
public class ImageIconTool {

    /**
     * 从某个URL读取图片并进行特定大小的转化
     * @param path
     * @param width
     * @param height
     * @return
     */
    public static ImageIcon getScaledIconFromUrl(URL path, int width, int height)
    {
        ImageIcon imageIcon = new ImageIcon(path);
        return getScaledIcon(imageIcon, width, height);
    }

    /**
     * 转换图片为特定大小
     * @param imageIcon
     * @param width
     * @param height
     * @return
     */
    public static ImageIcon getScaledIcon(ImageIcon imageIcon, int width, int height)
    {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return imageIcon;
    }

    /**
     * 提供ImageIcon的克隆
     */
    public static ImageIcon cloneImageIcon(ImageIcon icon)
    {
        Image image = icon.getImage();
        ImageIcon target = new ImageIcon();
        target.setImage(image);
        return target;
    }
}
