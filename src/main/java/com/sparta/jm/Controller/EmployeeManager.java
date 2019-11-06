package com.sparta.jm.Controller;

import com.sparta.jm.Model.CSVReader;

public class EmployeeManager {

    public void readEmployeeCSV(){
        CSVReader csvReader = new CSVReader();
        csvReader.csvReader("resources/EmployeeRecords.csv");

        csvReader.passToDAO();
    }
}
