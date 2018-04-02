package com.zyh.image.tools;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;

public class FileOperate {

    /*
      文件的拷贝
     */
    public static void makeFileCopy(File src, File target)
    {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;

        try {
            fi = new FileInputStream(src);
            fo = new FileOutputStream(target);
            in = fi.getChannel();
            out = fo.getChannel();
            in.transferTo(0, in.size(), out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
      遍历文件夹
     */
     public static ArrayList<File> getFileList(File file)
     {
         ArrayList<File> arrayList = new ArrayList<>();

         if (file.isDirectory())
         {
              /********递归遍历所有文件********/
              traverseFolder(file, arrayList);
         }else if (file.isFile()){
             arrayList.add(file);
         }
         return arrayList;
     }

     private static void traverseFolder(File folder, ArrayList<File> arrayList)
     {
         if (folder.exists())
         {
             File[] files = folder.listFiles();
             if (files.length == 0)
             {
                 System.out.println("文件夹为空");
                 return ;
             }else{
                 for (File file : files)
                 {
                     if (file.isDirectory())
                     {
                         traverseFolder(new File(file.getAbsolutePath()), arrayList);
                     }else
                     {
                         arrayList.add(new File(file.getAbsolutePath()));
                     }
                 }
             }
         }
     }

     public static StringArrayExpanded getfromArrayListFiles(ArrayList<File> arrayList)
     {
         StringArrayExpanded stringExpanded = new StringArrayExpanded();
         Iterator<File> iterator = arrayList.iterator();
         while (iterator.hasNext())
         {
              File file = iterator.next();
              stringExpanded.strs[stringExpanded.flag++] = file.getName();
              stringExpanded.isExpanded();
         }
         return stringExpanded;
     }
}
