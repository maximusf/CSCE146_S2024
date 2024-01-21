import javax.swing.*; //Swing packages are necessary to create GUIs

public class IntroToGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("My First GUI"); // Creates a new frame and gives the window a title

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the window close operation

		frame.setSize(300, 300); // Sets the size of the frame (length by width)

		JButton button1 = new JButton("Button 1"); // Creates button1
		JButton button2 = new JButton("Button 2"); // Creates button2

		frame.getContentPane().add(button2); // Adds button2 to pane
		frame.getContentPane().add(button1); // Adds button1 to pane

		// Adds button to content pane of frame
		frame.setVisible(true);

		/*
		 * Need to Know: Java Layout Managers (used to layout or arrange GUI Java
		 * components inside a container)
		 * 
		 * The most frequently used layout managers are:
		 * 
		 * Java BorderLayout (default for JFrame) --> places components in up to 5
		 * areas: top, bottom, left, right, and center
		 * 
		 * Java FlowLayout (default for JPanel) --> lays out components in a single row
		 * one after the other
		 * 
		 * Java GridBagLayout (most sophisticated layout) --> aligns components by
		 * placing them within a grid of cells, allowing components to span more than
		 * one cell
		 */

	}

}
