/*
 * Written by Maximus Fernandez
 * Shape Tree
 * Due 03/29/2024 by 11:55pm
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class ShapeTreeFE {

	static Scanner input = new Scanner(System.in);
	
	public static void print(String arg) {
		System.out.println(arg);
	}
	
	public static void main(String[] args) {
		print("Welcome to the Shape Tree!");

		boolean quit = false;
		while (!quit) {
			quit = userChoice();
		}
		print("Goodbye!");
	}
	
	public static int userPrompt() {
		print("Enter 1. To Read a Shape Tree from a file\n"
				+ "Enter 2. To Print a Tree Traversal to the Console\n"
				+ "Enter 3. To Add a Shape.\n"
				+ "Enter 4. To Remove a Shape.\n"
				+ "Enter 5. To Search for a Shape.\n"
				+ "Enter 6. To Find the Shape with the Max Area\n"
				+ "Enter 7. To Remove All Shapes Greater than an Area.\n"
				+ "Enter 8. To Print Shape Tree to File.\n"
				+ "Enter 0. To Quit.");
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
			readShapeTreeFile();
			break;
		case 2:
			printTreeTraversal();
			break;
		case 3:
			addShape();
			break;
		case 4:
			removeShape();
			break;
		case 5:
			searchShape();
			break;
		case 6:
			findShapeMaxArea();
			break;
		case 7:
			removeShapesGreaterThanArea();
			break;
		case 8:
			printShapeTreeFile();
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
	
	
	//case 1 - Read Shape (WIP)
	public static void readShapeTreeFile() {
		print("Enter the file's name");
		String fileName = input.nextLine();
		input.next();
		ShapeTreeBE.printFileContents(fileName);
	}
	
	//case 2 - Print Tree Traversal to Console (WIP)
	public static void printTreeTraversal() {
		print("Which traversal?\n"
				+ "Enter 1. For Pre-order\n"
				+ "Enter 2. For In-order\n"
				+ "Enter 3. For Post-order");
		try 
		{
			int choice = input.nextInt();
		} 
		catch(InputMismatchException e) 
		{
			input.next(); // Clear the invalid input
			print("Invalid entry, please enter a number.");
		}
		
		//not sure what this is supposed to be
		ShapeTreeBE.printFileContents(null); //**
		
		
	}
	
	//case 3 - Add a Shape (WIP)
	public static void addShape() {
		print("Enter the type of shape to add");
		String shapeName = input.nextLine();
		input.next();
		
		if(shapeName.equalsIgnoreCase("right triangle"));
		{
			print("Enter the base followed by the height");
			try 
			{
				double base = input.nextDouble();
				double height = input.nextDouble();
			} 
			catch(InputMismatchException e) 
			{
				input.next(); // Clear the invalid input
				print("Invalid entry, please enter a number.");
			}
		}
		if(shapeName.equalsIgnoreCase("rectangle"));
		{
			print("Enter the length followed by the width");
			try 
			{
				double length = input.nextDouble();
				double width = input.nextDouble();
			} 
			catch(InputMismatchException e) 
			{
				input.next(); // Clear the invalid input
				print("Invalid entry, please enter a number.");
			}
		}
		if(shapeName.equalsIgnoreCase("circle"));
		{
			print("Enter the radius");
			try 
			{
				double radius = input.nextDouble();
			} 
			catch(InputMismatchException e) 
			{
				input.next(); // Clear the invalid input
				print("Invalid entry, please enter a number.");
			}
		}
		
		//something needs to go here
		//***
		
	}
	
	//case 4 - Remove a Shape
	public static void removeShape() {
		print("Enter the type of shape to remove");
		String shapeName = input.nextLine();
		input.next();
		
		if(shapeName.equalsIgnoreCase("right triangle"));
		{
			print("Enter the base followed by the height");
			try 
			{
				double base = input.nextDouble();
				double height = input.nextDouble();
			} 
			catch(InputMismatchException e) 
			{
				input.next(); // Clear the invalid input
				print("Invalid entry, please enter a number.");
			}
		}
		if(shapeName.equalsIgnoreCase("rectangle"));
		{
			print("Enter the length followed by the width");
			try 
			{
				double length = input.nextDouble();
				double width = input.nextDouble();
			} 
			catch(InputMismatchException e) 
			{
				input.next(); // Clear the invalid input
				print("Invalid entry, please enter a number.");
			}
		}
		if(shapeName.equalsIgnoreCase("circle"));
		{
			print("Enter the radius");
			try 
			{
				double radius = input.nextDouble();
			} 
			catch(InputMismatchException e) 
			{
				input.next(); // Clear the invalid input
				print("Invalid entry, please enter a number.");
			}
		}
		
		//something needs to go here
		//***
		
	}
	
	//case 5 - Search for a Shape
	public static void searchShape() {
		print("Enter the type of shape to Search");
		String shapeName = input.nextLine();
		input.next();
		
		
	}
	
	//case 6 - Find Shape with the Max Area
	public static void findShapeMaxArea() {
		
	}
	
	//case 7 - Remove All Shapes Greater than an Area
	public static void removeShapesGreaterThanArea() {
		
	}
	
	//case 8 - Print Shape Tree to File
	public static void printShapeTreeFile() {
		
	}
	
	
	
	private static void 
	
	
}
