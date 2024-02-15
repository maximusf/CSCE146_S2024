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
	public static final String DELIM = "\t";
	public static final int ITEMS_AMT = 2; // There are only 2 items, name and console, which need to be read for each
											// line

	public GameManager() {
		games = new GenLL<>();
		// including <Game> is not necessary since the constructor already includes it,
		// therefore Java is able to infer <> means <Game> in this case.
	}

	public void addGame(Game aG) {
		if (aG == null)
			return;
		games.add(aG);
	}

	public void removeGame(String aN) {
		if (aN == null)
			return;
		// Search for the game with the name
		games.reset(); // current = head
		while (games.hasMore()) // current != null
		{
			if (games.getCurrent().getName().equalsIgnoreCase(aN)) {
				games.removeCurrent();
				break;
			}
			games.gotoNext(); // current = current.link
		}
	}

	public void printTacos() {
		games.print();
	}

	public void writeGameFile(String aName) {
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
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

	public void readGameFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));

			// Read the body
			while (fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();// Read the line
				String[] splitLines = fileLine.split(DELIM); // Split the line
				if (splitLines.length == ITEMS_AMT) // Check the line
				{
					// Process - create a Game and add it to the array
					String name = splitLines[0]; // String name
					String console = splitLines[1]; // String location
					Game aGame = new Game(name, console);
					this.addGame(aGame);
				}
			}

			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GenLL<Game> searchGame(String query) {

		GenLL<Game> results = new GenLL<>();
		games.reset(); //resets game list to beginning
		
		while(games.hasMore()) //checks each element of games list
		{
			Game game = games.getCurrent();
			if(game.getName().equalsIgnoreCase(query) || game.getConsole().equalsIgnoreCase(query))
				results.add(game);
			games.gotoNext(); //moves to next element
		}
		return results; //returns search results
	}

}