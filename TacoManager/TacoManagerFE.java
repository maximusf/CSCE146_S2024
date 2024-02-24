/*
 * Why we use .TXT Files instead of .JSON (Fact!): 
 * Every spreadsheet uses a TAB DELIMETER which is why we are using .txt files with tab DELIM
 * You can LITERALLY drag the txt file into excel and they will separate each value into corresponding rows/columns
 * AFTER that, you can PLOT the points for a graphical representation of numbers (if they are numbers)
 * 
 * How to debug:
 * 
 * 
 */

import java.util.Scanner;
public class TacoManagerFE {

	private static Scanner keyboard = new Scanner(System.in);
	private static TacoManager tacoManager = new TacoManager();
	public static void main(String[] args) {
		printGreeting();
		boolean quit = false;
		while(!quit)
		{
			printChoices();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				addTaco();
				break;
			case 2:
				removeTaco();
				break;
			case 3:
				readTacoFile();
				break;
			case 4:
				writeTacoFile();
				break;
			case 9:
				quit = true;
				break;
				default:
					System.out.println("Invalid input");
			}
			tacoManager.printTacos();
		}
	}
	public static void printGreeting()
	{
		System.out.println("Welcome to the Taco Manager");
	}
	public static void printChoices()
	{
		System.out.println("Enter 1 to add a taco\n"
				+ "Enter 2 to remove a taco\n"
				+ "Enter 3 to read a taco database file\n"
				+ "Enter 4 to write to a taco database file\n"
				+ "Enter 9 to quit");
	}
	public static void addTaco()
	{
		System.out.println("Enter the name of the taco");
		String name = keyboard.nextLine();
		System.out.println("Enter the location of the taco");
		String location = keyboard.nextLine();
		System.out.println("Enter the price of the taco");
		double price = keyboard.nextDouble();
		keyboard.nextLine();
		tacoManager.addTaco(new Taco(name,location,price));
	}
	public static void removeTaco()
	{
		System.out.println("Enter the name of the taco to remove");
		String name = keyboard.nextLine();
		tacoManager.removeTaco(name);
	}
	public static void readTacoFile()
	{
		System.out.println("Enter the file name to read a TacoDB");
		String fileName = keyboard.nextLine();
		tacoManager.readTacoFile(fileName);
	}
	public static void writeTacoFile()
	{
		System.out.println("Enter the file name to write a TacoDB File");
		String fileName = keyboard.nextLine();
		tacoManager.writeTacoFile(fileName);
	}
	
}
