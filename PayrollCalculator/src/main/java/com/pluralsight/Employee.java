package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

public Employee (int employeeId, String name, double hoursWorked, double payRate){
    this.employeeId = employeeId;
    this.name = name;
    this.hoursWorked = hoursWorked;
    this.payRate = payRate;
}

    public int employeeId() {
        return employeeId;
    }


    public String name() {
        return name;
    }


    public double hoursWorked() {
        return hoursWorked;
    }


    public double payRate() {
        return payRate;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public  double getGrossPay() {
    return hoursWorked * payRate;
}
}
