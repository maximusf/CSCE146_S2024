//Kevin Do

import java.util.Scanner;
import java.io.*;
public class DatabaseManager 
{
	
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;
	
	private GenLL<Database> databases;
	private GenLL<Database> searches;
	
	
	
	
	
	public DatabaseManager()
	{
		databases = new GenLL<Database>();
		searches = new GenLL<Database>();
	}
	
	
	
	
	 public void addDatabase(Database aDatabase) {
	        databases.add(aDatabase);
	    }
	
	 public void addSearch(Database aSearch) {
		 searches.add(aSearch);
	 }
	 
	 
	public void writeSearchesFile(String aName) {// Original write searches
		

		
		   try {
		            
			   Scanner scanner = new Scanner(System.in);
		       System.out.println("Would you like to append? True or False?");
		  
		       boolean append = scanner.nextBoolean();
					// This allows the user to set the append to true or false

		            // Set the second parameter to 'true' for append mode
		       PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName, append));
		            
		            searches.reset();
		            while (searches.hasMore()) 
		            {
		                Database database = searches.getCurrent();
		                fileWriter.println(database.getName() + 
		                DELIM + database.getConsole());
		                searches.gotoNext();
		            }

		            fileWriter.close();
		           
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		    }

	public void writeDatabaseFile(String aName) {
		

		
        try {
            
        	Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to append? True or False?");
  
			boolean append = scanner.nextBoolean();
			// This allows the user to set the append to true or false

            // Set the second parameter to 'true' for append mode
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName, append));
            
           databases.reset();
            while (databases.hasMore()) 
            {
                Database database = databases.getCurrent();
                fileWriter.println(database.getName() + 
                DELIM + database.getConsole());
                databases.gotoNext();
            }

            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

		

	
	public void searchDatabaseFile(String aName,String choice1, String choice2)
	{
		
		try {
	        Scanner fileScanner = new Scanner(new File(aName));

	     while (fileScanner.hasNextLine()) {
	            String fileLine = fileScanner.nextLine();
	            String[] splitLines = fileLine.split(DELIM);

	     if (splitLines.length == BODY_FIELD_AMT) {
	         if ((choice1.equals("*") || splitLines[0].toLowerCase().contains(choice1.toLowerCase()))
	         && (choice2.equals("*") || splitLines[1].toLowerCase().contains(choice2.toLowerCase()))) 
	        	  //This if statment searches the file for matches to the users input for choice 1 & choice 2
	            	{
	              		String name = splitLines[0];
	              		String console = splitLines[1];
	                   // This splits the name and console into a string array
	                   // that is seperated by a tab
	                   
	                	Database searches = new Database(name, console);
	                   // This adds the name and console searches into a new database
	                 this.addSearch(searches);
	                }
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		
	}
	
	
	public void readDatabaseFile(String aName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aName));
			while (fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				
				
			if(splitLines.length == BODY_FIELD_AMT)
				{
				String name = splitLines[0];
				String console = splitLines[1];
				Database aDatabase = new Database(name, console);
				this.addDatabase(aDatabase);
				} 
				
			}
			
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	public void printDatabase()
	{
		databases.print();
		// This prints out the database file content
	}
	
	public void printSearches()
	{
		searches.print();
		// This prints out my searches linked list 
	}

	
}
