/*
 * Written by Maximus Fernandez
 * Redo: Homework 02
 * Video Game Database!
 * Due 02/15/2024 by 11:55PM
 */

// GAME FE IS DONE, NOW ONLY NEED TO ADJUST GAMEMANAGER
// NEED TO ADD writeDatabaseFile(fileName) AND writeSearchesFile(fileName)
// 

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
		case 1: //done
			loadFile(); //loads the .txt file entered
			break;
		case 2: //done
			if(fileName == null)
			{
				print("You have not loaded in a video game database file. Try again.");
			}
			else {
				searchFile();
			}
			
			break;
		case 3: //done
			if (fileName == null) {
			    // Print "No file has been loaded" if no file is loaded
			    print("You have not loaded in a video game database. Try again.");
			} else {
			    if (gameName == null && consoleName == null) {
			        // If both choices are null, print the database
			    	printDatabase();
			    } else {
			        // Otherwise, print the searches
			        printSearches();
			    }
			}

			
			
			break;
		case 4:
			if(gameName == null && consoleName == null)
				writeDatabaseFile();
			else
				writeSearchFile();
			
			print("Successfully printed current results to file!");
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
	private static void loadFile() {
		print("Enter the file name");
		String fileName = input.nextLine();
		gameManager.readGameFile(fileName, null, null);
		print("Database loaded successfully!");
	}

	// case 2
	// calls readGameFile method within gameManager
	private static void searchFile() {
		//print("Enter the file you would like to search");
	    print("Enter the name of the game or '*' for all" );
	   // String choice1 = input.nextLine();
	    gameName = input.nextLine();
	    
	    print("Enter search term for Console or '*' for all ");
	   // String choice2 = input.nextLine();
	    consoleName = input.nextLine();
	    gameManager.readGameFile(fileName, gameName, consoleName);
	    gameManager.printSearches();
		
	}
	
	// case 3
	public static void printSearches()
	{
		gameManager.printSearches();
	}
	public static void printDatabase()
	{
		gameManager.printGames();
	}

	// case 4
	public static void writeDatabaseFile() {
        print("Enter the file name to write a Database File");
        fileName = input.nextLine();
        gameManager.writeDatabaseFile(fileName);
    }
	
	public static void writeSearchFile() {
        print("Enter the file name to write a Database File");
        fileName = input.nextLine();
        gameManager.writeSearchesFile(fileName);
    }
	
}