package com.zyh.image.tools;

import java.util.Properties;

public class JvmInfo {

    public static String getJvmVersion()
    {
        Properties props = System.getProperties();
        return "JDK HotSpot(TM) " + props.getProperty("java.version");
    }

    public static double getJvmTotalMemory()
    {
        Runtime runtime = Runtime.getRuntime();
        return Double.parseDouble(String.format("%.2f", runtime.totalMemory() * 1.0 /1024L /1024L));
    }
}
