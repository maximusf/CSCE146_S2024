/*
 * Written by Maximus Fernandez
 * 1/29/2024
 * Leetcode #1: Two Sum
 * Two numbers of the array should sum up to the target
 * There is only ONE answer for the array (no edge-cases)
 */

//Note: have not added any error messages

import java.util.Scanner;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        for(int i=0; i<nums.length-1; i++)
        {
            for (int j=i+1; j<nums.length; j++)
            {
                if(nums[i] + nums[j] == target){
                ans[0] = i;
                ans[1] = j;
                return ans;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
    	System.out.println("Welcome to TwoSum.");
    	Scanner keyboard = new Scanner(System.in);
		boolean running = true;
		
    	while(running) {
			userIO(keyboard);
			System.out.println();
			System.out.println("Would you like to try again? (Y/N)");
			String retry = keyboard.nextLine();

			
			if (retry.equalsIgnoreCase("Y")) {
				continue;
			}
			else
			{
				running = false;
			}
		}
		
		
		keyboard.close();
	}
    
    public static void userIO(Scanner input) {
    	System.out.println();
		System.out.println("Enter the size of your array");
		int size = input.nextInt();
		input.nextLine();
		System.out.println("Enter the values of your array");
		int arr[] = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = input.nextInt();
		}
		System.out.println("Now, enter the target");
		int target = input.nextInt();
		input.nextLine();
		int results[] = twoSum(arr, target);
		System.out.println("The two numbers within the array that add up to "+target+" are:");
		System.out.println("["+results[0]+","+results[1]+"]");
		
    }
    
    //Tests:
  		//size: 4 / 3
  		//nums: 2,7,11,15 / 3,2,4
  		//target = 9 / 6
  		//output = [0,1] / [1,2]
  		
    
}