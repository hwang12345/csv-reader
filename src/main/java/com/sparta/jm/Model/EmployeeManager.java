package com.sparta.jm.Model;

import com.sparta.jm.Controller.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class EmployeeManager {

    public void readEmployeeCSV(){
        CSVReader csvReader = new CSVReader();
        csvReader.csvReader("resources/EmployeeRecords.csv");

        csvReader.passToDAO();
    }
}
