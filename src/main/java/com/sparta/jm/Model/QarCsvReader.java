package com.sparta.jm.Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import com.sparta.jm.Controller.DAO;
import com.sparta.jm.Controller.QarDao;

public class QarCsvReader {

    int index = 0;
    String line;

    public List<String> csvReadHeader(String pathToCSV) {
        List<String> nameList = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(pathToCSV);
            LineNumberReader lineReader = new LineNumberReader(fileReader);
            // lineReader.setLineNumber(3);
            while ((line = lineReader.readLine()) != null) {
                if (index == 1) {
                    String[] headerStr = line.split(",");
                    for (int i = 1; i < headerStr.length; i++) {
                        if (nameList.contains(headerStr[i]) || headerStr[i] == "") {
                            continue;
                        } else {
                            nameList.add(headerStr[i]);
                        }
                    }
                    break;
                }
                index++;
            }

            lineReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameList;
    }

    public int csvReaderTotalLineNum(String pathToCSV) {
        int totalNum = 0;
        try {
            FileReader fileReader = new FileReader(pathToCSV);
            LineNumberReader lineReader = new LineNumberReader(fileReader);
            String s = lineReader.readLine();
            while (s != null) {
                totalNum++;
                s = lineReader.readLine();
            }
            lineReader.close();
            fileReader.close();
            System.out.println("Total Line Num: " + totalNum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalNum;
    }

    public void creatTable(List<String> headList) {
        QarDao qarDao = new QarDao();
        qarDao.createQARTable(headList);
    }

}
