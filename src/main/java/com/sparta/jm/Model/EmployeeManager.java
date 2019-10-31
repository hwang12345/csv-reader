package com.sparta.jm.Model;

public class EmployeeManager {

    public void readEmployeeCSV(){
        CSVReader csvReader = new CSVReader();
        csvReader.csgivReader("resources/EmployeeRecords.csv");

        csvReader.passToDAO();
    }
}
