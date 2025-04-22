package com.pluralsight;
import java.io.*;
import java.util.regex.Pattern;

public class PayrollCalculator {
    public static void main(String[] args) {
try{
    FileReader fileReader = new FileReader("src/main/resources/DataFiles/employees.csv");
    BufferedReader bufReader = new BufferedReader(fileReader);
    String input;

    while ((input = bufReader.readLine())!= null){
        String[] tokens = input.split(Pattern.quote("|"));

        if (tokens[0].equalsIgnoreCase("id")){
            continue;
        }

        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        double hoursWorked = Double.parseDouble(tokens[2]);
        double payRate = Double.parseDouble(tokens[3]);

        Employee employee = new Employee( id , name , hoursWorked, payRate);

        System.out.printf("%d %s %.2f \n", employee.employeeId(), employee.name(), employee.getGrossPay());

    } bufReader.close();
}catch (IOException e) {
    e.printStackTrace();
}
    }
}
