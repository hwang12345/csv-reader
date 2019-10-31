package com.sparta.jm.Model;

public class EmployeeManager {

    public void readEmployeeCSV(){
        CSVReader csvReader = new CSVReader();
        csvReader.csvReader("resources/EmployeeRecords.csv");

        csvReader.passToDAO();
    }
}
