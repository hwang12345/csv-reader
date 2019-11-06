package com.sparta.jm.Controller;

import com.sparta.jm.Model.Employee;

import java.sql.*;
import java.util.HashMap;

public class DAO {

    private final String QUERY = "INSERT INTO Employees(emp_id, name_prefix, first_name, middle_initial, last_name, gender, email, date_of_birth, date_of_joining, salary) values (?,?,?,?,?,?,?,?,?,?)";
    private final String URL = "jdbc:mysql://localhost/Employees?user=root&password=jamesmac";

    private HashMap<Integer, Employee> employeeHashMap;
    private Employee[] employeeArray;
    private Thread[] threadArray;
    private volatile int index = 0; //index of a single thread
    private int threadArraySize = 140;

    public DAO(HashMap<Integer, Employee> parsedEmployeeMap) {
        this.employeeHashMap = parsedEmployeeMap;
        employeeArray = employeeHashMap.values().toArray(new Employee[employeeHashMap.size()]);
        threadArray = new Thread[threadArraySize];
    }

    Runnable daoRunnable = () -> {
        runInsertQuery(employeeArray);
    };

    public void createThreads() {
        for (int i = 0; i < threadArraySize; i++) {
            Thread thread = new Thread(daoRunnable);
            thread.start();
            threadArray[i] = thread;
        }

        for(Thread t: threadArray){ //wait
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void runInsertQuery(Employee[] employeeArray) {
        int localIndex = 0;

        try{
            synchronized (this) { //inital value
                localIndex = index;
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL)) {
        while (localIndex < employeeArray.length) {
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setInt(1, employeeArray[localIndex].getEmployeeID());
            statement.setString(2, employeeArray[localIndex].getNamePrefix());
            statement.setString(3, employeeArray[localIndex].getFirstName());
            statement.setString(4, employeeArray[localIndex].getMiddleInitial());
            statement.setString(5, employeeArray[localIndex].getSurname());
            statement.setString(6, employeeArray[localIndex].getGender());
            statement.setString(7, employeeArray[localIndex].getEmail());
            statement.setDate(8, java.sql.Date.valueOf(employeeArray[localIndex].getDateOfBirth()));
            statement.setDate(9, java.sql.Date.valueOf(employeeArray[localIndex].getDateOfJoining()));
            statement.setInt(10, employeeArray[localIndex].getSalary());

            statement.executeUpdate();

            synchronized (this) {
                localIndex = index;
                index++;
             }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

