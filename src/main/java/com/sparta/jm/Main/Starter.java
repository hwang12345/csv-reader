package com.sparta.jm.Main;
import com.sparta.jm.Controller.EmployeeManager;

public class Starter
{
    public static void main(String[] args){
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.readEmployeeCSV();
    }
}
