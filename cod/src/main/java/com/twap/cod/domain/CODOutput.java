package com.twap.cod.domain;

/**
 * 计算值
 */
public class CODOutput {
    private double l_sc;    //生成
    private double l_scfdy;     //实测非点源
    private double c;   // c

    public void setL_sc(double l_sc) {
        this.l_sc = l_sc;
    }

    public void setL_scfdy(double l_scfdy) {
        this.l_scfdy = l_scfdy;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getL_sc() {
        return l_sc;
    }

    public double getL_scfdy() {
        return l_scfdy;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "CODOutput{" +
                "l_sc=" + l_sc +
                ", l_scfdy=" + l_scfdy +
                ", c=" + c +
                '}';
    }
}
