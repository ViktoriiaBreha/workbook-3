package com.pluralsight;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Products> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run){
            System.out.println("What do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter command(1-5): ");
            int command = scanner.nextInt();

            switch (command){
                case 1:
                    for (int i = 0; i < inventory.size(); i++) {
                        Products p = inventory.get(i);
                        Collections.sort(inventory, Comparator.comparing(Products::getName));
                        System.out.printf("id: %d %s - Price: $ %.2f\n", p.getId(), p.getName(), p.getPrice());

                    }
                    break;
                case 2:
                    System.out.print("Enter product's id: ");
                    int find_id = scanner.nextInt();
                    for (Products p : inventory){
                        if (p.getId()==find_id){
                            System.out.printf("Your product: id: %d %s - Price: $ %.2f",p.getId(), p.getName(), p.getPrice() );
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter minimum price: ");
                    float minimum_price = scanner.nextFloat();
                    System.out.print("Enter maximum price: ");
                    float maximum_price = scanner.nextFloat();

                    for (Products p : inventory){
                        if (p.getPrice()>=minimum_price || p.getPrice()<=maximum_price){
                            System.out.printf("id: %d %s - Price: $ %.2f\n", p.getId(), p.getName(), p.getPrice());
                        } else {
                            System.out.println("We do not have product with this price");
                        }
                    }
                    break;



                case 4:
                    System.out.print("Enter product id: ");
                    int new_id = scanner.nextInt();
                    System.out.print("Enter name of product: ");
                    String new_name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    float new_price = scanner.nextFloat();

                    Products new_p = new Products(new_id, new_name, new_price);
                    inventory.add(new_p);
                    break;

            }
            }
        scanner.close();

        }


    public static ArrayList<Products> getInventory() {
        ArrayList<Products> inventory = new ArrayList<Products>();
        try {
            FileReader fileReader = new FileReader("src/main/resources/DataFiles/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(Pattern.quote("|"));

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);

                Products p = new Products(id, name, price);
                inventory.add(p);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return inventory;


    }

}

