/*
 * Written by Maximus Fernandez
 * Process Queue Simulator
 * Due 03/01/2024 by 11:55pm
 */

public class Process {
	// non-null string for name
	private String name;
	// completion time >= 0 that indicates
	// how long the process has until it is finished
	private double compTime;

	// Default constructor
	public Process() {
		this.name = "none";
		this.compTime = 0.0;
	}

	// Parameterized constructor
	public Process(String name, double compTime) {
		this.setName(name);
		this.setCompletionTime(compTime);
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Setter for name
	public void setName(String name) {
		if (name != null)
			this.name = name;
		else
			this.name = "none";
	}

	// Getter for compTime
	public double getCompletionTime() {
		return compTime;
	}

	// Setter for compTime
	public void setCompletionTime(double compTime) {
		if (compTime >= 0.0)
			this.compTime = compTime;
		else
			this.compTime = 0.0;
	}
	
	public String toString() {
		return "Process Name: " +name+ " Completion Time: " + compTime;
	}
}
