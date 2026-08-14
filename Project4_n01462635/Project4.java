/*
 * Author:    Connor Geller
 * Course:    COP3503, 202310
 * Project #: 4
 * Title:     Basic GUI Survey
 * Due Date:  5/3/2023
 * 
 * Generates a GUI with 14 different input fields 
 * and 18 text/title boxes
 * When the user fills out the boxes and presses submit
 * it writes the user input to a file
 * and clears all fields
 * Pressing clear also clears all fields
 * The printWriter must be closed on program exit
 */

import javax.swing.JFrame;
/**
 * @author Connor Geller
 * This is the main method,
 * it just calls the CustomJFrame,
 * sets the default close operation,
 * packs the frame, and sets it to visible 
 */
public class Project4 {

	public static void main(String[] args) {
		CustomJFrame frame = new CustomJFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
