package com.twap.cod;

import com.twap.cod.dao.*;
import com.twap.cod.dao.impl.CSVImpl;
import com.twap.cod.dao.impl.CalculateImpl;
import com.twap.cod.dao.impl.ExcelImpl;
import com.twap.cod.dao.impl.FitImpl;
import com.twap.cod.domain.CODInput;
import com.twap.cod.domain.CODOutput;
import com.twap.cod.domain.CODSimulation;
import com.twap.cod.domain.Point;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {
        List<CODInput> codInputs=new ArrayList<CODInput>();  //实测值集合
        List<CODOutput> codOutputs=new ArrayList<CODOutput>();  //计算值集合
        List<Point> points=new ArrayList<Point>();  //qc坐标
        ICalculateDao iCalculateDao=null; //COD计算接口

        /*
        读取excel表格获得实测值集合
         */
        IExcelDao iExcelDao=new ExcelImpl();
        codInputs=iExcelDao.getCODInputList();

        /*
        有了实测值之后利用公式得到计算值，并将计算值存储到集合
         */
        for(CODInput codInput :codInputs){
            CODOutput codOutput=new CODOutput();
            iCalculateDao=new CalculateImpl(codInput);

            codOutput.setL_sc(iCalculateDao.L_sc());    //计算L生成
            codOutput.setL_scfdy(iCalculateDao.L_scfdy());  //计算L实测非点源
            codOutput.setC(iCalculateDao.c());  //计算c
            codOutputs.add(codOutput);
        }

        /*
        将q,c存入Points集合
         */
        for(int i=0;i<codInputs.size();i++){
            CODInput codInput=codInputs.get(i);
            CODOutput codOutput=codOutputs.get(i);
            Point point=new Point(codInput.getQ(),codOutput.getC());
            points.add(point);
        }
        ICSVDao icsvDao=new CSVImpl();
        icsvDao.exportCSV(points);

        /*
        拟合得到A,B
         */
        IFitdao iFitdao=new FitImpl();
        double[] result=iFitdao.fitPowFunction(points);
        double A=result[0];
        double B=result[1];

        /*
        建立模拟对象，求L模拟值
         */
        CODSimulation simulation=new CODSimulation();   //创建模拟对象
        CODInput cod_simulation_in=new CODInput();  //模拟对象输入参数
        cod_simulation_in.setA1(53991.7336);
        cod_simulation_in.setA2(0.00);
        cod_simulation_in.setA3(237446.011);
        cod_simulation_in.setA4(1144.1639);
        cod_simulation_in.setA5(1300.1862);
        cod_simulation_in.setA6(100.0143);
        cod_simulation_in.setQ(0.23);

        simulation.setCodInput(cod_simulation_in); //给定模拟对象输入对象
        simulation.setL_sc(iCalculateDao.L_sc());   //计算模拟对象的L生成
        simulation.setLambda(iCalculateDao.lambda(A,B));    //计算模拟对象的λ
        simulation.setL_simulate(iCalculateDao.L_simulate(A,B));    //计算模拟对象的模拟值

        /*
        生成COD模拟报告
         */
        CODReporter reporter=new CODReporter();
        reporter.setCodInputs(codInputs);
        reporter.setCodOutputs(codOutputs);
        reporter.setA(A);
        reporter.setB(B);
        reporter.setCodSimulation(simulation);
        reporter.createReport();    //输出模拟报告

    }
}
