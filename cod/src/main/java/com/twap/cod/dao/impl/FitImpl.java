package com.twap.cod.dao.impl;

import com.twap.cod.dao.IFitdao;
import com.twap.cod.domain.Point;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

import java.util.List;

public class FitImpl implements IFitdao {

    /**
     * 幂函数拟合
     * f(x)=A*x^B 两边取对数得ln(f(x))=B*ln(x)+ln(A)，降为一阶后在进行拟合
     * @param points_
     * @return A=result[0]，B=result[1]
     */;
     @Override
    public double[] fitPowFunction(List<Point> points_){
        WeightedObservedPoints points=new WeightedObservedPoints();
        for(Point point :points_){
            double X=Math.log(point.getX());
            double Y=Math.log(point.getY());
            points.add(X,Y);
        }
        PolynomialCurveFitter fitter=PolynomialCurveFitter.create(1);
        double[] result=fitter.fit(points.toList());
        return result;
    }
}
