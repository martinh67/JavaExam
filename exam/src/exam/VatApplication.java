package exam;

//imports required for the application
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;

public class VatApplication extends JFrame {

	// declare the text fields required to input the data
	private JTextField yearInput = new JTextField();
	private JTextField monthInput = new JTextField();
	private JTextField vatReferenceInput = new JTextField();
	private JTextField goodsInput = new JTextField();
 
	// declare the labels required
	private JLabel yearLabel = new JLabel("Year (2020 to 2050)");
	private JLabel monthLabel = new JLabel("Month (1 to 12)");
	private JLabel vatReferenceLabel = new JLabel("VAT Reference (Minimum of 10 characters)");
	private JLabel goodsLabel = new JLabel("Goods Amount");
 
	// declare the fonts used
	private Font inputFont = new Font("Dialog", Font.PLAIN, 12);
	private Font titleFont = new Font("Dialog", Font.BOLD, 12);
 
	// declare a check box for the PVAT
	private JCheckBox pvatCheckBox = new JCheckBox("Postponed VAT Accounting Required");
 
	// declare a buttons panel
	private JPanel buttonsPanel = new JPanel(new FlowLayout());
 
	// declare the two buttons required
	private JButton saveButton = new JButton("Save");
	private JButton cancelButton = new JButton("Cancel");
 
	// declare the borders needed to show valid/invalid input
	private Border invalidBorder = BorderFactory.createLineBorder(Color.RED, 1);
	private Border defaultBorder = BorderFactory.createEmptyBorder();

	 // constructor for the VAT application
	 public VatApplication() {
	 	
			// give information about the program	
			JOptionPane.showMessageDialog(null, "Welcome to the VAT Application\nVAT Reference and "
					+ "Goods are only required if PVAT is selected", 
					"VAT", JOptionPane.INFORMATION_MESSAGE);
	 	
		 // set the title for the VAT application
	     this.setTitle("VAT Application");
	
	     // ensure that the 'X' button of the window does not close the application
	     this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	
	     // centre the window on the screen
	     this.setLocationRelativeTo(null);
	     
	     // create a 2 column layout with labels on the left and input on the right
	     this.setLayout(new GridLayout(6, 2, 5, 5));
	     
	     // set the size of the window
	     this.setSize(700, 6 * 45);
	
	     // create a input key listener object
	     InputKeyListener inputKeyListener = new InputKeyListener();
	     
	     // set the properties of the year label
	     this.yearLabel.setFont(titleFont);
	     this.add(yearLabel);
	
	     // set the properties of the year input
	     this.yearInput.addKeyListener(inputKeyListener);
	     this.yearInput.setFont(inputFont);
	     this.add(yearInput);
	     
	     // set the properties of the month label
	     this.monthLabel.setFont(titleFont);
	     this.add(monthLabel);
	     
	     // set the properties of the month input
	     this.monthInput.addKeyListener(inputKeyListener);
	     this.monthInput.setFont(inputFont);
	     this.add(monthInput);
	     

	     // set the properties of the PVAT check box       
	     this.pvatCheckBox.setSelected(true);
	     this.pvatCheckBox.addItemListener(new PVATCheckBoxItemListener());
	     this.add(new JLabel());
	     this.add(pvatCheckBox);
	     
	     // set the properties of the VAT reference number label
	     this.vatReferenceLabel.setFont(titleFont);
	     this.add(vatReferenceLabel);
	     
	     // set the properties of the VAT reference input
	     this.vatReferenceInput.addKeyListener(inputKeyListener);
	     this.vatReferenceInput.setFont(inputFont);
	     this.add(vatReferenceInput);
	     
	     // set the properties of the goods label
	     this.goodsLabel.setFont(titleFont);
	     this.add(goodsLabel);
	     
	     // set the properties of the goods input
	     this.goodsInput.addKeyListener(inputKeyListener);
	     this.goodsInput.setFont(inputFont);
	     this.add(goodsInput);
	     
	     // add the buttons to the panel
	     this.buttonsPanel.add(saveButton);
	     this.buttonsPanel.add(cancelButton);
	
	     // add the buttons panel to the window
	     this.add(new JLabel());
	     this.add(buttonsPanel);
	
	     // disable the save button
	     this.saveButton.setEnabled(false);
	     
	     // add action listeners to both buttons
	     this.saveButton.addActionListener(new SaveButtonListener());
	     this.cancelButton.addActionListener(new CancelButtonListener());
	 }
	
	 // method to validate the user input
	 private void validateInput() {
	 	
	 	// set the saveButton to being disabled while the information is being validated
	     this.saveButton.setEnabled(false);
	
	     // try to validate the year
	     try {
	     	
	     	// parse the user input as an integers
	         int year = Integer.parseInt(this.yearInput.getText().trim());
	
	         // if the year is out with the bounds
	         if (year < 2020 || year > 2050) {
	         	
	         	// set the border of the box to red
	         	this.yearInput.setBorder(invalidBorder);
	         	
	         	// throw an exception
	             throw new Exception();
	             
	         // if the input is valid
	         } else {
	         	
	         	// set the border back to the default
	         	this.yearInput.setBorder(defaultBorder);
	         }
	         
	      // handle the exception 
	     } catch (Exception e) {
	     	
	     	// set the border of the box to red
	     	this.yearInput.setBorder(invalidBorder);
	     	
	         // return as the validation has failed
	         return;
	     }
	
	     // try to validate the month
	     try {
	     	
	    	 // create month variable for the user's input
	         int month = Integer.parseInt(this.monthInput.getText().trim());
	
	         // if the month is not valid
	         if (month < 1 || month > 12) {
	         	
	         	// set the border of the box to red
	         	this.monthInput.setBorder(this.invalidBorder);
	         	
	         	// throw an exception to handle string and doubles
	            throw new Exception();
	             
	         // if the input is valid
	         } else {
	         	
	         	// set the border back to the default
	         	this.monthInput.setBorder(this.defaultBorder);
	         	
	         }
	         
	      // catch any exceptions
	     } catch (Exception e) {
	     	
	     	// set the border of the box to red
	     	this.monthInput.setBorder(this.invalidBorder);
	     	
	     	// return as the validation has failed
	         return;
	     }
	
	     // if the VAT check box is selected
	     if (this.pvatCheckBox.isSelected()) {
	     	
	     	// validate the VAT reference
	         if (this.vatReferenceInput.getText().trim().length() < 10) {
	         	
	         	// set the border of the box to red
	         	this.vatReferenceInput.setBorder(this.invalidBorder);
	         	
	         	// return as the validation has failed
	            return;
	             
	         // if the input is valid
	         } else {
	         	
	        	// set the border to default
	         	this.vatReferenceInput.setBorder(this.defaultBorder);
	         	
	         }
	         
	         // validate the goods amount
	         try {
	         	
	         	 // parse the string as a double
	             Double.parseDouble(this.goodsInput.getText().trim());
	             
	             // set the border back to the default
	             this.goodsInput.setBorder(this.defaultBorder);
	             
	         // catch any exceptions
	         } catch (Exception e) {
	      
	         	// set the border of the box to red
	         	this.goodsInput.setBorder(this.invalidBorder);
	         	
	         	// return as the validation has failed
	             return;
	         }
	     }
	
	
	     // if all of the input is valid set the save button to enabled
	     this.saveButton.setEnabled(true);
	 }
	 
	 // a class to listen to the input from the keyboard
	 private class InputKeyListener implements KeyListener {
	
	     @Override
	     public void keyTyped(KeyEvent e) {}
	
	     @Override
	     public void keyPressed(KeyEvent e) {}
	
	     // method for key being released
	     @Override
	     public void keyReleased(KeyEvent e) {
	     	
	     	// call the validate input method
	         validateInput();
	     }
	
	 }
	 
	 // a class that is an event handler for the PVAT check box
	 private class PVATCheckBoxItemListener implements ItemListener {
	
		 // overridden method for the check box changing state
	     @Override
	     public void itemStateChanged(ItemEvent e) {
	     	
	     	// if the VAT check box is selected
	     	if (pvatCheckBox.isSelected()) {
	     		
	     		 // enable the VAT reference field
	         	 vatReferenceInput.setBackground(Color.WHITE);
	             vatReferenceInput.setText("");
	             
	             // set the field to editable
	             vatReferenceInput.setEditable(true);
	             vatReferenceInput.setEnabled(pvatCheckBox.isSelected());
	             
	             // call validate input
	             validateInput();
	             
	             // enable the goods field
	             goodsInput.setBackground(Color.WHITE);
	             
	             // set the field to editable
	             goodsInput.setEditable(true);
	             goodsInput.setText("");
	             goodsInput.setEnabled(pvatCheckBox.isSelected());
	             
	             // call validate input
	             validateInput();
	     		
	     	// otherwise
	     	} else {
	     		// grey out the vat reference field
	     		vatReferenceInput.setBackground(Color.gray);
	     		vatReferenceInput.setText("");
	     		
	     		// set the field to non-editable
	     		vatReferenceInput.setEditable(false);
	     		vatReferenceInput.setBorder(defaultBorder);
	     		
	     		goodsInput.setBackground(Color.gray);
	     		goodsInput.setText("");
	     		
	     		// set the field to non-editable
	     		goodsInput.setEditable(false);
	     		goodsInput.setBorder(defaultBorder);
	     		
	     	}
	        
	         
	     }
	 }
	 
	 // a class that is event handler for the cancel button
	 private class CancelButtonListener implements ActionListener {
	
		 // overridden method for an action performed on the cancel button
	     @Override
	     public void actionPerformed(ActionEvent e) {
	     	
	     	// if the user wants to quit the application
	         if (JOptionPane.showConfirmDialog(VatApplication.this, "Are you sure you want to exit?") == JOptionPane.YES_OPTION) {
	             
	         	// exit the application
	         	System.exit(0);
	         }
	     }
	 }
	 
	 // a class that is an event handler for the save button
	 private class SaveButtonListener implements ActionListener {
	
		 // overridden method for an action performed on the save button
	     @Override
	     public void actionPerformed(ActionEvent e) {
	     	
	     	// if the user does not want to save the data
	         if (JOptionPane.showConfirmDialog(VatApplication.this, "Are you sure you want to save this VAT information?") != JOptionPane.YES_OPTION) {
	             
	         	// close the dialog box
	         	return;
	            
	         // otherwise
	         } else {
	
		            // try to open a file
		            try {
		            	
		            	// create a print writer object with the output file
		                PrintWriter pvaDataFile = new PrintWriter(new FileWriter("/Users/martinhanna/Downloads/pvaData.txt", true));
		
		                // print the year
		                pvaDataFile.println("Year: " + yearInput.getText().trim());
		                
		                // print the month
		                pvaDataFile.println("Month: " + monthInput.getText().trim());
		
		                // the vat check box is selected
		                if (pvatCheckBox.isSelected()) {
		                	
		                	// also print the vat reference number and the goods amount
		                    pvaDataFile.println("VAT Reference Number: " + vatReferenceInput.getText().trim());
		                    pvaDataFile.println("Goods Amount: " + goodsInput.getText().trim());
		                    
		                }
		
		                // print a space
		                pvaDataFile.println();
		                
		                // close the output file
		                pvaDataFile.close();
		                
		                // give user information that the 
		                JOptionPane.showMessageDialog(VatApplication.this, "VAT information appended and saved to pvaData.txt file.");
		
		                // clear all of the input fields
		                yearInput.setText("");
		                monthInput.setText("");
		                vatReferenceInput.setText("");
		                goodsInput.setText("");
		                
		                // disable the save button
		                saveButton.setEnabled(false);
		                
		            // catch any exceptions
		            } catch (Exception p) {
		            	
		            	// 
		                p.printStackTrace(System.out);
		            }
	         
	         }
	         
	     }
	     
	
	 }
	
	 // main program entry point
	 public static void main(String[] args) {
	 	
	 	 // create new VAT application object
	     VatApplication vatApp = new VatApplication();
	     
	     // set the VAT application to visible
	     vatApp.setVisible(true);
	     
	 }
	 
	}
