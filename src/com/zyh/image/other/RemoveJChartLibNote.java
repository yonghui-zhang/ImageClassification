package com.zyh.image.other;

import com.bitagentur.renderer.JChartLibRender;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Field;

public class RemoveJChartLibNote {

    public static void main(String[] args) throws NoSuchFieldException {
        Class noteClass = JChartLibRender.class;
        Field field = noteClass.getDeclaredField("note");
        field.setAccessible(true);
      //  System.out.println(field.get(noteC));
    }
}
