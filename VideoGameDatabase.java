/*
 * Written by Maximus Fernandez
 * Homework 02
 * Video Game Database!
 * Due 02/15/2024 by 11:55PM
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class VideoGameDatabase {

    static Scanner input = new Scanner(System.in);

    public static void print(String arg) {
        System.out.println(arg);
    }

    public static void main(String[] args) {

        boolean quit = false;
        while (!quit) {
            quit = userChoice();
        }
    }

    private static int userPrompt() {
    	print("Enter 1 to load the video game database\n"
                + "Enter 2 to search the database\n"
                + "Enter 3 to print current results to the console\n"
                + "Enter 4 to print current results to file\n"
                + "Enter 0 to quit");

        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            input.next(); // Clear the invalid input
            print("Invalid entry, please enter a number.");
            return -1; // Return a value indicating an invalid choice
        }
    }

    private static boolean userChoice() {
        int choice = userPrompt();

        switch (choice) {
            case 1:
                print("Loading video game database...");
                break;
            case 2:
                print("Searching database...");
                break;
            case 3:
                print("Printing current results to console...");
                break;
            case 4:
                print("Printing current results to file...");
                break;
            case 0:
                print("Goodbye!");
                return true;
            default:
                if (choice != -1) // -1 indicates an invalid choice due to InputMismatchException
                    print("Invalid entry, please try again.");
                break;
        }

        return false;
    }
}
