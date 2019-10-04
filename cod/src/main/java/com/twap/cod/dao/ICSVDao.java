package com.twap.cod.dao;

import com.twap.cod.domain.Point;

import java.io.IOException;
import java.util.List;

/**
 * CSV文件操作接口
 */
public interface ICSVDao {

    /**
     * 将数据导出为csv格式文件
     */
    void exportCSV(List<Point> datas) throws IOException;


}
