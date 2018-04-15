package com.zyh.image.gui;

import java.util.HashMap;

/**
 * 自定义的Java Swing 控件池
 * 为了方便组件跨面板互相访问
 */
public class WidgetPool {

    private static WidgetPool widgetPool = new WidgetPool();

    private HashMap<String, Object> pool;

    private WidgetPool()
    {
        pool = new HashMap<>();
    }

    public static WidgetPool getInstance()
    {
        return widgetPool;
    }

    /**
     * 添加组件进池子
     */
    public void addWidget(String key, Object value)
    {
        pool.put(key, value);
    }
    /**
     * 把组件移除池子
     */
    public void removeWidget(String key)
    {
        pool.remove(key);
    }
    /**
     * 按照key查询组件
     */
    public Object getWidget(String key)
    {
        return pool.get(key);
    }
}
