/*
 * Written by Maximus Fernandez
 * Homework 02
 * Video Game Database!
 * Due 02/15/2024 by 11:55PM
 */

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameFE {

	private static GameManager gameManager = new GameManager();
	private static String fileName;
	private static String gameName = null;
	private static String consoleName = null;
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
		print("Welcome to the Video Game Database!");
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
			loadDatabase(); //loads the .txt file entered
			break;
		case 2:
			if(fileName == null)
			{
				print("You have not loaded in a video game database. Try again.");
			}
			else {
				searchDatabase();
			}
			
			break;
		case 3:
			if (fileName == null) {
			    // Print "No file has been loaded" if no file is loaded
			    print("You have not loaded in a video game database. Try again.");
			} else {
			    if (gameName == null && consoleName == null) {
			        // If both choices are null, print the database
			    	printGames();
			    } else {
			        // Otherwise, print the searches
			        printSearches();
			    }
			}

			
			
			break;
		case 4:
			print("Printing current results to file...");
			resultsToFile();
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

	// case 1
	// calls readGameFile method within gameManager
	private static void loadDatabase() {
		print("Enter the file name");
		String fileName = input.nextLine();
		gameManager.readGameFile(fileName, null, null);
		print("Database loaded successfully!");
	}

	// case 2
	// calls readGameFile method within gameManager
	private static String searchDatabase() {
		// CHECK SHREK ASSIGNMENT
		// CHECK TACO MANAGER
		
	}
	
	// case 3
	private static void resultsToConsole() {
		print("Enter the name of the game or '*' for all");
		String gameName = input.nextLine();
		print("Enter the name of the console or '*' for all");
		String consoleName = input.nextLine();
		//Goes through all matching game/console names and places them in search linked list
		gameManager.readGameFile(fileName, gameName, consoleName);
		//Prints all the searches
		gameManager.printSearches();
		
	}

	// case 4
	private static void resultsToFile() {
		print("Enter the name of the file you want to create");
		String fileName = input.nextLine();
		//Should be able to write results to a new file
		System.out.println("Would you like to append? [True/False]");
		boolean append = input.nextBoolean();
		gameManager.writeGameFile(fileName, append);
	}
	
	public static void printSearches()
	{
		
		gameManager.printSearches();
		
	}
	
	public static void printGames()
	{
		gameManager.printGames();
	}

}