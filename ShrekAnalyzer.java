
// 1/25/2024 - CSCE 146 Freshman
// Using an I/O to analyze a text file (Shrek script)
// for number of times a certain word is said

import java.util.Scanner;
import java.io.*; //File input and output
public class ShrekAnalyzer {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Welcome to the Shrek Analyzer. "
				+ "\nEnter a word and I'll count the amount.");
		
		String word = keyboard.nextLine(); //software waits for an I/O request
		
		//TODO count the words
		int count = lookForWord(word);
		System.out.println("The word "+word+" appears "+count+" number of times");
		
		keyboard.close();
	}
	public static int lookForWord(String aWord)
	{
		if (aWord == null)
			return 0;
		int ret = 0;
		try
		{
			Scanner fileScanner = new Scanner(new File("./Shrek.txt")); 
			// You would put the shrek.txt file in the "Personal" project folder (use Show in --> System Explorer)
			// NOT in the src folder
			while(fileScanner.hasNext())
			{
				String next = fileScanner.next();
				if(next.toUpperCase().contains(aWord.toUpperCase())) //will find the word, regardless of capitalization of word
					// changes the word to uppercase then checks for it
					// could've also used .toLowerCase() method
				{
					ret++;
				}
			}
			
			fileScanner.close(); //DON'T FORGET TO CLOSE FILE OPERATIONS!
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}

}
