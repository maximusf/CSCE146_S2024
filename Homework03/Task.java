/*
* Written by Maximus Fernandez
* Homework 03
* Task Organizer!
* Due 02/23/2024 by 11:55PM
*/
public class Task {
	private int priority;
	private String action;

	public Task() {
		this.priority = 4;
		this.action = "none";
	}

	public Task(int aPriority, String aAction) {
		this.setPriority(aPriority);
		this.setAction(aAction);

	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int aPriority) {
		if (aPriority >= 0 && aPriority <= 4)
			this.priority = aPriority;
		else
			this.priority = 4;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String aAction) {
		if (aAction != null)
			this.action = aAction;
		else
			this.action = "none";
	}

	public boolean equals(Task aTask) {
		return aTask != null && this.priority == aTask.getPriority() && this.action.equals(aTask.getAction());
	}

	public String toString() {
		return "Priority: " + this.priority + " Action: " + this.action;
	}

}