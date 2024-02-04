/*
 * Written by Maximus Fernandez
 * Showcase Showdown!
 * Due 02/09/2024 by 11:55pm
 */
import java.util.Random;
import java.util.Scanner;
public class Homework_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // create instance of Scanner
		Random r = new Random(); // create instance of Random class
		int answer, guess;
		final int MAX = 5;
		answer = r.nextInt(MAX) + 1; // Returns a random number between 1 and 5
		
		System.out.println("Welcome to the showcase show down!\nYour Prizes are:");
		//program should randomly pick exactly 5 unique prizes from the prize data structure
		System.out.println("[The prizes should be printed out]");
		System.out.println("You must guess the total cost of the prizes without going over and within $1,300 of its actual price");
		System.out.println("Enter your guess");
		guess = input.nextInt();
		
		System.out.println("The actual cost was " + answer);
		//checks if answer is between the actual price and actual price -$1300
		if (guess <= answer && guess >= (answer - 1300)) 
		{
			System.out.println("Congratulations! You won!");
		} else {
			System.out.println("Sorry, you lost.");
		}
		
		
		
		
		
		input.close();
		
	}
	
}
