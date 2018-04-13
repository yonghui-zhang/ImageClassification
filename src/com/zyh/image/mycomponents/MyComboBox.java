package com.zyh.image.mycomponents;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class MyComboBox<E> extends JComboBox{

   public MyComboBox(E[] items)
   {
       super(items);
       setRenderer(new MyCellRenderer());
       setUI(new MyComboBoxUi());
   }

    /**
     * 自定义List风格，设置背景为白色
     */
    class MyCellRenderer implements ListCellRenderer{

        private DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            JLabel renderer = (JLabel) defaultListCellRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (isSelected)
            {
                renderer.setForeground(Color.WHITE);
                renderer.setBackground(Color.PINK);
            }else {
                renderer.setBackground(Color.WHITE);
            }
       //     list.setBorder(null);
            return renderer;
        }
    }

    /**
     * 自定义UI风格
     */
    class MyComboBoxUi extends BasicComboBoxUI
    {
        @Override
        protected JButton createArrowButton() {

          MyButton button = new MyButton();
          ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/arrow.png"));
          imageIcon.setImage(imageIcon.getImage().getScaledInstance(17, 14, Image.SCALE_DEFAULT));
          button.setIcon(imageIcon);
          return button;
        }
    }
}
