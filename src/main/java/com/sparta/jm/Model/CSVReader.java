package com.sparta.jm.Model;

import com.sparta.jm.Controller.DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class CSVReader {

    HashMap<Integer,Employee> employeeHashMap = new HashMap<>();

    public void csvReader(String pathToCSV) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToCSV))){
            bufferedReader.lines() //read lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .forEach(fields -> createEmployeeObject(fields));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createEmployeeObject(String[] fields){
        Employee employee = new Employee(
                Integer.parseInt(fields[0]),
                fields[1], fields[2], fields[3], fields[4],
                fields[5],
                fields[6],
                dateFormatter(fields[7]),
                dateFormatter(fields[8]),
                Integer.parseInt(fields[9]));

        employeeHashMap.put(Integer.parseInt(fields[0]),employee);
    }

    public LocalDate dateFormatter(String date){
        DateTimeFormatter source = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate localDate = LocalDate.parse(date, source);

//        String result = DateTimeFormatter.ofPattern("M/d/yyyy").format(localDate);
//        result = result.replaceAll("[^0-9]", "");
//
//        LocalDate localDateResult = LocalDate.parse(result,source);

        return localDate;
    }

    public void passToDAO(){
        DAO dao = new DAO();
        dao.runInsertQuery(employeeHashMap);
    }

}

//    HashMap<Integer,Employee> csvArray = new ArrayList<>();
//    public List<Employee> csvReader(String pathToCSV) {
//        String lineToRead = "";
//
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToCSV))) {
//            lineToRead = bufferedReader.readLine();
//            while ((lineToRead = bufferedReader.readLine()) != null) {
//                String[] elements = lineToRead.split(",");
//
//                Employee employee = new Employee(
//                        Integer.parseInt(elements[0]),
//                        elements[1], elements[2], elements[3], elements[4],
//                        elements[5],
//                        elements[6],
//                        dateFormatter(elements[7]),
//                        dateFormatter(elements[8]),
//                        Integer.parseInt(elements[9]));
//                csvArray.add(employee);
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return csvArray;
//    }


//                Runnable run = () -> System.out.println ("Thread " + Thread.currentThread().getId() + " is running");
//                Thread thread = new Thread(run);
//                thread.start();