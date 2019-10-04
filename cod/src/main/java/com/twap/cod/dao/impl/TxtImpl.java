package com.twap.cod.dao.impl;

import com.twap.cod.dao.ITxtDao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TxtImpl implements ITxtDao {

    @Override
    public void createTxt(String path,String content) throws IOException {
        File report=new File(path);
        FileOutputStream out=new FileOutputStream(report);
        out.write(content.getBytes());
        out.close();
    }
}
