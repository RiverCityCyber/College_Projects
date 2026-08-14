/**
 * Author:    Connor Geller
 * FileHandler is used to create the output file
 * and is used to initialize the header with
 * the object method call
 */
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileHandler {

	private String surveyFile = "survey_results.csv";
	//private FileWriter fileOutput = new FileWriter(surveyFile);
	private PrintWriter printWriter;
	/**
	 * FileHandler initializes the output file
	 * and generates the titles for the columns
	 */
	public FileHandler() {
		try {
		printWriter  = new PrintWriter(surveyFile);
		printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,"
				+ "Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
		} catch (FileNotFoundException fnfe) {
			System.out.println("File Not Found Exception");
		}
	}
	/**
	 * writeResults is used to write the 
	 * string surveyData to the output file
	 * @param surveyData
	 */
	public void writeResults(String surveyData) {
		printWriter.println(surveyData);
	}
	/**
	 * closePrintWriter was created so that the 
	 * printWriter can be closed when GUI is closed
	 * gets called at end of CustomJFrame method
	 */
	public void closePrintWriter() {
		printWriter.close();
	}
}
