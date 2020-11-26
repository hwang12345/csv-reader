package com.sparta.jm.Main;
import com.sparta.jm.Controller.EmployeeManager;
import com.sparta.jm.Controller.QarManager;

public class Starter
{
    public static void main(String[] args){
        // EmployeeManager employeeManager = new EmployeeManager();
        // employeeManager.readEmployeeCSV();
        QarManager qarManager = new QarManager();
        // qarManager.getCsvTotalNum();
        qarManager.createTable();
    }
}
