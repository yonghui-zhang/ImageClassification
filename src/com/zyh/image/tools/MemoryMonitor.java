package com.zyh.image.tools;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class MemoryMonitor {

//    private static Mem mem;
//
//    static {
//        try {
//            mem = ComputerMonitor.getInstance().getMem();
//        } catch (SigarException e) {
//            e.printStackTrace();
//        }
//    }

    public static double getCurrentMemoryUsed() throws SigarException {

        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        double usedMem = Double.parseDouble(String.format("%.2f", mem.getUsed() * 1.0 /1024L /1024L /1024L));

        return usedMem;
    }

    public static int getMemoryUsedRate() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        double rate = (mem.getUsed() * 1.0 / mem.getTotal()) * 100D;
        return (int) Math.round(rate);
    }

    public static void main(String[] args) throws SigarException {
        while(true)
        {
            System.out.println(getCurrentMemoryUsed());
            System.out.println(getMemoryUsedRate());
        }
    }
}
