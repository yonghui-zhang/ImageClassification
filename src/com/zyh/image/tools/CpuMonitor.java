package com.zyh.image.tools;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.text.DecimalFormat;

public class CpuMonitor {

    public static int getCurrentCpuUsedRate() throws SigarException {
 //       Sigar sigar = ComputerMonitor.getInstance();
        Sigar sigar = new Sigar();
        CpuPerc[] cpuPercs = sigar.getCpuPercList();

        int cpus = cpuPercs.length;
        double cpuUsedSum = 0;
        for (CpuPerc cpuPerc : cpuPercs)
        {
            cpuUsedSum += Double.parseDouble(String.format("%.2f",cpuPerc.getCombined() * 100.0D));
        }
       return (int)Math.round(cpuUsedSum / cpus);
    }
}
