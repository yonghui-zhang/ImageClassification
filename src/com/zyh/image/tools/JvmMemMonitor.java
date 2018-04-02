package com.zyh.image.tools;

public class JvmMemMonitor {

    public static double getJvmMemoryUsed()
    {
        Runtime runtime = Runtime.getRuntime();
        return Double.parseDouble(String.format("%.2f", (runtime.totalMemory() - runtime.freeMemory()) * 1.0 /1024L /1024L));
    }

    public static int getJvmMemoryUsedRate()
    {
        Runtime runtime = Runtime.getRuntime();
        double rate = (runtime.totalMemory() - runtime.freeMemory()) * 1.0 / runtime.totalMemory() * 100D;
        return (int)Math.round(rate);
    }
}
