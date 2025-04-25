package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Products> items = getItems();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Welcome to our Online Store---");
        System.out.println("Choose option from the next menu: ");
        System.out.println("1.Display Products");
        System.out.println("2.Display Cart");
        System.out.println("3.Exit - closes out of the application");
        System.out.print("Enter your choice (1-3): ");
        String choice = scanner.nextLine();

        switch (choice){
            case "1":
                //display products
                viewAllItems(items);
                System.out.print("Continue to menu (Hit Enter): ");
                scanner.nextLine();
                break;

            case "2":
                // display cart
            case "3":
                System.out.println("Thank you for shopping with us!");
                System.exit(0); // if we use while loop put false condition right here
            default:
                System.out.println("invalid choice, try again!");
        } scanner.close();

    }
    public static ArrayList<Products>getItems(){
        ArrayList<Products> items = new ArrayList<Products>();

        try{
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/DataFiles/products.csv"));
//            String line;
            String line = bufReader.readLine();//skip header line

            while ((line = bufReader.readLine())!= null){
             String[] split_part = line.split(Pattern.quote("|"));


             items.add(new Products(split_part[0], split_part[1], Double.parseDouble(split_part[2]), split_part[3]));
            }
        }
        catch (IOException e){
            e.printStackTrace();

        } return items;

    }
    public static void viewAllItems(ArrayList<Products>items){
        for (Products products : items){
            System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s \n", products.getSku(),
                    products.getName(), products.getPrice(), products.getDepartment());
            System.out.println("Choose from next option");
        }
    }
}
