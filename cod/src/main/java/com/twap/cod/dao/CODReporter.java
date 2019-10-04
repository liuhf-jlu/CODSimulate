package com.twap.cod.dao;

import com.twap.cod.dao.impl.TxtImpl;
import com.twap.cod.domain.CODInput;
import com.twap.cod.domain.CODOutput;
import com.twap.cod.domain.CODSimulation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用于成程COD水质模拟报告
 */
public class CODReporter {
    List<CODInput> codInputs;   //实际对象实测值
    List<CODOutput> codOutputs;     //实际对象计算值
    CODSimulation codSimulation;    //模拟对象
    double A;   //拟合A
    double B;   //拟合B

    public List<CODInput> getCodInputs() {
        return codInputs;
    }

    public void setCodInputs(List<CODInput> codInputs) {
        this.codInputs = codInputs;
    }

    public List<CODOutput> getCodOutputs() {
        return codOutputs;
    }

    public void setCodOutputs(List<CODOutput> codOutputs) {
        this.codOutputs = codOutputs;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public CODSimulation getCodSimulation() {
        return codSimulation;
    }

    public void setCodSimulation(CODSimulation codSimulation) {
        this.codSimulation = codSimulation;
    }

    @Override
    public String toString() {
        return "CODReporter{" +
                "codInputs=" + codInputs +
                ", codOutputs=" + codOutputs +
                ", codSimulation=" + codSimulation +
                ", A=" + A +
                ", B=" + B +
                '}';
    }

    public void createReport() throws IOException {
        Date date=new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String str="";
        str+="COD模拟报告 日期："+ft.format(date)+"\r\n";
        str+="※实测值\r\n";
        for(CODInput codInput :codInputs){
           str+=codInput.toString()+"\r\n";
        }
        str+="-------------------------------------------------------\r\n";
        str+="※计算值\r\n";
        for(CODOutput codOutput :codOutputs){
            str+=codOutput.toString()+"\r\n";
        }
        str+="-------------------------------------------------------\r\n";
        str+="※模拟值\r\n";
        str+="拟合参数 A:"+A+"，B:"+B+"\r\n";
        str+="模拟对象 λ："+codSimulation.getLambda()+"\r\n";
        str+="模拟对象 L生成："+codSimulation.getL_sc()+"\r\n";
        str+="模拟对象 L模拟值："+codSimulation.getL_simulate()+"\r\n";
        System.out.println(str);

        String reportName="COD_report_"+ft.format(date)+".txt";
        String path="运行报告/"+reportName;
        ITxtDao iTxtDao=new  TxtImpl();
        iTxtDao.createTxt(path,str);
    }
}
