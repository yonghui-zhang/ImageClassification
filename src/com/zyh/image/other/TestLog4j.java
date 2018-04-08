package com.zyh.image.other;


import org.apache.log4j.Logger;

public class TestLog4j {

    private static Logger logger = Logger.getLogger(TestLog4j.class);

    public static void main(String[] args)
    {
        logger.info("使用log4j打印");
    }
}
