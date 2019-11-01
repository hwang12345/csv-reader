package com.sparta.jm.Main;
import com.sparta.jm.Model.EmployeeManager;

public class Starter
{
    public static void main(String[] args){
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.readEmployeeCSV();
    }
}
