package com.pluralsight;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
       while (run){
           System.out.println("Welcome to thr \"Bed Time Stories\"");
           System.out.println("Choose your story: ");
           System.out.println("1.Goldilocks.");
           System.out.println("2.Hansel and Gretel.");
           System.out.println("3.Mary had a little lamb.");
           System.out.print("Your choice (1-3): ");
           int choice = scanner.nextInt();

           switch (choice){
               case 1:
                   try {
                       FileInputStream fis = new FileInputStream("src/main/resources/DataFiles/goldilocks.txt");
                       Scanner scanner1 = new Scanner(fis);
                       String input;
                       while(scanner1.hasNextLine()){
                           input = scanner1.nextLine();
                           System.out.println(input);
                       }
                       scanner1.close();
                   } catch (IOException e){
                       e.printStackTrace();
                   }
                   break;
               case 2:
                   try {
                       FileInputStream fis = new FileInputStream("src/main/resources/DataFiles/hansel_and_gretel.txt");
                       Scanner scanner2 = new Scanner(fis);
                       String input;
                       while(scanner2.hasNextLine()){
                           input = scanner2.nextLine();
                           System.out.println(input);
                       }
                       scanner2.close();
                   } catch (IOException e){
                       e.printStackTrace();
                   }
                   break;
               case 3 : try {
                   FileInputStream fis = new FileInputStream("src/main/resources/DataFiles/mary_had_a_little_lamb.txt");
                   Scanner scanner3 = new Scanner(fis);
                   String input;
                   while(scanner3.hasNextLine()){
                       input = scanner3.nextLine();
                       System.out.println(input);
                   }
                   scanner3.close();
               } catch (IOException e){
                   e.printStackTrace();
               }

           }

           scanner.close();

       }

    }
}
