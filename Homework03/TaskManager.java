/*
* Written by Maximus Fernandez
* Homework 03
* Task Organizer!
* Due 02/23/2024 by 11:55PM
*/

import java.io.*;
import java.util.Scanner;

public class TaskManager {

	
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
	 * Removing task - NOT WORKING
	 * When printed, the removed element is still there
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
	
	
	public static final int BODY_FIELD_AMT = 2; // 2 values to be read, priority and action
	public static final String DELIM = "\t"; // both values separated by TAB
	private GenLL<Task> tasks;
	private GenLL<Task>[] organizedTasks;

	// [DONE]
	public TaskManager() {
		tasks = new GenLL<Task>(); // constructs a generic linked list named 'tasks'
		// Initializes array with size 5
		organizedTasks = new GenLL[5];
		// Initialize each element of array with new linked list
		for (int i = 0; i < organizedTasks.length; i++) {
			// creates one LL for each priority level
			organizedTasks[i] = new GenLL<>();
		}

	}

	// [DONE]
	public void organizeTasks() {
		for (int i = 0; i < organizedTasks.length; i++) {
			// goes through each element and
			// resets them to start of LL
			organizedTasks[i].reset();
		}
		tasks.reset(); // resets the 'tasks' LL
		while (tasks.hasMore()) // checks each element of tasks LL
		{
			// sets 'current' variable to current node of tasks LL
			Task current = tasks.getCurrent();
			// current node's priority = index
			int cPriority = current.getPriority();
			// adds current task to corresponding priority LL
			organizedTasks[cPriority].add(current);
			tasks.gotoNext(); // goes to next element of LL
		}

	}

	// [DONE]
	public void addTask(Task aTask) {
		
		tasks.add(aTask); // adds a new node with data from given aTask
	}

	// [DONE]
	public void removeTask(Task aTask) {
		// "Think of linked lists like an array"
		tasks.reset(); // starts from beginning of list
		while (tasks.hasMore()) // checks through each element of LL
		{
			if (tasks.getCurrent().equals(aTask)) // checks if data from current node is same as aTask
			{
				tasks.removeCurrent(); // removes the current node if data is same as aTask
				return; // ends method
			}
			tasks.gotoNext(); // continues to next element
		}
	}

	// [DONE]
	public void readTaskFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));
			while (fileScanner.hasNextLine()) // goes through each line of the .txt file
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);

				if (splitLines.length == BODY_FIELD_AMT) {
					// splits the lines into columns which are stored in splitLines array
					String priorityStr = splitLines[0];
					String action = splitLines[1];
					// converts priority values from string to integer
					int priority = Integer.parseInt(priorityStr);
					// constructs aTask
					Task aTask = new Task(priority, action);
					// adds aTask to the linked list
					this.addTask(aTask);
				}

			}

			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// prints tasks to file [DONE]
	public void writeTaskFile(String aName) {

		Scanner scanner = new Scanner(System.in);

		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));

			organizeTasks(); // organizes tasks by priority

			// Code goes through each element
			// of organizedTasks array
			for (int i = 0; i < organizedTasks.length; i++) {
				GenLL<Task> taskList = organizedTasks[i];
				taskList.reset();
				while (taskList.hasMore()) {
					Task task = taskList.getCurrent();
					// Will print each line according to
					// task data separated by TAB (DELIM)
					fileWriter.println(task.getPriority() + DELIM + task.getAction());
					taskList.gotoNext();
				}
			}
			fileWriter.close(); // DON'T FORGET TO CLOSE FILEWRITER
		} catch (Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}
	
	//PRINT IS SOMEHOW DUPLICATING THE CURRENT ORGANIZED LINKED LIST***

	// This prints out the tasks to console [WIP]
	public void printTasks() {
		organizeTasks(); // Organizes tasks by priority
		// will print out all tasks within 'tasks' LL
		for (int i=0; i<organizedTasks.length; i++)
		{
			organizedTasks[i].print();
		}
		//organizedTasks[0].print(); //prints out all tasks of priority 0
		
	}

}