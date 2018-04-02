package com.zyh.image.bpnn;

import com.zyh.image.tools.CommonTools;
import sun.plugin.com.event.COMEventHandler;

/*
  Bp的网络参数监控
 */
public class BpMonitor {

    private Bp bpMonitor = null;
    public BpMonitor(Bp bp)
    {
        bpMonitor = bp;
    }

    private void print_hide1_x()
    {
        System.out.print("hide1_x = ");
        CommonTools.printArray(bpMonitor.hide1_x);
    }

    private void print_hide1_w()
    {
        System.out.print("hide1_w = ");
        CommonTools.printMatrix(bpMonitor.hide1_w);
    }

    private void print_hide1_errors()
    {
        System.out.print("hide1_errors = ");
        CommonTools.printArray(bpMonitor.hide1_errors);
    }

    private void print_out_x()
    {
        System.out.print("out_x = ");
        CommonTools.printArray(bpMonitor.out_x);
    }

    private void print_out_w()
    {
        System.out.print("out_w = ");
        CommonTools.printMatrix(bpMonitor.out_w);
    }

    private void print_out_errors()
    {
        System.out.print("out_errors = ");
        CommonTools.printArray(bpMonitor.out_errors);
    }
    private void print_target()
    {
        System.out.print("target = ");
        CommonTools.printArray(bpMonitor.target);
    }

    public void showAllParameter()
    {
        print_hide1_x();
        print_hide1_w();
        print_hide1_errors();
        print_out_x();
        print_out_w();
        print_out_errors();
        print_target();
    }
}
