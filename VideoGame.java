/*
 * Written by Maximus Fernandez
 * Homework 02
 * Video Game Database!
 * Due 02/15/2024 by 11:55PM
 */
public class VideoGame {
	private String name;
	private String console;
	
	public VideoGame()
	{
		this.name = this.console = "none";
	}
	public VideoGame(String aName, String aConsole)
	{
		this.setName(aName);
		this.setConsole(aConsole);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String aName) {
		if (aName != null)
			this.name = aName;
		else
			this.name = "none";
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String aConsole) {
		if (aConsole != null)
			this.console = aConsole;
		else
			this.console = "none";
	}
	
	public boolean equals(VideoGame aGame)
	{
		return aGame != null &&
				this.name.equals(aGame.getName()) &&
				this.console.equals(aGame.getConsole());
	}
	public String toString() {
		return "Name: "+this.name+" Console: "+this.console;
	}
	
}
