/*
* Written by Maximus Fernandez
* Homework 03
* Task Organizer!
* Due 02/23/2024 by 11:55PM
*/

import java.io.*;
import java.util.Scanner;

public class TaskManager {

	public static final int BODY_FIELD_AMT = 2; // 2 values to be read, priority and action
	public static final String DELIM = "\t"; // both values separated by TAB
	private GenLL<Task> tasks;
	private GenLL<Task>[] organizedTasks;

	static Scanner scanner = new Scanner(System.in);
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
			clearTasksList();
			Scanner fileScanner = new Scanner(new File(aName));
			while (fileScanner.hasNextLine()) // goes through each line of the text file
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

	// prints tasks to a new file [DONE]
	public void writeTaskFile(String aName) {

		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));

			// Remove all tasks from each priority level
			clearOrganizedList();
			
			organizeTasks(); // organizes tasks by priority (populates organizedTasks LL)

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
		
	}

	// This prints out the tasks to console [DONE]
	public void printTasks() {
	    // Remove all tasks from each priority level
		clearOrganizedList();

	    // Organize tasks by priority
	    organizeTasks();

	    // Print tasks from each priority level
	    for (int i = 0; i < organizedTasks.length; i++) {
	        GenLL<Task> taskList = organizedTasks[i];
	        taskList.print();
	    }
	}
	
	public void clearOrganizedList() {
		// Remove all tasks from each priority level
	    for (int i = 0; i < organizedTasks.length; i++) {
	        GenLL<Task> taskList = organizedTasks[i];
	        taskList.reset(); // Start from the beginning of the list
	        while (taskList.hasMore()) {
	            taskList.removeCurrent(); // Remove the current task
	        }
	    }
	}
	public void clearTasksList() {
		tasks.reset();
		while(tasks.hasMore())
			tasks.removeCurrent();
	}

}