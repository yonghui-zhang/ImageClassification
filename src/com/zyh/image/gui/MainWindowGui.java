package com.zyh.image.gui;

import com.zyh.image.mycomponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MainWindowGui {

    private JFrame frame = new JFrame();

    private int windowWidth = 900;
    private int windowHeight = 600;

    private int first_x, first_y;

    private HashMap<JButton, JPanel> map = new HashMap<>();
    private ArrayList<JPanel> panelList = new ArrayList<>();
    private ArrayList<JButton> btnList = new ArrayList<>();

    private JPanel panel0;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;


    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;

    public MainWindowGui()
    {
        Container container = frame.getContentPane();
        setTopContext(container);
        setRightContext(container);
        setLeftContext(container);
        setMainFrame(frame);
        /***************设置软件图标*****************/
        setSoftwareIcon(frame);
    }
    /*
      设置右侧内容
     */
    private void setRightContext(Container container)
    {
        /*************************中间内容设置***********************************/
        JPanel context = new JPanel();
        context.setBackground(Color.WHITE);

        panel0 = new JPanel();//图像数据集管理
        panel1 = new JPanel();//图像特征提取
        panel2 = new JPanel();//神经网络参数设置
        panel3 = new JPanel();//训练和测试
        panel4 = new JPanel();//性能监控

        panelList.add(panel0);
        panelList.add(panel1);
        panelList.add(panel2);
        panelList.add(panel3);
        panelList.add(panel4);

        panel0.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(true);

        DataManagerGui dataManagerGui = DataManagerGui.getInstance();
        dataManagerGui.settingGui(panel0);
        ImageFeatureExtractGui imageFeature = ImageFeatureExtractGui.getInstance();
        imageFeature.settingGui(panel1);
        NeuronNetworkSettingGui nnGui =  NeuronNetworkSettingGui.getInstance();
        nnGui.settingGui(panel2);
        TrainAndTestGui trainAndTest = TrainAndTestGui.getInstance();
        trainAndTest.settingGui(panel3);
        NetworkMonitorGui networkMonitorGui = NetworkMonitorGui.getInstance();
        networkMonitorGui.settingGui(panel4);

        for (JPanel panel : panelList)
        {
            context.add(panel);
        }
        container.add(context, BorderLayout.CENTER);
    }
    /*
      设置左侧内容
     */
    private void setLeftContext(Container container)
    {
        /*************************左部内容设置***********************************/
        JPanel menu = new JPanel();
        menu.setBackground(Color.PINK);
        menu.setLayout(new GridLayout(10, 1));
        btn0 = new JButton("图像数据集管理");
        btn1 = new JButton("图像特征提取");
        btn2 = new JButton("神经网络参数设置");
        btn3 = new JButton("数据训练和测试");
        btn4 = new JButton("性能监控");

        btnList.add(btn0);
        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);
        btnList.add(btn4);

        CommonGuiTools.setJButtonsStyle(btnList, Color.PINK);
        CommonGuiTools.setJButtonFont(btnList, new Font("宋体", Font.BOLD, 14));

        map.put(btn0, panel0);
        map.put(btn1, panel1);
        map.put(btn2, panel2);
        map.put(btn3, panel3);
        map.put(btn4, panel4);

        for (JButton btn : btnList)
        {
            CommonGuiTools.listenButtonClick(btn, map, panelList);
        }

        menu.add(btn0);
        menu.add(btn1);
        menu.add(btn2);
        menu.add(btn3);
        menu.add(btn4);

        container.add(menu, BorderLayout.WEST);
    }
    /*
      设置上部内容
     */
    private void setTopContext(Container container)
    {
        /*************************上部内容设置***************************/
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.WHITE);

        //改用GridBagLayout灵活变动布局
        GridBagLayout gridBagLayout = new GridBagLayout();
        logoPanel.setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridwidth = 1;
        JLabel logoLabel = new JLabel();

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo.png"));
        logoLabel.setIcon(logoIcon);
        logoLabel.setPreferredSize(new Dimension(200, 60));
        gridBagLayout.setConstraints(logoLabel, gridBagConstraints);
        logoPanel.add(logoLabel);

        gridBagConstraints.gridwidth = 4;
        JLabel title = new JLabel("BP神经网络训练平台", JLabel.CENTER);
        title.setFont(new Font("宋体", Font.BOLD, 20));
        title.setPreferredSize(new Dimension(604, 60));
        gridBagLayout.setConstraints(title, gridBagConstraints);
        logoPanel.add(title);


        ImageIcon closeIcon = new ImageIcon(getClass().getResource("/images/close.png"));
        closeIcon.setImage(closeIcon.getImage().getScaledInstance(29, 30, Image.SCALE_DEFAULT));

        gridBagConstraints.gridwidth = 0;
        MyButton closeBtn = new MyButton(closeIcon);
        gridBagLayout.setConstraints(closeBtn, gridBagConstraints);
        logoPanel.add(closeBtn);

        ArrayList<JButton> btns = new ArrayList<>();
        btns.add(closeBtn);

        closeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);//系统退出
            }
        });
        container.add(logoPanel, BorderLayout.NORTH);
    }
    /*
      设置主窗体的属性
     */
    private void setMainFrame(JFrame frame)
    {
        frame.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                first_x = e.getX();//记录鼠标初始点
                first_y = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}

        });
        frame.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() - first_x;
                int y = e.getY() - first_y;
                frame.setBounds(frame.getX()+x, frame.getY()+y, windowWidth, windowHeight);
            }
            @Override
            public void mouseMoved(MouseEvent e) {}
        });
         int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
         int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds((screenWidth-windowWidth)/2, (screenHeight-windowHeight)/2,
                windowWidth, windowHeight);
        frame.setTitle("BP神经网络图像分类");
        frame.setUndecorated(true);//去掉边框
        frame.setVisible(true);
    }
    /*
       设置软件的图标
     */
    private void setSoftwareIcon(JFrame frame)
    {
        /***************设置软件图标*****************/
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/icon.jpg"));
        logoIcon.setImage(logoIcon.getImage().getScaledInstance(256, 190, Image.SCALE_DEFAULT));
        frame.setIconImage(logoIcon.getImage());
    }
    public static void main(String[] args)
    {
       new MainWindowGui();
    }
}