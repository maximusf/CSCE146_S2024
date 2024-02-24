/*
 * Written by Maximus Fernandez
 * Homework 02
 * Video Game Database!
 * Due 02/15/2024 by 11:55PM
 */

import java.util.Scanner;
import java.io.*;

public class GameManager {
	/*
	 * <<Game's Name 0>>\t<<Game's Console 0>>\n <<Game's Name 1>>\t<<Game's
	 * Console>>\n 1>>\n DELIMETER = "\t" TERMINATOR = "\n"
	 */
	private GenLL<Game> games; // Creates a linked list that takes objects "Game.java" as data
	private GenLL<Game> search;
	public static final String DELIM = "\t";
	public static final int ITEMS_AMT = 2; // There are only 2 items, name and console, which need to be read for each
											// line

	public GameManager() {
		games = new GenLL<>();
		// including <Game> is not necessary since the constructor already includes it,
		// therefore Java is able to infer <> means <Game> in this case.
		search = new GenLL<>();
	}

	public void addGame(Game aG) {
		if (aG == null)
			return;
		games.add(aG);
	}
	public void addSearch(Game aS) {
		if (aS == null)
			return;
		search.add(aS);
	}

//	public void removeGame(String aN) {
//		if (aN == null)
//			return;
//		// Search for the game with the name
//		games.reset(); // current = head
//		while (games.hasMore()) // current != null
//		{
//			if (games.getCurrent().getName().equalsIgnoreCase(aN)) {
//				games.removeCurrent();
//				break;
//			}
//			games.gotoNext(); // current = current.link
//		}
//	}

	

	public void writeGameFile(String aName, boolean append) {
		try {
			//when append = true, then append mode
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName, append));
			
			games.reset();
			while (games.hasMore()) {
				Game g = games.getCurrent();
				fileWriter.println(g.getName() + DELIM + g.getConsole());
				games.gotoNext();
			}
			fileWriter.close(); // DON'T FORGET THIS

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void writeSearchFile(String aName, boolean append) {
		try {
			//when append = true, then append mode
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName, append));
			
			search.reset();
			while (search.hasMore()) {
				Game g = search.getCurrent();
				fileWriter.println(g.getName() + DELIM + g.getConsole());
				search.gotoNext();
			}
			fileWriter.close(); // DON'T FORGET THIS

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void readGameFile(String fileName, String choice1, String choice2) {
		try {
			Scanner fileScanner = new Scanner(new File(fileName));

			// Read the body
			while (fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();// Read the line
				String[] splitLines = fileLine.split(DELIM); // Split the line
				if (splitLines.length == ITEMS_AMT) // Check the line
				{
					//Handles with "wildcard" choices (i.e. "*")
					if ((choice1.equals("*") || splitLines[0].equalsIgnoreCase(choice1)) 
							&& (choice2.equals("*") || splitLines[1].equalsIgnoreCase(choice2)))
					{
					// Process - create a Game and add it to the array
					String name = splitLines[0]; // String name
					String console = splitLines[1]; // String console
					Game searchGame = new Game(name, console);
					// The line below adds name & console searches to data
					this.addSearch(searchGame);
					}
					else
					//Handles specific searches for game & console
					{
					// Process - create a Game and add it to the array
					String name = splitLines[0]; // String name
					String console = splitLines[1]; // String console
					Game specificGame = new Game(name, console);
					// The line below adds specific name & console searches to data
					this.addGame(specificGame);		
					}
				}
			}

			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public GenLL<Game> searchGame(String query) {
//
//		GenLL<Game> results = new GenLL<>();
//		games.reset(); //resets game list to beginning
//		
//		while(games.hasMore()) //checks each element of games list
//		{
//			Game game = games.getCurrent();
//			if(game.getName().equalsIgnoreCase(query) || game.getConsole().equalsIgnoreCase(query))
//				results.add(game);
//			games.gotoNext(); //moves to next element
//		}
//		return results; //returns search results
//	}
	
	public void printGames() {
		games.print();
		//prints game linked list
	}
	
	public void printSearches() {
		search.print();
		//prints search linked list
	}
	

}