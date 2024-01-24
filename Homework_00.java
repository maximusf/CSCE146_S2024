
/*
 * Written by Maximus Fernandez
 * Vector Math Program
 * Due 02/02/2024 by 11:55PM
 */
import java.util.Scanner;
import java.lang.Math;

public class Homework_00 {

	public static void main(String[] args) {
		// initialize scanner
		Scanner input = new Scanner(System.in);
		// welcome message
		System.out.println("Welcome to the Vector Operations Program!");

		// while-loop will keep program running until 9 is pressed
		boolean keepRunning = true;
		while (keepRunning) {

			System.out.println("Enter 1. To Add 2 Vectors");
			System.out.println("Enter 2. To Subtract 2 Vectors");
			System.out.println("Enter 3. To Find the Magnitude of a Vector");
			System.out.println("Enter 9. To Quit");
			int choice = input.nextInt();

			if (choice >= 1 && choice <= 3) {
				System.out.println("Enter the size of the Vectors");
				int vectorSize = input.nextInt();

				if (vectorSize <= 0) {
					// error message if invalid size
					System.out.println("Invalid size, try again");
					continue;
					// program should RESTART the program if invalid
				}

				System.out.println("Enter values for Vector1");
				double[] vector1 = new double[vectorSize]; // initialize vector1
				for (int i = 0; i < vectorSize; i++) {
					// fills in values for vector1 array
					vector1[i] = input.nextDouble();
				}

				double[] result = new double[vectorSize];

				if (choice != 3) {
					System.out.println("Enter values for Vector2");
					double[] vector2 = new double[vectorSize]; // initialize vector1
					for (int i = 0; i < vectorSize; i++) {
						// fills in values for vector2 array
						vector2[i] = input.nextDouble();
					}
					System.out.println("Result:");
					if (choice == 1) {
						result = vectorSum(vectorSize, vector1, vector2);
						// prints out sum of vectors
						printOperation("+", vector1, vector2, result);
					} else if (choice == 2) {
						result = vectorSub(vectorSize, vector1, vector2);
						// prints out difference of vectors
						printOperation("-", vector1, vector2, result);
						
					} 
				} else if (choice == 3) {
					double magnitude = vectorMag(vectorSize, vector1);
					// prints out magnitude
					System.out.println("The magnitude is: " + magnitude);
					input.nextLine();
					continue; //FIX WHATEVER THIS IS :(
				}
			}
			else if (choice == 9) {
				// Will stop the program
				keepRunning = false;
				System.out.println("Goodbye!");

			}
		}
		// closes the Scanner object to avoid resource leaks
		input.close();
	}

	private static double[] vectorSum(int size, double[] vector1, double[] vector2) {
		double sum[] = new double[size];
		// will calculate sum of both arrays and store in sub array
		for (int i = 0; i < size; i++) {
			sum[i] = vector1[i] + vector2[i];
		}
		return sum;
	}

	private static double[] vectorSub(int size, double[] vector1, double[] vector2) {
		double sub[] = new double[size];
		// will calculate difference of both arrays and store in sub array
		for (int i = 0; i < size; i++) {
			sub[i] = vector1[i] - vector2[i];
		}
		return sub;
	}

	private static double vectorMag(int size, double[] vector) {
		double vectorSquared = 0;
		
		for (int i = 0; i < size; i++) {
			// should square all elements within array and add them
			vectorSquared += Math.pow(vector[i], 2);
		}
		
		return Math.sqrt(vectorSquared);
	}

	private static void printOperation(String operator, double[] vector1, double[] vector2, double[] result) {
		for (int i = 0; i < vector1.length; i++) {
			System.out.println(vector1[i]);
		}
		System.out.println(operator);
		for (int i = 0; i < vector2.length; i++) {
			System.out.println(vector2[i]);
		}
		System.out.println("=");

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
