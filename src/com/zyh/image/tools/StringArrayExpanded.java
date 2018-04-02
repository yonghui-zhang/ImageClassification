package com.zyh.image.tools;

public class StringArrayExpanded {

    public String[] strs = new String[100];
    public int flag = 0;

    /**
     * 容量检测
     */
    public boolean isExpanded()
    {
        if(flag < strs.length)
        {
            return false;
        }else {
            doExpanded();
            return true;
        }
    }

    /**
     * 扩容操作
     */
    private void doExpanded()
    {
        String[] newstrs = new String[strs.length+100];//扩容100个大小

        System.arraycopy(strs, 0, newstrs, 0, strs.length);
        flag = strs.length;
        strs = newstrs;
    }
}
