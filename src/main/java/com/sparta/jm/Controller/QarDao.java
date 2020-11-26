package com.sparta.jm.Controller;

import java.sql.*;
import java.util.List;

public class QarDao {
    private String createTableStr1 = "CREATE TABLE qar_table1 (" + "ID INT(64) NOT NULL AUTO_INCREMENT,";
    // private String createTableStr2 = "CREATE TABLE qar_table2 (" + "ID INT(64) NOT NULL AUTO_INCREMENT,";
    // private String createTableStr3 = "CREATE TABLE qar_table3 (" + "ID INT(64) NOT NULL AUTO_INCREMENT,";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String QAR_URL = "jdbc:mysql://localhost:3306/QAR?serverTimezone=UTC";
    public final String USER = "root";
    public final String PASSWD = "hwang  ";

    public void createQARTable(List<String> headList) {
        int index = 0;
        for (String head : headList) {
            createTableStr1 = createTableStr1 + head.replace("\"", "") + " " + "VARCHAR(20),";

            // if (index < 300) {
            //     createTableStr1 = createTableStr1 + head.replace("\"", "") + " " + "VARCHAR(20),";
            // } 
            // else if (index >=300 && index < 600) {
            //     createTableStr2 = createTableStr2 + head.replace("\"", "") + " " + "VARCHAR(20),";
            // }else{
            //     createTableStr3 = createTableStr3 + head.replace("\"", "") + " " + "VARCHAR(20),";
            // }
        }
        createTableStr1 = createTableStr1 + "PRIMARY KEY ( `ID` ))Engine=MyISAM DEFAULT CHARSET=utf8;";
        // createTableStr2 = createTableStr2 + "PRIMARY KEY ( `ID` ))Engine=MyISAM DEFAULT CHARSET=utf8;";
        // createTableStr3 = createTableStr3 + "PRIMARY KEY ( `ID` ))Engine=MyISAM DEFAULT CHARSET=utf8;";
        System.out.println("Create Table:"+createTableStr1);
        try {
            Class.forName(DRIVER);// 加载JDBC驱动程序
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("无法加载驱动程序：");
        }

        try {
            Connection connecter = DriverManager.getConnection(QAR_URL, USER, PASSWD);
            Statement statement = connecter.createStatement();
            statement.executeUpdate(createTableStr1);
            // statement.executeUpdate(createTableStr2);
            // statement.executeUpdate(createTableStr3);
            // System.out.println("Table Create Successed");
            statement.close();
            connecter.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
