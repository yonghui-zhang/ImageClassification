package com.zyh.image.gui;

import com.zyh.image.tools.FileOperate;
import com.zyh.image.tools.StringArrayExpanded;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class DataManagerGui implements FunctionGui{

    private static DataManagerGui dataManagerGui = new DataManagerGui();

    private DataManagerGui()
    {

    }

    public static DataManagerGui getInstance()
    {
        return dataManagerGui;
    }

    @Override
    public void settingGui(JPanel panel) {
        /********数据集的管理面板**************/
        panel.setBackground(Color.WHITE);
        String path =  System.getProperty("user.dir") + "/resources/data/";

        /*******************增加对图片的预览功能****************/
        JLabel imagePreLook = new JLabel();
        imagePreLook.setBackground(Color.WHITE);
        imagePreLook.setText("预览");
        imagePreLook.setPreferredSize(new Dimension(300, 300));
        /***************data目录下的图片列表************/
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(200, 300));

        ArrayList<File> arrayList = FileOperate.getFileList(new File(path));
        StringArrayExpanded stringArrayExpanded = FileOperate.getfromArrayListFiles(arrayList);
        String[] listItem = new String[stringArrayExpanded.flag];
        System.arraycopy(stringArrayExpanded.strs, 0, listItem, 0, listItem.length);

        JList list = new JList(listItem);
        scrollPane.setViewportView(list);
        panel.add(scrollPane);
        panel.add(imagePreLook);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!list.getValueIsAdjusting()) {

                    String imagePath = (String)list.getSelectedValue();
                    imagePath = path + imagePath;
                    System.out.println(imagePath);
                    System.out.println(new File(imagePath).isFile());

                    preview(imagePreLook, imagePath);
                }
            }
        });




        /************包括对训练集和测试集的管理*********/
       JButton button = new JButton();
       button.setText("加载新的图片");
       button.setBorderPainted(false);
       button.setFocusPainted(false);
       button.setBackground(Color.WHITE);
       panel.add(button);

       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JFileChooser fileChooser = new JFileChooser();
               fileChooser.setBackground(Color.WHITE);
               fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
               fileChooser.showDialog(new JLabel(), "选择");
               File file = fileChooser.getSelectedFile();

               /**********对文件进行检测，只允许.bmp格式的图片********/
               ArrayList<File> arrayList = FileOperate.getFileList(file);
               Iterator<File> iterator = arrayList.iterator();
               while (iterator.hasNext())
               {
                   File src = iterator.next();
                   /***********拷贝一个图片到/data目录下***********/
                   File target = new File(path + src.getName());
                   FileOperate.makeFileCopy(src, target);
               }
           }
       });



    }

    private void preview(JLabel label, String imagePath)
    {
        /************设置图片自适应**************/
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        icon.setImage(img);
        label.setIcon(icon);
        label.updateUI();
    }
}
