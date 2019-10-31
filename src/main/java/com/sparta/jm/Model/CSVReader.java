package com.sparta.jm.Model;

import com.sparta.jm.Controller.DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    List<Employee> csvArray = new ArrayList<>();

    DAO dao = new DAO();

    public List<Employee> csvReader(String pathToCSV) {
        String lineToRead = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToCSV))) {
            lineToRead = bufferedReader.readLine();
            while ((lineToRead = bufferedReader.readLine()) != null) {
                String[] elements = lineToRead.split(",");

                Employee employee = new Employee(
                        Integer.parseInt(elements[0]),
                        elements[1], elements[2], elements[3], elements[4],
                        elements[5],
                        elements[6],
                        dateFormatter(elements[7]),
                        dateFormatter(elements[8]),
                        Integer.parseInt(elements[9]));
                csvArray.add(employee);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvArray;
    }

    public LocalDate dateFormatter(String date){
        DateTimeFormatter source = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate localDate = LocalDate.parse(date, source);

        String result = DateTimeFormatter.ofPattern("M/d/yyyy").format(localDate);
//        result = result.replaceAll("[^0-9]", "");
//
//        LocalDate localDateResult = LocalDate.parse(result,source);

        return localDate;
    }

    public void passToDAO(){
        dao.runInsertQuery(csvArray);
    }

}


