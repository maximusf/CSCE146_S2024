/*
* Written by Maximus Fernandez
* Homework 03
* Task Organizer!
* Due 02/23/2024 by 11:55PM
*/

	/*
	 * Loading in a file - WORKS!
	 * 
	 * Printing organized LL of tasks - NOT WORKING
	 * Seems to be adding an extra LL of data 
	 * for each time the list is printed to console
	 * Ex: Correct the first time printed, 
	 * but doubled the second time printed
	 * 
	 * 
	 * Removing task - WORKS
	 * Successfully removes a task, 
	 * but the extra task with the same data remains
	 * Also, should tell user to retry when removing a task while 
	 * no task file has been read
	 * 
	 * Adding task NOT WORKING
	 * (once printed, action seems like a BLANK space, 
	 * but at least it's in the right spot)
	 * Also, should tell user to retry when adding a task while 
	 * no task file has been read
	 * 
	 * Writing task file ERROR
	 * gives back a syntax error once 5 is pressed
	 * 
	 * Quitting - WORKS!
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
				+ "Enter 4. To Read from a Task File\n" + "Enter 5. To Write to a Task File\n" + "Enter 9 to Quit");

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
			addTask(); // adds a task to LL
			break;
		case 2:
			removeTask(); // removes a specific task from LL
			break;
		case 3:
			if (fileName == null) {
				// Print "No file has been loaded" if no file is detected
				print("You have not loaded in a task file. Try again.");
			} else {
				printTasks();
			}
			break;
		case 4:
			input.nextLine();
			readTaskFile();
			break;
		case 5:
			writeTaskFile();
			break;
		case 9:
			print("Goodbye!");
			return true;
		default:
			if (choice != -1) // -1 indicates an invalid choice due to InputMismatchException
				print("Invalid entry, please try again.");
			break;
		}

		return false;
	}

	// case 1 - Adding a Task [DONE]
	public static void addTask() {
		print("Enter the task's priority");
		priority = input.nextInt();
		input.nextLine(); //consumes newline character
		print("Enter the task's action");
		action = input.nextLine();
		// creates a new task with given priority and action specified
		Task aTask = new Task(priority, action);
		// Will add a task with specified data to the linkedlist
		taskManager.addTask(aTask);
		print("Task successfully added.");
		print("");
	}

	// case 2 - Removing a Task [DONE]
	public static void removeTask() {
		print("Enter the task's priority");
		priority = input.nextInt();
		input.nextLine(); //consumes newline character
		print("Enter the task's action");
		action = input.nextLine();
		// creates a new task with given priority and action
		Task aTask = new Task(priority, action);
		// Will remove the task with specific data
		taskManager.removeTask(aTask);
		print("Task successfully removed.");
		print("");
	}

	// case 3 - Print All Tasks to Console [WIP]
	public static void printTasks() {

		// Will print all data within the tasks linked list
		// Will display both priority and action
		// Will print list in priority order starting with highest
		// and ending with lowest (Priority 0 to Priority 4)
		// [Must be organized] --> Check JJ's reference code
		taskManager.printTasks();
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

	// case 5 - Writing Tasks to a Task File / Printing a Task File [WIP]
	public static void writeTaskFile() {
		print("Enter the file name");
		fileName = input.nextLine();
		// Will store current linked list data to a new task file with given name
		taskManager.writeTaskFile(fileName);
	}

}