
public class Taco {
	private String name;
	private String location;
	private double price;
	public Taco()
	{
		this.name = this.location = "none";
		this.price = 0.0;
	}
	public Taco(String aName, String aLocation, double aPrice)
	{
		this.setName(aName);
		this.setLocation(aLocation);
		this.setPrice(aPrice);
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String aLocation) {
		if (aLocation != null)
			this.location = aLocation;
		else
			this.location = "none";
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double aPrice) {
		if (aPrice >= 0.0)
			this.price = aPrice;
		else
			this.price = 0.0;
	}
	public boolean equals(Taco aTaco)
	{
		return aTaco != null &&
				this.name.equals(aTaco.getName()) &&
				this.location.equals(aTaco.getLocation()) &&
				this.price == aTaco.getPrice();
	}
	public String toString() {
		return "Name: "+this.name+" Location: "+this.location+" Price $"+this.price;
	}
	
}
