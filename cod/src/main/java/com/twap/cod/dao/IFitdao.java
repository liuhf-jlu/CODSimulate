package com.twap.cod.dao;

import com.twap.cod.domain.Point;

import java.util.List;

/**
 * 数据拟合接口
 */
public interface IFitdao {
    double[] fitPowFunction(List<Point> points_);
}
