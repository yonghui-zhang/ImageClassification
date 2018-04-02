package com.zyh.image.bpnn;

import com.zyh.image.ImageHandler;

import java.io.IOException;

/*
  使用图像的所有像素点作为特征
 */
public class ImageClassification {


    public static void trainImg(Bp bp, BpMonitor bpMonitor, int num, String rootPath, String type) throws IOException {
        String[] pathList = ImageHandler.getImgPathList(rootPath, type, num);
        for (String path : pathList)
        {
             double[] vector = ImageHandler.getOneVector(path);
             double[] target = new double[3];
             if (type.equals("三角形"))
             {
                 target[0] = 1;
             }else if (type.equals("矩形"))
             {
                 target[1] = 1;
             }else if (type.equals("五边形"))
             {
                 target[2] = 1;
             }else {
                 System.out.println("出现错误！");
                 return;
             }
             bp.train(vector, target);
          //   bpMonitor.showAllParameter();
        }
    }

    public static void testBp(Bp bp,  int num, String rootPath, String type) throws IOException {
        String[] pathList = ImageHandler.getImgPathList(rootPath, type, num);

        int all = 0;
        int right = 0;

        for (String path : pathList)
        {
            double[] vector = ImageHandler.getOneVector(path);
            double[] target = new double[3];
            if (type.equals("三角形"))
            {
                target[0] = 1;
            }else if (type.equals("矩形"))
            {
                target[1] = 1;
            }else if (type.equals("五边形"))
            {
                target[2] = 1;
            }else {
                System.out.println("出现错误！");
                return;
            }
           double[] out_x = new double[3];
            bp.predict(vector, out_x);
            double max = Integer.MIN_VALUE;
            int flag = -1;

            for (int i=0;i<out_x.length;i++)
            {
                if (out_x[i] > max)
                {
                    max = out_x[i];
                    flag = i;
                }
            }
            if (target[flag] == 1)
            {
                right++;
            }
            all++;
        }

        System.out.println("神经网络的正确率为：" + (right*1.0)/all*100 + "%");

    }

    public static void main(String[] args) throws IOException {
        Bp bp = new Bp(40*40, 2000, 3, 0.05);
        BpMonitor bpMonitor = new BpMonitor(bp);
        String rootPath = "C:\\Users\\Administrator\\Desktop\\images";
        //定义三角形为100，矩形为010，五边形为001
        int num0 = 10;//三角形个数
        int num1 = 6; //矩形个数
        int num2 = 6; //五边形个数
        trainImg(bp, bpMonitor, num0, rootPath, "三角形");
        trainImg(bp, bpMonitor, num1, rootPath, "矩形");
        trainImg(bp, bpMonitor, num2, rootPath, "五边形");
        System.out.println("训练完成");
        System.out.println("进行预测。。。");
        testBp(bp, num0, rootPath, "三角形");
        testBp(bp, num1, rootPath, "矩形");
        testBp(bp, num2, rootPath, "五边形");
    }
}
