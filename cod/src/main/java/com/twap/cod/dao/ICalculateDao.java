package com.twap.cod.dao;

/**
 * COD计算接口
 */
public interface ICalculateDao {
    /**
     *
     * @return
     */
    double C();

    /**
     *
     * @return
     */
    double L_scfdy();

    /**
     *
     * @return
     */
    double L_sc();

    /**
     *
     * @return
     */
    double c();

    /**
     *
     * @return
     */
    double lambda(double A,double B);

    /**
     *
     * @return
     */
    double L_simulate(double A,double B);
}
