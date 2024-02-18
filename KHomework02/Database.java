//Kevin Do
public class Database {
	
	private String name;
	private String console;
	
	public Database()
	{
		this.name = "none";
		this.console = "none";
	}
	
	public Database(String aName, String aConsole)
	{
		this.setName(aName);
		this.setConsole(aConsole);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getConsole()
	{
		return this.console;
	}
	
	public void setName(String aName)
	{
		if(aName != null)
			this.name = aName;
		else
			this.name = "none";
	}
	
	public void setConsole(String aConsole)
	{
		if(aConsole != null)
			this.console = aConsole;
		else 
			this.console = "none";
	}
	
	public String toString()
	{
		return "Name: " + this.name+ " Console: " + this.console;
	}
	public boolean equals(Database aDatabase)
	{
		return aDatabase != null &&
				this.name.equals(aDatabase.getName()) &&
				this.console.equals(aDatabase.getConsole());
	}
}



