package com.twap.cod.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Txt文本操作接口
 */
public interface ITxtDao {
    void createTxt(String path,String str) throws IOException;
}
