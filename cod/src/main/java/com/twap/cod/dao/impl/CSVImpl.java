package com.twap.cod.dao.impl;

import com.csvreader.CsvWriter;
import com.twap.cod.dao.ICSVDao;
import com.twap.cod.domain.Point;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class CSVImpl implements ICSVDao {

    /**
     *将坐标点q,c以csv格式导入到csv_qc.csv文件
     */
    @Override
    public void exportCSV(List<Point> datas) throws IOException {
        File file=new File("src/main/csv/csv_qc.csv");
        CsvWriter csvWriter=new CsvWriter(file.getCanonicalPath(), ',', Charset.forName("UTF-8"));
        //写表头
        String[] headers={"q","c"};
        csvWriter.writeRecord(headers);
        for(Point data :datas){
            csvWriter.write(String.valueOf(data.getX()));
            csvWriter.write(String.valueOf(data.getY()));
            csvWriter.endRecord();
        }
        csvWriter.close();
    }



}
