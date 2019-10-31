package com.sparta.jm.Model;

import java.time.LocalDate;

// Employeegit

public class Employee {
    private int employeeID;
    private String namePrefix;
    private String firstName;
    private String surname;
    private String middleInitial;
    private String gender;
    private String email;
    private final LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private int salary;

    public Employee(int employeeID, String namePrefix, String firstName, String middleInitial,String surname ,String gender, String email, LocalDate dateOfBirth, LocalDate dateOfJoining, int salary) {
        this.employeeID = employeeID;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.surname = surname;
        this.middleInitial = middleInitial;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "employeeID=" + employeeID +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", salary=" + salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

//read the csv
//put into arrays list
