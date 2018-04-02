package com.zyh.image.getfeature;

public class ImageCenter {

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
}
