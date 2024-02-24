import java.util.Scanner;
import java.io.*;

public class TacoManager {
	// private Taco[] tacos;
	private GenLL<Taco> tacos;
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 3;
	public static final int HEADER_FIELD_AMT = 2;

	public TacoManager() {
		tacos = new GenLL<Taco>();
	}

	public void addTaco(Taco aT) {
		if (aT == null)
			return;
		tacos.add(aT);
		this.sortTacos();
	}

	public void removeTaco(String aN) {
		if (aN == null)
			return;
		// Search for the taco with the name
		tacos.reset(); // current = head
		while (tacos.hasMore()) // current != null
		{
			if (tacos.getCurrent().getName().equalsIgnoreCase(aN)) {
				tacos.removeCurrent();
				break;
			}
			tacos.gotoNext(); // current = current.link
		}
	}

	private void sortTacos() {
		// Using Bubble Sort
		/*
		 * boolean swapped = true; while (swapped == true) { swapped = false; for (int i
		 * = 0; i < tacos.length - 1; i++) { if (tacos[i] == null || tacos[i + 1] ==
		 * null) { break; } if (tacos[i].getPrice() > tacos[i + 1].getPrice()) { //SWAP
		 * Taco temp = tacos[i]; tacos[i] = tacos[i + 1]; tacos[i + 1] = temp; swapped =
		 * true; } } }
		 */
	}

	public void printTacos() {
		tacos.print();
	}

	public void writeTacoFile(String aName) {
		try {
			PrintWriter fileWriter = 
					new PrintWriter(new FileOutputStream(aName));
			// Body
			tacos.reset();
			while(tacos.hasMore())
			{
				Taco t = tacos.getCurrent();
				fileWriter.println(t.getName()+DELIM
						+t.getLocation()+DELIM+
						+t.getPrice());
				tacos.gotoNext();
			}
			fileWriter.close(); //DON'T FORGET THIS
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void readTacoFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));
			
			// Read the body
			while (fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();//Read the line
				String[] splitLines = fileLine.split(DELIM); //Split the line
				if (splitLines.length == BODY_FIELD_AMT) //Check the line
				continue;
				//Process - create a Taco and add it to the array
					String name = splitLines[0]; //String name
					String location = splitLines[1]; //String location
					double price = Double.parseDouble(splitLines[2]); //String price --> double price
					Taco aTaco = new Taco(name, location, price);
					this.addTaco(aTaco);
				}
			
			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
