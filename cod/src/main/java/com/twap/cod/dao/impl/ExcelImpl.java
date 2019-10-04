package com.twap.cod.dao.impl;

import com.twap.cod.dao.IExcelDao;
import com.twap.cod.domain.CODInput;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelImpl  implements IExcelDao {
    /**
     * 读取 *.xls格式的表格文件
     * @param file
     * @return List
     */
    @Override
    public List readExcel(File file) {
        try{
            //创建输入流，去读excel
            InputStream in=new FileInputStream(file);
            //jxl提供的Workbook类
            Workbook wb=Workbook.getWorkbook(in);
            //excel的页标签数量
            int sheet_size=wb.getNumberOfSheets();
            for(int index=0;index<sheet_size;index++){
                List<List> outerList=new ArrayList<List>();
                //为每个页签创建一个sheet对象
                Sheet sheet=wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                    }
                    outerList.add(i, innerList);
                }
                return outerList;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取excel表格，自动创建与excel对应的CODinput类的List集合
     * @return
     */
    @Override
    public List<CODInput> getCODInputList(){
        IExcelDao iExcelDao=new ExcelImpl();
        File excel_file=new File("excelData/2014-2015.xls");
        List excel_list=iExcelDao.readExcel(excel_file);
        List<CODInput> codInputList=new ArrayList<CODInput>();

        for (int i = 1; i < excel_list.size(); i++) {
            List list = (List) excel_list.get(i);
            CODInput codInput = new CODInput();
            codInput.setQ(0.410550947);
            codInput.setC0(0);
            codInput.setX(140000);
            codInput.setQ0(0);
            codInput.setA1(53991.7336);
            codInput.setA2(0.00);
            codInput.setA3(237446.011);
            codInput.setA4(1144.1639);
            codInput.setA5(1300.1862);
            codInput.setA6(100.0143);
            codInput.setC2(Double.parseDouble((String) list.get(0)));
            codInput.setQ2(Double.parseDouble((String) list.get(1)));
            codInput.setU(Double.parseDouble((String) list.get(2)));
            codInput.setQ(Double.parseDouble((String) list.get(3)));
            codInput.setC1(Double.parseDouble((String) list.get(4)));
            codInput.setQ1(Double.parseDouble((String) list.get(5)));
            codInput.setM(Integer.parseInt((String) list.get(6)));
            codInputList.add(codInput);
        }
        return codInputList;
    }

}
