package com.pluralsight;

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
        for (int i = 0; i < inventory.size(); i++) {
            Products p = inventory.get(i);
            Collections.sort(inventory, Comparator.comparing(Products::getName));
            System.out.printf("id: %d %s - Price: $ %.2f\n", p.getId(), p.getName(), p.getPrice());
        }
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
