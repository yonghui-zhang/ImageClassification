package com.zyh.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class ImageHandler {


    public static void getCenterOfImage(int[][] matrix)
    {
        //利用矩阵的一阶矩求解二值图像的重心
        int M00 = 0;
        int M10 = 0;
        int M01 = 0;

        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[i].length;j++)
            {
                M00 += matrix[i][j];
                M10 += matrix[i][j] * i;
                M01 += matrix[i][j] * j;
            }
        }
        int x = M10 / M00;
        int y = M01 / M00;

        System.out.println("物体的重心为：(" + x + "," + y + ")");
    }

    public static double[] getOneVector(String imgPath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imgPath));
        Raster raster = bufferedImage.getData();

        int[] temp = new int[raster.getWidth() * raster.getHeight() * raster.getNumBands()];
        int[] pixels = raster.getPixels(0,0,raster.getWidth(), raster.getHeight(), temp);
        double[] vector = new double[pixels.length];
        for (int i=0;i<vector.length;i++)
        {
            vector[i] = pixels[i];
        }
        return vector;
    }

    public static String[] getImgPathList(String pathRoot, String type, int imgNum)
    {
        String[] pathList = new String[imgNum];
        for (int i=1;i<=imgNum;i++)
        {
            String imgPath = pathRoot + "\\" + type + "\\" + i + ".bmp";
   //         System.out.println(imgPath);
            pathList[i-1] = imgPath;
        }
       return pathList;
    }
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Administrator\\Desktop\\san1.bmp";
        BufferedImage bufferedImage = ImageIO.read(new File(path));

//        int[][] data = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];
//
//        for (int i=0;i<bufferedImage.getWidth();i++)
//        {
//            for (int j=0;j<bufferedImage.getHeight();j++)
//            {
//                data[i][j] = bufferedImage.getRGB(i,j);
//                System.out.printf("%x\t", data[i][j]);
//            }
//        }
        Raster raster = bufferedImage.getData();
        int num = raster.getNumBands();
        System.out.println("num of bands is :" + num);
        int[] temp = new int[raster.getWidth() * raster.getHeight() * raster.getNumBands()];
        int[] pixels = raster.getPixels(0,0,raster.getWidth(), raster.getHeight(), temp);

//        for (int i=0;i<pixels.length;i++)
//        {
//            System.out.print(pixels[i]);
//            if(i>0 && i % raster.getWidth() == 0)
//            {
//                System.out.println();
//            }
//        }
        //将一维数组转化为二维矩阵
        int[][] matrix = new int[raster.getHeight()][raster.getWidth()];
        for (int i=0;i<raster.getHeight();i++)
        {
            for (int j=0;j<raster.getWidth();j++)
            {
                matrix[i][j] = 1 - pixels[i*raster.getWidth()+j];
                //矩阵的值反置

            }
        }
        System.out.println("matrix height: " + matrix.length);
        System.out.println("matrix width:" + matrix[0].length);
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[i].length;j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        getCenterOfImage(matrix);
    }
}
