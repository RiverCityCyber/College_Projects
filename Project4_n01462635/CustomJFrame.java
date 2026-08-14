/**
 * Author:    Connor Geller
 * CustomJFrame sets a custom frame and initializes
 * all the needed variables, most set to private
 * This is where the JFrame is actually created
 * and user input is able to be retrieved
 * The methods for clearing and submitting answers
 * are also within this class
 * There is a nested class for clearing and submitting answers
 * called InnerActionListener
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class CustomJFrame extends JFrame {
	//lots of labels and variables lol
	private JLabel headingLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel phoneNumberLabel;
	private JLabel emailLabel;
	private JLabel dietaryLabel;
	private JLabel genderLabel;
	private JLabel waterLabel;
	private JLabel mealsLabel;
	private JLabel checkBoxLabel;
	private JLabel walkLabel;
	private JLabel weightLabel;

	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField emailTextField;

	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JRadioButton preferRadioButton;
	private ButtonGroup radioButtonGroup;

	private JSpinner waterIntakeSpinner;
	private JSlider mealSlider;
	private JCheckBox wheatCheckBox;
	private JCheckBox sugarCheckBox;
	private JCheckBox dairyCheckBox;
	private JComboBox<String> walkComboBox;

	private String[] walkOptions = { "Less than 1 Mile", "More than 1 mile but less than 2 miles",
			"More than 2 miles but less than 3 miles", "More than 3 miles" };

	private JFormattedTextField weightFormattedTextField;
	private JButton clearButton;
	private JButton submitButton;

	private FileHandler fileHandler;
	private GridBagConstraints gridBagC;
	/**
	 * using gridBagLayout, CustomJFrame sets
	 * four text fields, three radio buttons within one
	 * button group, a JSpinner, a JSlider, three checkboxes,
	 * a JComboBox, and a JFormattedTextField
	 * there are accompanying titles for all of these
	 */
	public CustomJFrame() {
		//Everything is initialized here as per Project4 requirements
		headingLabel = new JLabel("Personal Information");
		firstNameLabel = new JLabel("First Name:");
		lastNameLabel = new JLabel("Last Name:");
		phoneNumberLabel = new JLabel("Phone Number:");
		emailLabel = new JLabel("Email:");
		dietaryLabel = new JLabel("Dietary Questions");
		genderLabel = new JLabel("Sex:");
		waterLabel = new JLabel("How many cups of water on average do you drink a day?");
		mealsLabel = new JLabel("How many meals on average do you eat a day?");
		checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
		walkLabel = new JLabel("On average how many miles do you walk in a day?");
		weightLabel = new JLabel("How much do you weigh?");
		
		firstNameTextField = new JTextField("", 20);
		lastNameTextField = new JTextField("", 20);
		phoneNumberTextField = new JTextField("", 20);
		emailTextField = new JTextField("", 20);
		
		fileHandler = new FileHandler();
		gridBagC = new GridBagConstraints();

		setTitle("Dietary Survey");
		setSize(500, 700);

		setLayout(new GridBagLayout());//

		gridBagC.insets = new Insets(2, 2, 2, 2);

		gridBagC.gridx = 0;// column 0
		gridBagC.gridy = 0;// row 0
		gridBagC.ipadx = 5;
		gridBagC.ipady = 5;
		this.add(headingLabel);
		//start of the name text field stuff
		addLabel(1, 0, firstNameLabel);
		gridBagC.gridx = 1;
		this.add(firstNameTextField, gridBagC);

		addLabel(2, 0, lastNameLabel);
		gridBagC.gridx = 1;
		this.add(lastNameTextField, gridBagC);

		addLabel(3, 0, phoneNumberLabel);
		gridBagC.gridx = 1;
		this.add(phoneNumberTextField, gridBagC);

		addLabel(4, 0, emailLabel);
		gridBagC.gridx = 1;
		this.add(emailTextField, gridBagC);
		//start of gender radio buttons
		addLabel(5, 0, genderLabel);
		gridBagC.anchor = GridBagConstraints.NORTHWEST;
		maleRadioButton = new JRadioButton("Male");
		femaleRadioButton = new JRadioButton("Female");
		preferRadioButton = new JRadioButton("Prefer not to say");
		radioButtonGroup = new ButtonGroup();
		//sets the action command so the buttons can return stuff
		gridBagC.insets = new Insets(1, 1, 1, 1);
		gridBagC.ipady = 0;
		maleRadioButton.setActionCommand("Male");
		femaleRadioButton.setActionCommand("Female");
		preferRadioButton.setActionCommand("Prefer not to say");

		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);
		//add radio buttons to frame
		addRadioButton(5, 1, maleRadioButton);
		addRadioButton(6, 1, femaleRadioButton);
		addRadioButton(7, 1, preferRadioButton);
		//ipady set to 5 for spacing
		gridBagC.insets = new Insets(4, 4, 4, 4);
		gridBagC.ipady = 5;
		addLabel(8, 0, dietaryLabel);
		gridBagC.gridwidth = 3;
		gridBagC.anchor = GridBagConstraints.CENTER;
		//start of jSpinner stuff
		addLabel(9, 0, waterLabel);
		waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 50, 1));
		gridBagC.gridy = 10;
		this.add(waterIntakeSpinner, gridBagC);
		//start of jSlider stuff
		addLabel(11, 0, mealsLabel);
		mealSlider = new JSlider(0, 10, 3);
		gridBagC.gridy = 12;
		mealSlider.setPaintTicks(true);
		mealSlider.setSnapToTicks(true);
		mealSlider.setPaintLabels(true);
		mealSlider.setMajorTickSpacing(1);
		this.add(mealSlider, gridBagC);
		//start of checkbox stuff
		addLabel(13, 0, checkBoxLabel);
		wheatCheckBox = new JCheckBox("Wheat");
		sugarCheckBox = new JCheckBox("Sugar");
		dairyCheckBox = new JCheckBox("Dairy");

		// dairyCheckBox
		gridBagC.anchor = GridBagConstraints.NORTHEAST;
		gridBagC.gridwidth = 1;
		gridBagC.gridy = 14;
		gridBagC.gridx = 0;
		this.add(dairyCheckBox, gridBagC);
		// wheatCheckBox
		gridBagC.anchor = GridBagConstraints.NORTHWEST;
		gridBagC.gridx = 1;
		this.add(wheatCheckBox, gridBagC);
		// sugarCheckBox
		gridBagC.gridx = 1;
		gridBagC.anchor = GridBagConstraints.CENTER;
		this.add(sugarCheckBox, gridBagC);
		//start of comboBox for walking
		gridBagC.gridwidth = 3;
		addLabel(15, 0, walkLabel);
		gridBagC.gridy = 16;
		gridBagC.gridx = 0;
		walkComboBox = new JComboBox<String>(walkOptions);
		this.add(walkComboBox, gridBagC);
		addLabel(17, 0, weightLabel);
		//start of the weight FormattedTextField
		gridBagC.gridy = 18;
		gridBagC.gridx = 0;
		NumberFormat numForm = NumberFormat.getNumberInstance();
		weightFormattedTextField = new JFormattedTextField(numForm);

		weightFormattedTextField.setColumns(15);
		this.add(weightFormattedTextField, gridBagC);
		//start of the JButtons for clear & submit
		clearButton = new JButton("Clear");
		submitButton = new JButton("Submit");

		submitButton.setName("Submit");
		clearButton.setName("Clear");
		//actionListener allows interaction
		InnerActionListener listener = new InnerActionListener();

		clearButton.addActionListener(listener);
		submitButton.addActionListener(listener);

		gridBagC.gridy = 19;
		gridBagC.gridx = 0;
		gridBagC.anchor = GridBagConstraints.NORTHWEST;
		this.add(clearButton, gridBagC);
		gridBagC.gridy = 19;
		gridBagC.gridx = 1;
		gridBagC.anchor = GridBagConstraints.NORTHEAST;
		this.add(submitButton, gridBagC);
		//when the program is X-ed out of, then it closes the printWriter
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent k) {
				fileHandler.closePrintWriter();
			}
		});
	}//end of CustomJFrame method
	/**THIS IS A NESTED CLASS
	 * InnerActionListener implements the ActionListener
	 * and is used to get the input from the GUI from user
	 * If user does not put in anything, it should 
	 * provide null for Sex and weight, default for 
	 * the slider and spinner, false for checkboxes, 
	 * and remain empty for everything else.
	 * After the submit button is pressed, the info should
	 * be passed to the fileWriter with writeResults method
	 * and all fields should be reset to default.
	 * if clear is pressed, all fields should be
	 * reset to default.
	 */
	class InnerActionListener implements ActionListener {
		/**
		 * actionPerformed is called when the
		 * submit or clear buttons are pressed
		 * it submits all the data from the input
		 * fields to the fileHandler.writeResults method
		 */
		public void actionPerformed(ActionEvent e) {
			//formatting for date time
			LocalDateTime dateObj = LocalDateTime.now();
			DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			String date = dateObj.format(formatDate);

			JButton button = (JButton) e.getSource();
			String name = button.getName();
			String textFieldVal = date + ",";
			if(name.equals("Submit")) {
				/*adding everything to string so that
				it can be sent to fileHandler.writeResults*/
				textFieldVal += firstNameTextField.getText() + ",";
				textFieldVal += lastNameTextField.getText() + ",";
				textFieldVal += phoneNumberTextField.getText() + ",";
				textFieldVal += emailTextField.getText() + ",";
				try {//try catch for when none of the buttons are selected
					textFieldVal += radioButtonGroup.getSelection().getActionCommand() + ",";
				} catch (NullPointerException f) {
					textFieldVal+= "null,";
				}
				textFieldVal += waterIntakeSpinner.getValue() + ",";
				textFieldVal += mealSlider.getValue() + ",";
				textFieldVal += wheatCheckBox.isSelected() + ",";
				textFieldVal += sugarCheckBox.isSelected() + ",";
				textFieldVal += dairyCheckBox.isSelected() + ",";
				textFieldVal += walkComboBox.getSelectedItem() + ",";
				/* the if statement is for when weightField is left empty
				 * IMPORTANT NOTE: if the inputted weight exceeds 999
				 * then the program automatically formats as "A,AAA"
				 * which causes it to be read as to different CSV values
				 * HOWEVER, this will most likely not be a problem as
				 * a weight exceeding 999 is unrealistic
				 */
				if (!weightFormattedTextField.getText().toString().equals("")) {
					textFieldVal += weightFormattedTextField.getText().toString() + ",";
				} else {
					textFieldVal += "null,";
				}
				fileHandler.writeResults(textFieldVal);
				clearForm();
			}else {
				clearForm();
			}
		}// end actionPerformed
		/**
		 * clearForm() sets all the input fields
		 * back to their defaults and deselects
		 * any boxes/buttons chosen
		 */
		private void clearForm() {
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			phoneNumberTextField.setText("");
			emailTextField.setText("");
			radioButtonGroup.clearSelection();
			waterIntakeSpinner.setValue(15);
			mealSlider.setValue(3);
			wheatCheckBox.setSelected(false);
			sugarCheckBox.setSelected(false);
			dairyCheckBox.setSelected(false);
			walkComboBox.setSelectedIndex(0);
			weightFormattedTextField.setValue(null);
		}
	}// end InnerClickListener
	/**
	 * addLabel is the method used to add labels, it was 
	 * made for convenience since there were lots of labels
	 * @param row
	 * @param column
	 * @param label
	 */
	public void addLabel(int row, int column, JLabel label) {
		gridBagC.gridx = column;
		gridBagC.gridy = row;
		this.add(label, gridBagC);
	}
	/**
	 * addRadioButton adds a radio button, it is used
	 * for convenience and to reduce repeated code
	 * @param row
	 * @param column
	 * @param button
	 */
	public void addRadioButton(int row, int column, JRadioButton button) {
		gridBagC.gridx = column;
		gridBagC.gridy = row;
		this.add(button, gridBagC);
	}

}
