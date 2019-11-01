package com.sparta.jm.Controller;

import com.sparta.jm.Model.Employee;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class DAO {
    private final String QUERY = "INSERT INTO Employees(emp_id, name_prefix, first_name, middle_initial, last_name, gender, email, date_of_birth, date_of_joining, salary) values (?,?,?,?,?,?,?,?,?,?)";
    private final String URL = "jdbc:mysql://localhost/Employees?user=root&password=jamesmac";

    public void runInsertQuery(HashMap<Integer,Employee> employeeList){
        try(Connection connection = getConnection(URL))
        {
            for(Employee employee : employeeList.values()){
                PreparedStatement statement = connection.prepareStatement(QUERY);
                statement.setInt(1,employee.getEmployeeID());
                statement.setString(2,employee.getNamePrefix());
                statement.setString(3,employee.getFirstName());
                statement.setString(4,employee.getMiddleInitial());
                statement.setString(5,employee.getSurname());
                statement.setString(6,employee.getGender());
                statement.setString(7,employee.getEmail());
                statement.setDate(8,java.sql.Date.valueOf(employee.getDateOfBirth()));
                statement.setDate(9,java.sql.Date.valueOf(employee.getDateOfJoining()));
                statement.setInt(10,employee.getSalary());

                statement.executeUpdate();
            }
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

