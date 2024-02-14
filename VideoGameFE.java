/*
 * Written by Maximus Fernandez
 * Homework 02
 * Video Game Database!
 * Due 02/15/2024 by 11:55PM
 */

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VideoGameFE {

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
			loadDatabase();
			break;
		case 2:
			print("Searching database...");
			searchDatabase();
			break;
		case 3:
			print("Printing current results to console...");
			resultsToConsole();
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
	private static void resultsToFile() {
		// TODO Auto-generated method stub
		print("Enter the file name");
		String fileName = input.nextLine();
	}

	// case 2
	private static void resultsToConsole() {
		print("Enter the name of the game or '*' for all");
		String gameName = input.nextLine();
		print("Enter the name of the game or '*' for all");

	}

	// case 3
	private static void searchDatabase() {
		// TODO Auto-generated method stub
		// CHECK SHREK ASSIGNMENT
		// CHECK TACO MANAGER

	}

	// case 4
	private static void loadDatabase() {
		// TODO Auto-generated method stub

	}

	public static void readTacoFile() {
		// FileReader = read the contents of a file as a stream of characters.
		// read() returns an int value which contains the byte value
		// when read() returns -1, there is no more data to be read

		try {
			FileReader fr = new FileReader("art.txt");
			int data = fr.read();
			while (data != -1) {
				System.out.print((char) data);
				data = fr.read();
			}
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeTacoFile() {
		// initialize a string
		String str = "ABC";

		try {

			// attach a file to FileWriter
			FileWriter fw = new FileWriter("D:/data/file.txt");

			// read each character from string and write
			// into FileWriter
			for (int i = 0; i < str.length(); i++)
				fw.write(str.charAt(i));

			System.out.println("Successfully written");

			// close the file
			fw.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}