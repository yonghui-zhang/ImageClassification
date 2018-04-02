package com.zyh.image.tools;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.util.Properties;

public class ComputerInfo {

    public static String getComputerOsInfo()
    {
        Properties props = System.getProperties();
        return props.getProperty("os.name");
    }
    public static int getComputerCpuNum()
    {
        Runtime runtime = Runtime.getRuntime();
        return runtime.availableProcessors();
    }

   public static String getComputerCpuInfo() throws SigarException {
       Sigar sigar = new Sigar();
       CpuInfo[] infos = sigar.getCpuInfoList();
       System.out.println(infos[0].getVendor());
       System.out.println(infos[0].getModel());
       return infos[0].getVendor() + " " + infos[0].getModel();
   }

   public static double getComputerTotalMemory()
   {
       Sigar sigar = new Sigar();
       Mem mem = null;
       try {
           mem = sigar.getMem();
       } catch (SigarException e) {
           e.printStackTrace();
       }
       double totalMem = Double.parseDouble(String.format("%.2f", mem.getTotal() * 1.0 /1024L /1024L /1024L));
       return totalMem;
   }
}
