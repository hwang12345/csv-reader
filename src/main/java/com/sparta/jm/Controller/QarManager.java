package com.sparta.jm.Controller;

import java.util.ArrayList;
import com.sparta.jm.Model.QarCsvReader;
import com.sparta.jm.Controller.DAO;
import java.util.List;

public class QarManager {

    public void getCsvTotalNum() {
        QarCsvReader csvReader = new QarCsvReader();
        String filePath = "resources/QAR_TEST.csv";
        int num = csvReader.csvReaderTotalLineNum(filePath);
        System.out.println("Total Num:" + num);
    }

    public void createTable() {
        QarCsvReader csvReader = new QarCsvReader();
        String filePath = "resources/QAR_TEST.csv";
        List<String> headList = new ArrayList<String>();
        headList = csvReader.csvReadHeader(filePath);
        // System.out.println("Head Size:" + headList.size());
        csvReader.creatTable(headList);
    }
}
