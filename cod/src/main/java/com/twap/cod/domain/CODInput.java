package com.twap.cod.domain;

/**
 * 实测数据
 */
public class CODInput {
    private double C2;  //监测断面污染物浓度 mg/l
    private double Q2;  //监测断面流量 m3/s
    private double C0;  //上游监测断面浓度 mg/l
    private double Q0;  //上游监测断面流量 m3/s
    private double u;   //流速 m/s
    private double q;   //径流模数 10-3m3/(s km2)
    private double Q1;  //污水厂污水处理量 wt/年
    private double C1;  //污水厂出口污染物浓度 mg/l
    private int m;      //当月天数
    private double A1;  //农用地 AGRL
    private double A2;  //园地 ORCD
    private double A3;  //林地 FRST
    private double A4;  //草地 PAST
    private double A5;  //农村用地 URLD
    private double A6;  //其他建设用地 UIDU
    private double x;   //河长 m

    private static final double E1 = 150.0;
    private static final double E2 = 150.0;
    private static final double E3 = 41.67;
    private static final double E4 = 36.67;
    private static final double E5 = 120.83;
    private static final double E6 = 120.83;


    public static double getE1() {
        return E1;
    }

    public static double getE2() {
        return E2;
    }

    public static double getE3() {
        return E3;
    }

    public static double getE4() {
        return E4;
    }

    public static double getE5() {
        return E5;
    }

    public static double getE6() {
        return E6;
    }

    public double getC2() {
        return C2;
    }

    public void setC2(double c2) {
        C2 = c2;
    }

    public double getQ2() {
        return Q2;
    }

    public void setQ2(double q2) {
        Q2 = q2;
    }

    public double getC0() {
        return C0;
    }

    public void setC0(double c0) {
        C0 = c0;
    }

    public double getQ0() {
        return Q0;
    }

    public void setQ0(double q0) {
        Q0 = q0;
    }

    public double getU() {
        return u;
    }

    public void setU(double u) {
        this.u = u;
    }

    public double getQ() {
        return q;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public double getQ1() {
        return Q1;
    }

    public void setQ1(double q1) {
        Q1 = q1;
    }

    public double getC1() {
        return C1;
    }

    public void setC1(double c1) {
        C1 = c1;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public double getA1() {
        return A1;
    }

    public void setA1(double a1) {
        A1 = a1;
    }

    public double getA2() {
        return A2;
    }

    public void setA2(double a2) {
        A2 = a2;
    }

    public double getA3() {
        return A3;
    }

    public void setA3(double a3) {
        A3 = a3;
    }

    public double getA4() {
        return A4;
    }

    public void setA4(double a4) {
        A4 = a4;
    }

    public double getA5() {
        return A5;
    }

    public void setA5(double a5) {
        A5 = a5;
    }

    public double getA6() {
        return A6;
    }

    public void setA6(double a6) {
        A6 = a6;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "CODParameter{" +
                "C2=" + C2 +
                ", Q2=" + Q2 +
                ", C0=" + C0 +
                ", Q0=" + Q0 +
                ", u=" + u +
                ", q=" + q +
                ", Q1=" + Q1 +
                ", C1=" + C1 +
                ", m=" + m +
                ", A1=" + A1 +
                ", A2=" + A2 +
                ", A3=" + A3 +
                ", A4=" + A4 +
                ", A5=" + A5 +
                ", A6=" + A6 +
                ", x=" + x +
                '}';
    }
}
