package com.zyh.image.gui;

import com.zyh.image.mycomponents.MyPanel;
import com.zyh.image.tools.FileOperate;
import com.zyh.image.tools.ImageIconTool;
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

public class DataManagerGui extends MyPanel{

    public DataManagerGui()
    {
       initGui();
    }

    private void initGui() {
        /********数据集的管理面板**************/
        //改用GridBagLayout灵活变动布局
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        String path =  System.getProperty("user.dir") + "/resources/data/";

        /*****************增加标题******************/
        gridBagConstraints.gridwidth = 1;
        JLabel titleLabel = new JLabel();
        titleLabel.setText("图片数据集");
        titleLabel.setPreferredSize(new Dimension(100, 50));
        titleLabel.setFont(new Font("宋体", Font.BOLD, 16));
        gridBagLayout.setConstraints(titleLabel, gridBagConstraints);

        /*************填充***********/
        gridBagConstraints.gridwidth = 2;
        JLabel nopLabel = new JLabel();
    //    nopLabel.setPreferredSize(new Dimension(100, 20));
        gridBagLayout.setConstraints(nopLabel, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        JLabel preLookTitle = new JLabel();
        preLookTitle.setText("预览区域");
        preLookTitle.setPreferredSize(new Dimension(100, 50));
        preLookTitle.setFont(new Font("宋体", Font.BOLD, 16));
        gridBagLayout.setConstraints(preLookTitle, gridBagConstraints);

        /************包括对训练集和测试集的管理*********/
        gridBagConstraints.gridwidth = 0;
        JButton button = new JButton();
        button.setText("加载新的图片");
        button.setFont(new Font("宋体", Font.BOLD, 12));
        gridBagLayout.setConstraints(button, gridBagConstraints);
    //    button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(Color.WHITE);

        /***************data目录下的图片列表************/
        gridBagConstraints.gridwidth = 2;
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(140, 300));
        gridBagLayout.setConstraints(scrollPane, gridBagConstraints);
        /*************填充***********/
//        gridBagConstraints.gridwidth = 2;
        JLabel nopLabel2 = new JLabel();
        nopLabel2.setPreferredSize(new Dimension(50, 300));
//        gridBagLayout.setConstraints(nopLabel2, gridBagConstraints);
        /*******************增加对图片的预览功能****************/
        gridBagConstraints.gridwidth = 0;
        JLabel imagePreLook = new JLabel();
        imagePreLook.setBackground(Color.WHITE);
        imagePreLook.setText("预览区域");
        imagePreLook.setPreferredSize(new Dimension(300, 300));
        gridBagLayout.setConstraints(imagePreLook, gridBagConstraints);

        addJListListener(scrollPane, path, imagePreLook);
        addFileSelectListener(button, scrollPane, path, imagePreLook);

        add(titleLabel);
        add(nopLabel);
        add(preLookTitle);
        add(button);
        add(scrollPane);
        add(nopLabel2);
        add(imagePreLook);
    }

    /**
     * 得到data目录下的所有文件的列表（bmp图像集）
     * @param path
     * @return
     */
    private String[] getFileList(String path)
    {
        ArrayList<File> arrayList = FileOperate.getFileList(new File(path));
        StringArrayExpanded stringArrayExpanded = FileOperate.getfromArrayListFiles(arrayList);
        String[] listItem = new String[stringArrayExpanded.flag];
        System.arraycopy(stringArrayExpanded.strs, 0, listItem, 0, listItem.length);
        return listItem;
    }

    /**
     * 对图片进行预览
     * @param label
     * @param imagePath
     */
    private void preview(JLabel label, String imagePath)
    {
        /************设置图片自适应**************/
        ImageIcon icon = new ImageIcon(imagePath);
       // icon = ImageIconTool.getScaledIcon(icon, label.getWidth(), label.getHeight());
        label.setIcon(icon);
        label.setText("");
        label.updateUI();
    }

    /**
     * 增加对JList的监听，显示当前选中的图片信息
     * @param scrollPane
     * @param path
     * @param imagePreLook
     */
    private void addJListListener(JScrollPane scrollPane, String path, JLabel imagePreLook)
    {
        String[] listItem =  getFileList(path);
        JList list = new JList(listItem);
        scrollPane.setViewportView(list);

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
    }

    /**
     * 对文件选择按钮进行监听，执行拷贝动作和刷新左侧JList列表
     * @param button
     * @param scrollPane
     * @param path
     * @param imagePreLook
     */
    private void addFileSelectListener(JButton button, JScrollPane scrollPane, String path, JLabel imagePreLook)
    {
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

                /************刷新JList列表*************/
                addJListListener(scrollPane, path, imagePreLook);
            }
        });
    }
}
