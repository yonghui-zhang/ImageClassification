package com.zyh.image.other;

import org.hyperic.sigar.*;

import java.util.Properties;

public class RuntimeTest {
    public static void main(String[] args0) throws SigarException {
        Sigar sigar = new Sigar();
//        Mem mem = sigar.getMem();
//        System.out.println("内存总量：" + String.format("%.2f", mem.getTotal() * 1.0 /1024L /1024L /1024L) + "G");
//        System.out.println("当前内存使用量：" + String.format("%.2f", mem.getUsed() * 1.0 /1024L /1024L /1024L) + "G");
//        System.out.println("当前内存剩余量：" + String.format("%.2f", mem.getFree() * 1.0 /1024L /1024L /1024L) + "G");
//
//        CpuPerc[] cpuPercs = sigar.getCpuPercList();
//        System.out.println(cpuPercs.length);
//
//
//            for (CpuPerc cpuPerc : cpuPercs)
//            {
////            System.out.println("CPU的用户使用率:" + CpuPerc.format(cpuPerc.getUser()));
////            System.out.println("CPU的系统使用率：" + CpuPerc.format(cpuPerc.getSys()));
//           System.out.println("CPU总的使用率：" + CpuPerc.format(cpuPerc.getCombined()));
//                System.out.println(cpuPerc.getCombined());
//
//
//        }

//        OperatingSystem os = OperatingSystem.getInstance();
//        System.out.println("操作系统：" + os.getDescription() + " " + os.getArch());
//        System.out.println(os.getVersion());

//        Runtime runtime = Runtime.getRuntime();
//        Properties props = System.getProperties();
//
//        System.out.println(runtime.totalMemory());
//        System.out.println(runtime.freeMemory());
//        System.out.println(runtime.maxMemory());
//        System.out.println(runtime.availableProcessors());
//
//        System.out.println(props.getProperty("java.version"));
//        System.out.println(props.getProperty("os.name"));
//
//        System.out.println(String.format("%.2f", runtime.totalMemory() * 1.0 /1024L /1024L) + "M");
//        System.out.println(String.format("%.2f", runtime.freeMemory() * 1.0 /1024L /1024L) + "M");
        CpuInfo[] infos = sigar.getCpuInfoList();
        System.out.println(infos[0].getVendor());
        System.out.println(infos[0].getModel());

    }
}
