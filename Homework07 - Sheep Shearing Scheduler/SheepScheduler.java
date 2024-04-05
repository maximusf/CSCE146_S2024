/*
 * Written by Maximus Fernandez
 * Sheep Shearing Scheduler
 * Due 04/05/2024 by 11:55pm
 */

import java.io.File;
import java.util.Scanner;

public class SheepScheduler {
private final String DELIM = "\t";
private final int BODY_FIELD_AMT = 3;
private MinHeap<Sheep> sheeps;	
	
	
	//Read Sheep file - seems right
	public void readSheepFile(String fileName) {
		//<<name>>\t<<shearing time>>\t<<arrival time>>\n
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			while (fileScanner.hasNextLine()) // goes through each line of the .txt file
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if (splitLines.length == BODY_FIELD_AMT) {
					// splits the lines into columns which are stored in splitLines array
					String name = splitLines[0];
					String shearingString = splitLines[1];
					String arrivalString = splitLines[2];
					int shearingTime = Integer.parseInt(shearingString);
					int arrivalTime = Integer.parseInt(arrivalString);
					// constructs aSheep
					Sheep aSheep = new Sheep(name,shearingTime,arrivalTime);
					// adds aSheep to the linked list
					this.addSheep(aSheep);
				}
			}
			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addSheep(Sheep aSheep) {
		sheeps.add(aSheep);
	}
	private void removeSheep() {
		sheeps.remove();
	}
	
	private void scheduleSheep() {
		
	}
	
	private void waitHeap() {
		
	}
	//Schedule Sheep
	//bubble up whoever gets sheared
	
	//how to solve
	//sort is first by arrival time
	//you can use the distance (start and end time)
	
	
	
	//Sheep(Wait) Heap
	
	//add sheep to heap, sort sheep heap
	
	
	//goal is to choose whichever sheep with the smallest sheering time which is also available at the time (arrival>=)
}
