/*
* Written by Maximus Fernandez
* Homework 03
* Task Organizer!
* Due 02/23/2024 by 11:55PM
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskManagerFE {

	private static TaskManager taskManager = new TaskManager();
	private static String fileName;
	private static int priority = 0;
	private static String action = null;
	static Scanner input = new Scanner(System.in);

	private static void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		print("Welcome to the Task Organizer!");
		boolean quit = false;
		while (!quit) {
			quit = userChoice();
		}
	}

	private static int userPrompt() {
		print("Enter 1. To Add a Task\n" + "Enter 2. To Remove a Task\n" + "Enter 3. To Print Tasks To Console\n"
				+ "Enter 4. To Read from a Task File\n" + "Enter 5. To Write to a Task File\n" + "Enter 9. to Quit");

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
			addTask(); // adds a task to task LL
			break;
		case 2:
			removeTask(); // removes a specific task from task LL
			break;
		case 3:
			printTasks(); // prints tasks to console
			break;
		case 4:
			input.nextLine();
			readTaskFile(); // "loads" an existing text file
			break;
		case 5:
			input.nextLine();
			writeTaskFile(); // creates a new text file with LL data
			break;
		case 9:
			print("Goodbye!");
			return true; // ends the program
		default:
			if (choice != -1) // -1 indicates an invalid choice due to InputMismatchException
				print("Invalid entry, please try again.");
			break;
		}
		//continues the program
		return false;
	}

	// case 1 - Adding a Task [DONE]
	public static void addTask() {
		print("Enter the task's priority");
		
		try {
			priority = input.nextInt();
		} catch (InputMismatchException e) {
			input.next();
			print("You did not enter an integer value. Please try again.");
			return;
		}
		
		input.nextLine(); // consumes newline character
		if (priority < 0 || priority > 4)
		{
			print("The priority must be a number between 0 and 4. Please try again.");
			return;
		}
		print("Enter the task's action");
		action = input.nextLine();
		// creates a new task with given priority and action specified
		Task aTask = new Task(priority, action);
		// Will add a task with specified data to the LL
		taskManager.addTask(aTask);
		print("Task successfully added.");
		print("");
	}

	// case 2 - Removing a Task [DONE]
	public static void removeTask() {
		
		print("Enter the task's priority");
		try {
			priority = input.nextInt();
		} catch (InputMismatchException e) {
			input.next();
			print("You did not enter an integer value. Please try again.");
			return;
		}
		
		input.nextLine(); // consumes newline character
		print("Enter the task's action");
		action = input.nextLine();
		// creates a new task with given priority and action
		Task aTask = new Task(priority, action);
		// Will remove the task with specific data
		taskManager.removeTask(aTask);
		print("Task successfully removed.");
		print("");
	}

	// case 3 - Print All Tasks to Console [DONE]
	public static void printTasks() {

		// Will print all data within the tasks linked list
		// Will display both priority and action
		// Will print list in priority order starting with highest
		// and ending with lowest (Priority 0 to Priority 4)
		// [Must be organized] --> Check JJ's reference code
		taskManager.printTasks();
		print("");
	}

	// case 4 - Reading a Task File [DONE]
	// Like 'loading' an existing game file
	public static void readTaskFile() {
		// The user provides name of the file
		print("Enter the file name");
		fileName = input.nextLine();
		
		// Will populate the linked list after reading the task file
		taskManager.readTaskFile(fileName);
	}

	// case 5 - Writing Tasks to a Task File / Printing a Task File [WORKING BUT SYNTAX ERROR AFTERWARDS]
	public static void writeTaskFile() {
		print("Enter the file name");
		fileName = input.nextLine();
		
		// Will store current linked list data to a new task file with given name
		taskManager.writeTaskFile(fileName);
	}

}