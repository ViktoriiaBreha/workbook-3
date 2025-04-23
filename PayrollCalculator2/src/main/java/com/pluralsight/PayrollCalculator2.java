package com.pluralsight;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import java.util.regex.Pattern;

public class PayrollCalculator2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the name of the file employee file to process: ");
            String file_name = scanner.nextLine();
            System.out.print("Enter the name of the payroll file to create: ");
            String name_payroll_file = scanner.nextLine();

            FileReader fileReader = new FileReader("src/main/resources/DataFiles/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("src/main/resources/DataFiles" + name_payroll_file, true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            boolean json = name_payroll_file.toLowerCase().endsWith(".json");

            if (json) {
                bufWriter.write("[\n");
                bufWriter.newLine();
            } else {
                bufWriter.write("id|name|gross pay");
                bufWriter.newLine();
            }
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = input.split(Pattern.quote("|"));

                if (tokens[0].equalsIgnoreCase("id")) {
                    continue;
                }

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                if (json) {
                    bufWriter.write(String.format("{ \"id\": %d, \"name\" : \"%s\", \"grossPay\" : %.2f }\"", id,
                            name, employee.getGrossPay()));
                    bufWriter.newLine();
                } else {
                    bufWriter.write(id + " " + name + " " + " " + String.format("%.2f", employee.getGrossPay()));
                    bufWriter.newLine();
                }

            }
            bufWriter.write("\n]");
            bufWriter.newLine();
            bufReader.close();
            bufWriter.close();

        } catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.printStackTrace();
        }
    }
}
    /*Continue working on the PayrollCalculator program.
Rather than displaying your payroll report to the screen, write it to a .csv file in
the following format.
id|name|gross pay
111|Cameron Tay|3277.65
222|James Tee|2150.00
Prompt the user for the name of a file to read and process, then prompt them for
the name of the payroll file to create.
Enter the name of the file employee file to process: employees.csv
Enter the name of the payroll file to create: payroll-sept-2023.csv
When your program finishes running, open the new file in Notepad to view the
results.
BONUS: If the user chooses specifies a .json extension write the data as JSON
instead of csv.
For example:
Enter the name of the file employee file to process: employees.csv
Enter the name of the payroll file to create: payroll-sept-2023.json
payroll-sept-2023.json
[
{ "id": 111, "name" : "Cameron Tay", "grossPay" : 3277.65 },
{ "id": 222, "name" : "James Tee", "grossPay" : 2150.00 }
]
Commit and push your code!
*/

