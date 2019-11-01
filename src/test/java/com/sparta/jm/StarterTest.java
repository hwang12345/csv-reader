package com.sparta.jm;

import com.sparta.jm.Model.CSVReader;
import com.sparta.jm.Model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Unit test for simple Starter.
 */
public class StarterTest {
    @Before
    public void setup() {

    }

    @Test
    public void testIsConnected() {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Employees?user=root&password=jamesmac"))
        {
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
