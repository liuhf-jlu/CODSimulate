package com.twap.cod.dao.impl;

import com.twap.cod.dao.ICalculateDao;
import com.twap.cod.domain.CODInput;
import com.twap.cod.domain.CODOutput;

public class CalculateImpl implements ICalculateDao {
    CODInput codInput;
    CODOutput codOutput;

    /**
     * 给COD模型传入实测数据，实测数据已封装在CODInput实体类中
     * @param codInput
     */
    public CalculateImpl(CODInput codInput){
        this.codInput=codInput;
    }

    /**
     * 计算C(x)
     * 公式：C(x)=C0*exp[-(0.05+0.68*u)*x/u]
     * @return
     */
    @Override
    public double C() {
        double cx;
        cx=codInput.getC0()*Math.exp((-1*(0.05+0.68*codInput.getU())*codInput.getX())/codInput.getU());
        return cx;
    }

    /**
     * 计算L实测非点源
     * 公式：L实测非点源=(C2*Q2*m)-(C1*Q1*m/36.5)*exp{[-(0.05+0.68*u)*140000]/u*86400}
     * @return
     */
    @Override
    public double L_scfdy() {
        double l_fx;
        double P=-1*(0.05+0.68*codInput.getU());
        double p_NH=-1*(0.061+0.551*codInput.getU());   //计算氨氮
        //l_fx=86.4*codInput.getM()*(codInput.getC2()*codInput.getQ2()-C()*codInput.getQ0())-(codInput.getM()*codInput.getQ1()*codInput.getC1()*Math.exp(P*codInput.getX()/86400*codInput.getU()))/36.5;
        l_fx=(codInput.getC2()*codInput.getQ2()*codInput.getM()*86.4) - (codInput.getC1()*codInput.getQ1()*codInput.getM()/36.5 * (Math.exp((P*codInput.getX())/(codInput.getU()*86400))));
        return l_fx;
    }

    /**
     * 计算L生成
     * 公式：L生成=Σ(Ei*Ai/100)
     * @return
     */
    @Override
    public double L_sc() {
        double l_cs;
        l_cs=(codInput.getA1()/100*codInput.getE1())+(codInput.getA2()/100*codInput.getE2())+(codInput.getA3()/100*codInput.getE3())+(codInput.getA4()/100*codInput.getE4())+(codInput.getA5()/100*codInput.getE5())+(codInput.getA6()/100*codInput.getE6());
        return l_cs;
    }

    /**
     * 计算模型的c参数
     * 公式：c=(L产生/L实测非点源)-1
     * @return
     */
    @Override
    public double c() {
        double c;
        c=L_sc()/L_scfdy()-1;
        return c;
    }

    /**
     * 计算模型的预测λ参数
     * 公式：λ=1/(1+A*q^B)，其中A,B要用过拟合得到
     * @return
     */
    @Override
    public double lambda(double A,double B) {
        double lambda;
        lambda=1/(1+(A*Math.pow(codInput.getQ(),B)));
        return lambda;
    }

    /**
     * 计算L模拟值
     * 公式：L模拟值=λ*L产生
     * @return
     */
    @Override
    public double L_simulate(double A,double B) {
        double l_simulation;
        l_simulation=lambda(A,B)*L_sc();
        return l_simulation;
    }


}
