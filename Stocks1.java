/*
 * Written by Maximus Fernandez
 * 1/29/2024
 * Best Time to Buy and Sell Stock
 * 
 * Figures out which day to buy and sell
 * stock such that maximum profit is earned
 * by comparing prices with their day prices[i]
 * 
 */

import java.util.Scanner;

public class Stocks1 {

	public static int maxProfit(int[] prices) {
		if (prices.length <= 1 || prices == null) {
			return 0;
		}

		int min = prices[0]; // current minimum
		int maxP = 0; // maximum profit

		for (int i = 1; i < prices.length; i++) {
			maxP = Math.max(maxP, prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		return maxP;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Best day to buy and sell Stocks");
		System.out.println();

		boolean running = true;
		while (running) {
			userIO(input);
			
			System.out.println("Would you like to try again? (Y/N)");
			if(input.nextLine().equalsIgnoreCase("Y")) {
				continue;
			} else {
				running = false;
			}
		}

		input.close();
	}

	public static void userIO(Scanner scanner) {

		System.out.print("Enter the number of prices: ");
		int n = scanner.nextInt();

		int[] prices = new int[n];

		System.out.println("Enter the prices:");

		for (int i = 0; i < n; i++) {
			prices[i] = scanner.nextInt();
		}

		System.out.println("Maximum profit: " + maxProfit(prices));

	}

}
/*
 * Test Case: Basic Example

Input: [7, 1, 5, 3, 6, 4]
Expected Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6) to achieve a maximum profit of 5.
Test Case: No Profit

Input: [7, 6, 4, 3, 1]
Expected Output: 0
Explanation: Since the prices are decreasing, there is no opportunity to make a profit.
Test Case: Prices Constant

Input: [5, 5, 5, 5, 5]
Expected Output: 0
Explanation: The prices remain constant, so there is no opportunity to make a profit.
Test Case: Random Prices

Input: [3, 8, 1, 5, 7, 4, 2, 6]
Expected Output: 5
Explanation: Buy on day 3 (price = 1) and sell on day 6 (price = 6) to achieve a maximum profit of 5.
Test Case: Single Price

Input: [10]
Expected Output: 0
Explanation: There is only one day and no opportunity to make a profit.
 */

