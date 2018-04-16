package com.zyh.image.tools;

import org.hyperic.sigar.Sigar;

public class ComputerMonitor {

    private static Sigar sigar = new Sigar();

    public static Sigar getInstance()
    {
        return sigar;
    }
}
