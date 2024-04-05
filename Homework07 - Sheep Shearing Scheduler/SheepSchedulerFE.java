import java.util.Scanner;

public class SheepSchedulerFE {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
//		Sheep sheep = new Sheep("Sam", 2, 3);
//		GenMinHeap <Sheep> sHeap = new GenMinHeap<Sheep>();
//		
//		sHeap.add(sheep);
//		sHeap.remove();
//		sHeap.add(sheep);
//		sHeap.print();
		
		System.out.println("Welcome to Sheep Shearing Scheduler!");
		Boolean quit = false;
		while(!quit)
		{
			quit = programStuff();
		}
		System.out.println();
		System.out.println("Goodbye!");
		
		
	}
	
	public static Boolean programStuff() {
		System.out.println("What is the name of the file?");
		String fileName = input.nextLine();
		input.next();
		readSheepFile(fileName);
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
	
	
}
