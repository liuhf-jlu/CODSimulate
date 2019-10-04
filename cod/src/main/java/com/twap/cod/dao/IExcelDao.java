package com.twap.cod.dao;

import com.twap.cod.domain.CODInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Excel文件操作接口
 */
public interface IExcelDao {

    /**
     * 读取excel
     * @param file
     * @return
     */
    List readExcel(File file);

    /**
     *
     * @return
     */
    List<CODInput> getCODInputList();

}
