/*
 * Written by Maximus Fernandez
 * Sheep Shearing Scheduler
 * Due 04/05/2024 by 11:55pm
 */

public class Sheep implements Comparable<Sheep> {
    // Fields to store sheep information
    private String name;
    private int shearingTime;
    private int arrivalTime;
    
    // Default constructor 
    public Sheep() {
        this.name = "no name";
        this.shearingTime = 0;
        this.arrivalTime = 0;
    }

    // Parameterized constructor
    public Sheep(String aN, int sT, int aT) {
        this.setName(aN);
        this.setShearingTime(sT);
        this.setArrivalTime(aT);
    }

    // Getter for sheep name
    public String getName() {
        return name;
    }

    // Setter for sheep name
    public void setName(String name) {
        if (name != null)
            this.name = name;
        else
            this.name = "none";
    }

    // Getter for shearing time
    public int getShearingTime() {
        return shearingTime;
    }

    // Setter for shearing time
    public void setShearingTime(int shearingTime) {
        if (shearingTime <= 0)
            this.shearingTime = 0;
        else
            this.shearingTime = shearingTime;
    }

    // Getter for arrival time
    public int getArrivalTime() {
        return arrivalTime;
    }

    // Setter for arrival time
    public void setArrivalTime(int arrivalTime) {
        if (arrivalTime <= 0)
            this.arrivalTime = 0;
        else
            this.arrivalTime = arrivalTime;
    }
    
    // Displays properties of sheep
    public String toString() {
        return "Name: "+name+
        		", Sheer Time: "+shearingTime+
        		", Arrival Time: "+arrivalTime;
    }

    // Comparison method to compare two sheep objects
	@Override
	public int compareTo(Sheep otherSheep) {
		if(this.shearingTime > otherSheep.getShearingTime())
			return 1;
		else if (this.shearingTime < otherSheep.getShearingTime())
			return -1;
		else return 0;
	}
}
