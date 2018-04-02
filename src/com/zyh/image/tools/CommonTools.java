package com.zyh.image.tools;

public class CommonTools {

    public static void printArray(double[] array)
    {
        System.out.print("[ ");
        for (int i=0;i<array.length;i++)
        {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            }else{
                System.out.print(array[i]);
            }
        }
        System.out.print(" ]");
        System.out.println();
    }

    public static void printMatrix(double[][] matrix)
    {
        System.out.print("[ ");
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[i].length;j++)
            {
                if (i == matrix.length-1 && j == matrix[i].length-1)
                {
                    System.out.print(matrix[i][j]);
                }else {
                    System.out.print(matrix[i][j] + ", ");
                }
            }
            System.out.println();
        }
        System.out.print(" ]");
        System.out.println();
    }
}
