package exam;

// imports required for the application
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Application extends JFrame {

	// declare the text fields required to input the data
    private JTextField yearField = new JTextField();
    private JTextField monthField = new JTextField();
    private JTextField vatReferenceField = new JTextField();
    private JTextField goodsField = new JTextField();
    
    // declare the labels required
    private JLabel yearLabel = new JLabel("Year (2020 to 2050)");
    private JLabel monthLabel = new JLabel("Month (1 to 12)");
    private JLabel vatReferenceLabel = new JLabel("VAT Reference (Minimum of 10 characters)");
    private JLabel goodsLabel = new JLabel("Goods Amount");
    
    // declare the fonts used
    private Font inputFont = new Font("Dialog", Font.PLAIN, 12);
    private Font titleFont = new Font("Dialog", Font.BOLD, 12);

    // declare a check box for the PVAT
    private JCheckBox vatCheckBox = new JCheckBox("Postponed VAT Accounting Required");
    
    // declare a buttons panel
    private JPanel buttonsPanel = new JPanel(new FlowLayout());
    
    // declare the two buttons required
    private JButton saveButton = new JButton("Save");
    private JButton cancelButton = new JButton("Cancel");
    
    // declare the borders needed to show valid/invalid input
	private Border invalidBorder = BorderFactory.createLineBorder(Color.RED, 1);
	private Border defaultBorder = BorderFactory.createEmptyBorder();

    // constructor for the VAT application
    public Application() {
    	
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

        // set the properties of the year label and input
        this.yearField.addKeyListener(inputKeyListener);
        this.yearField.setFont(inputFont);
        this.yearLabel.setFont(titleFont);
        this.add(yearLabel);
        this.add(yearField);
        
        // set the properties of the month input
        this.monthField.addKeyListener(inputKeyListener);
        this.monthField.setFont(inputFont);
        this.monthLabel.setFont(titleFont);
        this.add(monthLabel);
        this.add(monthField);

        // set the properties of the PVAT check box       
        this.vatCheckBox.setSelected(true);
        this.vatCheckBox.addItemListener(new PVATCheckBoxItemListener());
        this.add(new JLabel());
        this.add(vatCheckBox);

        // 4th row would be the tax reference number
        this.vatReferenceField.addKeyListener(inputKeyListener);
        this.vatReferenceField.setFont(inputFont);
        this.vatReferenceLabel.setFont(titleFont);
        this.add(vatReferenceLabel);
        this.add(vatReferenceField);

        // 5th row would be the merchandise amount
        this.goodsField.addKeyListener(inputKeyListener);
        this.goodsField.setFont(inputFont);
        this.goodsLabel.setFont(titleFont);
        this.add(goodsLabel);
        this.add(goodsField);
        
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
            int year = Integer.parseInt(this.yearField.getText().trim());

            // if the year is out with the bounds
            if (year < 2020 || year > 2050) {
            	
            	// set the border of the box to red
            	this.yearField.setBorder(invalidBorder);
            	
            	// throw an exception
                throw new Exception();
                
            } else {
            	
            	// set the border back to the default
            	this.yearField.setBorder(defaultBorder);
            }
            
          // handled the exception 
        } catch (Exception e) {
        	
        	// set the border of the box to red
        	this.yearField.setBorder(invalidBorder);
        	
            // Validation failed
            return;
        }

        // try to validate the month
        try {
        	
            int month = Integer.parseInt(this.monthField.getText().trim());

            if (month < 1 || month > 12) {
            	
            	// set the border of the box to red
            	this.monthField.setBorder(this.invalidBorder);
            	
                throw new Exception();
                
            } else {
            	
            	// set the border back to the default
            	this.monthField.setBorder(this.defaultBorder);
            	
            }
            
        } catch (Exception e) {
        	
        	// set the border of the box to red
        	this.monthField.setBorder(this.invalidBorder);
        	
            // Validation failed
            return;
        }

        // if the VAT check box is selected
        if (this.vatCheckBox.isSelected()) {
        	
        	// validate the VAT reference
            if (this.vatReferenceField.getText().trim().length() < 10) {
            	
            	// set the border of the box to red
            	this.vatReferenceField.setBorder(this.invalidBorder);
            	
                
                return;
                
            } else {
            	
            	this.vatReferenceField.setBorder(this.defaultBorder);
            	
            }
            
            // validate the goods amount
            try {
            	
            	// parse the string as a double
                Double.parseDouble(this.goodsField.getText().trim());
                
                // set the border back to the default
                this.goodsField.setBorder(this.defaultBorder);
                
            // 
            } catch (Exception e) {
            	
                
            	// set the border of the box to red
            	this.goodsField.setBorder(this.invalidBorder);
            	
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
        	
        	// call the validate fields method
            validateInput();
        }

    }
    
    // a class that is an event handler for the PVAT check box
    private class PVATCheckBoxItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
        	
        	// if the VAT check box is selected
        	if (vatCheckBox.isSelected()) {
        		
        		// enable the VAT reference field
            	vatReferenceField.setBackground(Color.WHITE);
                vatReferenceField.setText("");
                vatReferenceField.setEditable(true);
                vatReferenceField.setEnabled(vatCheckBox.isSelected());
                validateInput();
                
                // enable the goods
                goodsField.setBackground(Color.WHITE);
                goodsField.setEditable(true);
                goodsField.setText("");
                goodsField.setEnabled(vatCheckBox.isSelected());
                validateInput();
        		
        	// otherwise
        	} else {
        		// grey out the fields
        		vatReferenceField.setBackground(Color.gray);
        		vatReferenceField.setText("");
        		vatReferenceField.setEditable(false);
        		vatReferenceField.setBorder(defaultBorder);
        		
        		goodsField.setBackground(Color.gray);
        		goodsField.setText("");
        		goodsField.setEditable(false);
        		goodsField.setBorder(defaultBorder);
        		
        	}
           
            
        }
    }
    
    // a class that is event handler for the cancel button
    private class CancelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	// if the user wants to quit the application
            if (JOptionPane.showConfirmDialog(Application.this, "Are you sure you want to exit?") == JOptionPane.YES_OPTION) {
                
            	// exit the application
            	System.exit(0);
            }
        }
    }
    
    // a class that is an event handler for the save button
    private class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	// if the user does not want to save the data
            if (JOptionPane.showConfirmDialog(Application.this, "Are you sure you want to save this VAT information?") != JOptionPane.YES_OPTION) {
                
            	// close the dialog box
            	return;
               
            // otherwise
            } else {

	            // try to open a file
	            try {
	            	
	            	// create a print writer object with the output file
	                PrintWriter fileOut = new PrintWriter(new FileWriter("/Users/martinhanna/Downloads/pvaData.txt", true));
	
	                // print the year
	                fileOut.println("Year: " + yearField.getText().trim());
	                
	                // print the month
	                fileOut.println("Month: " + monthField.getText().trim());
	
	                // the vat check box is selected
	                if (vatCheckBox.isSelected()) {
	                	
	                	// also print the vat reference number and the goods amount
	                    fileOut.println("VAT Reference Number: " + vatReferenceField.getText().trim());
	                    fileOut.println("Goods Amount: " + goodsField.getText().trim());
	                    
	                }
	
	                // print a space
	                fileOut.println();
	                
	                // close the output file
	                fileOut.close();
	                
	                // give user information that the 
	                JOptionPane.showMessageDialog(Application.this, "VAT information appended and saved to pvaData.txt file.");
	
	                // clear all of the input fields
	                yearField.setText("");
	                monthField.setText("");
	                vatReferenceField.setText("");
	                goodsField.setText("");
	                
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
        Application app = new Application();
        
        // set the VAT application to visible
        app.setVisible(true);
    }
}