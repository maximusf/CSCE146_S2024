//Kevin Do

import java.util.Scanner;
public class DatabaseManagerFE {
	
	
	
	private static String theFile;
	private static String choice1 = null;
	private static String choice2 = null;
	public static Scanner input = new Scanner(System.in);
	private static DatabaseManager databaseManager = new DatabaseManager();
	public static void print(String s)
	{
		System.out.println(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 0;
		boolean run = true;
		while (run)
		{
			print("Enter 1 to load the video game database" + '\n'
					+ "Enter 2 to search the database" + '\n'
					+ "Enter 3 to print current results to the console" + '\n'
					+ "Enter 4 to print current results to file" + '\n'
					+ "Enter 0 to quit");
			choice = input.nextInt();
		
			input.nextLine(); 
			// This prevents the input from looping 
			
			switch(choice)
			{
			case 1:
				readDatabaseFile();
				// This calls the read databaseFile method
				break;
			case 2:
				if (theFile == null)
				{
					print("No database has been loaded");
				}else 
					searchDatabaseFile();
				
				// This will print the database file if the file is not searched
				
	
				break;
			case 3:
			
				if(theFile == null)
				{
					// This will print out no file loaded if 
					// a file is not loaded first 
					print("No file has been loaded");
				}
				
				
				
				if(choice1 == null && choice2 == null)
				{
					printDatabase();
			
				}
				else 
					printSearches();

				

				break;
			case 4:
				if(choice1 == null && choice2 == null)
				{
					writeDatabaseFile();
					
				}else
					writeSearchesFile();
			break;
			case 0:
			run = false;
			print("Goodbye User!");
			break;
			default:
				print("Invalid option");
				
			}

			
		}
	}
	

	
	public static void searchDatabaseFile()
	{
		//print("Enter the file you would like to search");
	    print("Enter the name of the game or '*' for all" );
	   // String choice1 = input.nextLine();
	    choice1 = input.nextLine();
	    
	    print("Enter search term for Console or '*' for all ");
	   // String choice2 = input.nextLine();
	    choice2 = input.nextLine();
	    databaseManager.searchDatabaseFile(theFile, choice1, choice2);
	    databaseManager.printSearches();
	}
	
	
	public static void readDatabaseFile()
	{
		print("Enter the file name");
		theFile = input.nextLine();
		databaseManager.readDatabaseFile(theFile);
		//This calls the readDatabaseFile method inside the instance databaseManager
	
	}
	
	public static void writeDatabaseFile() {
        print("Enter the file name to write a Database File");
        theFile = input.nextLine();
        databaseManager.writeDatabaseFile(theFile);
    }
	
	public static void writeSearchesFile() {
        print("Enter the file name to write a Database File");
        theFile = input.nextLine();
        databaseManager.writeSearchesFile(theFile);
    }
	
	public static void printSearches()
	{
		
		databaseManager.printSearches();
		
	}
	
	public static void printDatabase()
	{
		databaseManager.printDatabase();
	}

}
