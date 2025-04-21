package com.pluralsight;
import java.util.Scanner;
import java.util.Random;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] quotes ={"Under the lying stone, water does not flow.",
                "A gift in the hand is better than two promises.",
                "An apple is never far from the apple tree.",
                "Learning never exhausts the mind.",
                "Life without love is like a tree without blossoms or fruit.",
                "All that we are is the result of what we have thought.",
                "Family is the most important thing in the world.",
                "The journey of a thousand miles begins with one step. ",
                "Peace begins with a smile. ",
                "It always seems impossible until it’s done."};

        boolean run = true;
        while (run == true){
            System.out.println("Hi! Welcome to the \"Quote Chooser\"!");
            System.out.println("Please select from the next options: ");
            System.out.println("1.Choose a quote");
            System.out.println("2.Random quote");
            System.out.println("3.Exit");
            System.out.print("Your choice (1-3): ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    try {
                        for (int i = 0; i < quotes.length; i++){
                            System.out.println(quotes[i]);
                        }
                        System.out.print("Please select quote(1-10): ");
                        int number_quote = scanner.nextInt();

                        System.out.println("Quote number " + number_quote + " : " + quotes[number_quote - 1]);
                    } catch (Exception e) {
                        System.out.println("Wrong number. Try again!");
                    }
                    break;
                case 2 :
                    Random random = new Random();
                    int ran_quote = random.nextInt(quotes.length);
                    System.out.println("Your random quote is: " + quotes[ran_quote]);
                    break;
                case 3:
                    System.out.println("Buy!");
                    run = false;
            }
        }



    }
}
/*Create a new Java application named FamousQuotes.
Create an array of strings to store 10 quotes. Add 10 of your favorite quotes to
the array.
Prompt the user to select a number between 1 and 10 and display that quote.
DO NOT use try/catch (yet) to handle the error.
Test the application. Select a number that exists. Does it work?
Enter a number that doesn't exist (any number other than 1 to 10). What
happens?
Now add exception handling to the application and retest.
BONUS: Add a loop to the program asks the user if they want to see another
saying. If they say yes, repeat the process. DO NOT shut the application down
when if an exception occurs. Just pick up with the next iteration.
BONUS: Allow the user to select an option that will display a random quote.
Commit and push your code!*/