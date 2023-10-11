import java.awt.Color;
		import java.awt.Font;
		import java.awt.GridBagConstraints;
		import java.awt.GridBagLayout;
		import java.awt.GridLayout;
		import java.awt.Insets;
		import java.awt.event.ActionEvent;
		import java.text.NumberFormat;
		import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;
		import java.io.IOException;

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
		import javax.swing.SpinnerModel;
		import javax.swing.SpinnerNumberModel;

		
		
		/**
		* The class Custom J frame extends J frame
		* declares all components used in dietary GUI
		*/ 
		public class CustomJFrame extends JFrame{

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

			private NumberFormat numberFormatter = NumberFormat.getNumberInstance();
			private JFormattedTextField weightFormattedTextField;

			private JComboBox <String> walkComboBox;
			private String [] walkOptions = {"Less than 1 Mile" , "More than 1 Mile but less than 2 miles","More than 2 miles but less than 3 miles"
					,"More than 3 miles"};

			private JButton clearButton,submitButton;

			private FileHandler fileHandler;

			/** 
			 *
			 * Custom J frame
			 *initializes,configures, and adds GUI class components to frame using GridBagLayout manager
			 * @return 	public
			 */

			public CustomJFrame()
			{
				InnerActionListener listener = new InnerActionListener();
				//initializing frame to store components
				//setting title of frame
				this.setTitle("Dietary Survey Form");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//setting layout being used to GridBagLayout
				this.setLayout(new GridBagLayout());
				GridBagConstraints layoutManager = new GridBagConstraints();
				//padding for frame
				layoutManager.insets = new Insets(5,1,5,1);

				//heading label
				headingLabel = new JLabel();
				//setting text for heading label
				headingLabel.setText("Personal Information");
				//first name label
				firstNameLabel = new JLabel("First Name");
				//setting text for first name label
				firstNameTextField = new JTextField("",15);
				//last name label
				lastNameLabel = new JLabel();
				//setting text for last name label
				lastNameLabel.setText("Last Name:");
				lastNameTextField = new JTextField(15);
				//phone number label
				phoneNumberLabel = new JLabel("Phone Number");
				//setting text for phone number label
				phoneNumberLabel.setText("Phone Number:");
				phoneNumberTextField = new JTextField(15);
				//email label
				emailLabel = new JLabel();
				//setting text for email label
				emailLabel.setText("Email:");
				emailTextField = new JTextField(15);
				//dietary label
				dietaryLabel = new JLabel();
				//seting text for dietary label
				dietaryLabel.setText("Dietary Questions");
				//gender label
				genderLabel = new JLabel();
				//setting text for gender label
				genderLabel.setText("Sex:");
				//water label
				waterLabel = new JLabel();
				//setting text for water label
				waterLabel.setText("How many cups of water on average do you drink a day?");
				//meals label
				mealsLabel = new JLabel();
				mealsLabel.setText("How many meals on average do you eat a day?");
				//checkbox label
				checkBoxLabel = new JLabel();
				checkBoxLabel.setText("Do any of these meals regularly contain:");
				//walk label
				walkLabel = new JLabel();
				walkLabel.setText("On average how many miles do you walk in a day");
				//weight label
				weightLabel = new JLabel();
				weightLabel.setText("How much do you weigh?");

				//radio buttons
				maleRadioButton = new JRadioButton("Male");
				femaleRadioButton = new JRadioButton("Female");
				preferRadioButton = new JRadioButton("Prefer not to say");
				preferRadioButton.setName("null");
				//initializing button group and adding buttons
				radioButtonGroup = new ButtonGroup();
				radioButtonGroup.add(maleRadioButton);
				radioButtonGroup.add(femaleRadioButton);
				radioButtonGroup.add(preferRadioButton);

				waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15,0,50,1));
				//waterIntakeSpinner.setBounds(70,70,50,40);
				//initializing min max default variables for JSlider with tick settings
				int min = 0;
				int max = 10;
				int df = 3;
				mealSlider = new JSlider(JSlider.HORIZONTAL,min,max,df);
				mealSlider.setMajorTickSpacing(1);
				mealSlider.setPaintLabels(true);
				mealSlider.setPaintTicks(true);
				mealSlider.setPaintTrack(true);
				
				//initializes checkboxes
				wheatCheckBox = new JCheckBox("Wheat");
				wheatCheckBox.setBounds(100,100,50,50);
				sugarCheckBox = new JCheckBox("Sugar");
				sugarCheckBox.setBounds(100, 150, 50, 50);
				dairyCheckBox = new JCheckBox("Dairy");
				dairyCheckBox.setBounds(100,200,50,50);
				
				//initalizes combo box
				walkComboBox = new JComboBox<String>(walkOptions);
				walkComboBox.setBounds(50, 50,90,20);    
				walkComboBox.setSelectedIndex(0);
				
				//initializes submit and clear buttons
				submitButton = new JButton("Submit");
				submitButton.setName("Submit");
				submitButton.setBackground(Color.GREEN);
				submitButton.setOpaque(true);
				//Initializing action listener to check button pressed
				submitButton.addActionListener(listener);

				clearButton = new JButton("Clear");
				clearButton.setName("Clear");
				clearButton.setBackground(Color.YELLOW);
				clearButton.setOpaque(true);
				clearButton.addActionListener(listener);

				//formatting text field to only take numbers
				weightFormattedTextField = new JFormattedTextField(numberFormatter);
				weightFormattedTextField.setColumns(15);

				this.setSize(300,400);
				layoutManager.gridx = 0;
				layoutManager.gridy = 0;

				this.add(headingLabel,layoutManager);
				layoutManager.gridy = 2;//move down 2 rows

				layoutManager.gridx = 0;
				layoutManager.gridy = 1;//down 1
				this.add(firstNameLabel,layoutManager);
				layoutManager.gridx = 1;
				layoutManager.gridy = 1;
				this.add(firstNameTextField,layoutManager);

				layoutManager.gridx = 0;
				layoutManager.gridy = 2;//down 2
				this.add(lastNameLabel,layoutManager);
				layoutManager.gridx = 1;
				layoutManager.gridy = 2;
				this.add(lastNameTextField,layoutManager);

				layoutManager.gridx = 0;
				layoutManager.gridy = 4;//down 3
				this.add(phoneNumberLabel,layoutManager);
				layoutManager.gridx = 1;
				layoutManager.gridy = 4;//down 4
				this.add(phoneNumberTextField,layoutManager);

				layoutManager.gridx = 0;
				layoutManager.gridy = 5;//down 5
				this.add(emailLabel,layoutManager);
				layoutManager.gridx = 1;
				layoutManager.gridy = 5;
				this.add(emailTextField,layoutManager);

				layoutManager.gridx = 0;
				layoutManager.gridy = 6;//down 6
				this.add(genderLabel,layoutManager);
				layoutManager.gridx = 1;
				this.add(maleRadioButton,layoutManager);
				layoutManager.gridx = 1;
				layoutManager.gridy = 7;//down 7
				this.add(femaleRadioButton,layoutManager);
				layoutManager.gridx = 1;
				layoutManager.gridy = 8;//down 8
				this.add(preferRadioButton,layoutManager);
				
				layoutManager.gridx = 0;
				layoutManager.gridy = 9;//down 9
				this.add(dietaryLabel,layoutManager);
				
				layoutManager.gridx = 0;
				layoutManager.gridy = 10;//down 10
				layoutManager.gridwidth = 2;
				this.add(waterLabel,layoutManager);
				layoutManager.gridx = 0;
				layoutManager.gridy = 11;//down 11
				this.add(waterIntakeSpinner,layoutManager);
				
				layoutManager.gridx = 0;
				layoutManager.gridy = 12;//down 12
				this.add(mealsLabel,layoutManager);
				layoutManager.gridx = 0;
				layoutManager.gridy = 13;//down 13
				this.add(mealSlider,layoutManager);
				
				layoutManager.gridx = 0;
				layoutManager.gridy = 14;//down 14
				this.add(checkBoxLabel,layoutManager);
				layoutManager.anchor = GridBagConstraints.WEST;
				layoutManager.insets = new Insets(10, 5, 10, 10);
				layoutManager.gridy = 15;//down 15
				this.add(dairyCheckBox,layoutManager);
				layoutManager.gridx = 1;
				layoutManager.gridy = 15;//down 15
				this.add(wheatCheckBox,layoutManager);
				layoutManager.gridx =1;
				layoutManager.gridy = 15;//down 15
				layoutManager.anchor = GridBagConstraints.EAST;
				layoutManager.insets = new Insets(10, 5, 10, 10);
				this.add(sugarCheckBox,layoutManager);
				
				layoutManager.gridx = 0;
				layoutManager.gridy = 16;//down 16
				this.add(walkLabel,layoutManager);
				layoutManager.gridx = 0;
				layoutManager.gridy = 17;//down 17
				this.add(walkComboBox,layoutManager);
				
				layoutManager.gridx = 0;
				layoutManager.gridy = 18;//down 18
				layoutManager.anchor = GridBagConstraints.CENTER;
				this.add(weightLabel,layoutManager);
				layoutManager.gridx = 0;
				layoutManager.gridy = 19;//down 19
				layoutManager.anchor = GridBagConstraints.CENTER;
				this.add(weightFormattedTextField,layoutManager);
				
				layoutManager.gridx = 0;
				layoutManager.gridy = 20;//down 20
		        layoutManager.anchor = GridBagConstraints.WEST;//places clear button on the bottom left
		        layoutManager.insets = new Insets(10, 10, 10, 5);
				this.add(clearButton,layoutManager);
				
				layoutManager.gridx = 1;
		        layoutManager.gridy = 20;//down 20
		        layoutManager.anchor = GridBagConstraints.EAST;//places submit button on the bottom right
		        layoutManager.insets = new Insets(10, 5, 10, 10);
		        this.add(submitButton,layoutManager);
				
				this.pack();
				this.setVisible(true);
				
				fileHandler = new FileHandler();

			}
			/**
			 * checks buttons action
			 * 
			 *
			 */
			class InnerActionListener implements ActionListener
			{
				/** 
				 *
				 * Checks for button Action performed 
				 *
				 * @param e  the ActionEvent variable used to check for the button event. 
				 */
				
				
				public void actionPerformed(ActionEvent e)
				{
					String gradio;
					JButton button = (JButton) e.getSource();
					String name = button.getName();
					if(name.equals("Submit"))
					{
		                String dateTime = String.valueOf(java.time.LocalDateTime.now());
						String gname = firstNameTextField.getText();
						String glast = lastNameTextField.getText();
						String gphone = phoneNumberTextField.getText();
						String gemail = emailTextField.getText();
						String gwater = waterIntakeSpinner.getValue().toString();
						if (maleRadioButton.isSelected()) {
				            gradio = maleRadioButton.getText();
				        } else if (femaleRadioButton.isSelected()) {
				             gradio = femaleRadioButton.getText();
				        }else
				        {
				        	 gradio = "null";
				        }
						String gwalk = walkComboBox.getSelectedItem().toString();
						int mealval = mealSlider.getValue();
						String gmeal = Integer.toString(mealval);
						boolean gwheat = wheatCheckBox.isSelected();
						boolean gsugar = sugarCheckBox.isSelected();
						boolean gdairy = dairyCheckBox.isSelected();
						String gweight = weightFormattedTextField.getText();
						String info = dateTime + "," + gname + "," + glast + "," + gphone
								+ "," + gemail +"," + gradio + "," + gwater + "," + gmeal + ","
								+ gwheat + "," + gsugar + "," + gdairy + "," + gwalk + ","
								+ gweight + "\n";
						fileHandler.WriteResults(info);
					}else
					
					clearForm();
					
				}
				private void clearForm()
				{
					firstNameTextField.setText("");
					lastNameTextField.setText("");
					phoneNumberTextField.setText("");
					emailTextField.setText("");
					mealSlider.setValue(3);
					waterIntakeSpinner.setValue(15);
					walkComboBox.setSelectedIndex(0);
					radioButtonGroup.clearSelection();
					wheatCheckBox.setSelected(false);
					sugarCheckBox.setSelected(false);
					dairyCheckBox.setSelected(false);
					weightFormattedTextField.setText("");
				}	
			}
			/** 
			 *
			 * Resets data fields when clear button is pressed
			 *
			 */

		

	}


