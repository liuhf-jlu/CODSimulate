package com.twap.cod.domain;

/**
 * 模拟类是计算值类的子类
 */
public class CODSimulation extends CODOutput{
    CODInput codInput;  //模拟类本身的数据
    private double lambda;      //通过A,B推导的参数
    private double l_simulate;   //最终模拟数值

    public CODInput getCodInput() {
        return codInput;
    }

    public void setCodInput(CODInput codInput) {
        this.codInput = codInput;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public double getL_simulate() {
        return l_simulate;
    }

    public void setL_simulate(double l_simulate) {
        this.l_simulate = l_simulate;
    }

    @Override
    public String toString() {
        return "CODSimulation{" +
                "codInput=" + codInput +
                ", lambda=" + lambda +
                ", l_simulate=" + l_simulate +
                '}';
    }
}
