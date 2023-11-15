package exam;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class LittleCakeFactory {
	
	// array with customers
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	ArrayList<Cake> cakeTotal = new ArrayList<Cake>();
	
	ArrayList<Order> orderTotal = new ArrayList<Order>();
	
	// constructor for the LittleCakeFactory
	public LittleCakeFactory() {
		
		// load the customer file
		this.loadCustomerFile();
		
		// displays the menu
		this.displayMainMenu();
		
	}
	
	// method to display the menu to the user
	public void displayMainMenu() {
		
		// variable to hold the user's menu option
		int menuOption = 0;
		
		// display todays date 
		LocalDate today = LocalDate.now();
		
		// print the header
		System.out.println ("Little Cake Factory");
		System.out.println("Date: " + today + "\n");
		
		// while the user does not want to quit the application
		while (menuOption != 7) {
			
			// try
			try {
		
				// declare scanner object to take user input
				Scanner menuInput = new Scanner(System.in);
				
				// print the menu to the screen
				this.printMenuOptions();
				
				// prompt the user for the menu option
				System.out.println("\nEnter menu option: ");
				
				// take the menu option
				menuOption = menuInput.nextInt();
			
				// switch statement to obtain user's choice
				switch(menuOption) {
				
				    // if the user enters 1
					case (1):
						
						// add a new order
						this.addNewCakeOrder();
						
						// break from the switch statement
						break;
						
					 // if the user enters 1
					case (2):
							
						// add a new order
						this.addNewCustomer();
							
						// break from the switch statement
						break;
						
					// if the user enters 2
					case (3):
						
						// view orders on a specific day
						this.printOrders();
					
						// break from the switch statement
						break;
					
					// if the user enters 3
					case (4):
					
						// view the cakes for a specific day
						this.printCakes();
					
						// break from the switch statement
						break;
					
					// if the user enters 4
					case (5):
						
						// view the deliveries for a specific day
						this.printDeliveries();
						
						// break from the switch statement
						break;
						
					// if the user enters 5
					case (6):
					
						// display the customers
						this.displayCustomers();
						
						// break from the switch statement
						break;
						
					// if the user enters 5
					case (7):
						
						// on exit save the customer file
						this.saveCustomerFile();
					
						// exit the system
						System.out.println("\nExiting...");
							
						// break from the switch statement
						break;
						
					// default in case invalid input has been entered
					default:
						
						// print error message
						System.out.println("\nInvalid");
						
						// break from the switch statement
						break;
					
					}
				
				// catch any invalid input
				} catch (InputMismatchException e) {
					
					// print error message
					System.out.println("\nInvalid");
					
					
				}
				
		  }
		
	}
	
	// method to print the menu 
	public void printMenuOptions() {
		
		// view all customers
		
		// print the menu options to the console
		System.out.println("\nMain Menu\n");
		System.out.println("1. New order for an existing customer");
		System.out.println("2. Add new customer");
		System.out.println("3. View orders");
		System.out.println("4. View cakes");
		System.out.println("5. View deliveries");
		System.out.println("6. View customer list");
		System.out.println("7. Exit");
		
	}
	
	public int validCustomerNumber() {
		
		int foundCustomerNumber = 0;
		
		int flag = 0;
		
		do {
		
			// declare scanner object to take user input
			Scanner inputCustomerNumber = new Scanner(System.in);
				
			System.out.println("\nEnter the customer number: ");
				
			// variable to hold the customerNumber
			int customerNumber = inputCustomerNumber.nextInt();
				
			// loop through the customer array
			for (int i = 0; i < customerList.size(); i++) {
					
				// if the customer number is within the array
				if (customerNumber == customerList.get(i).getCustomerNumber()) {
						
					// set the customerNumber to the customerNumber needing to have the order
					foundCustomerNumber = i;
						
					flag = 1;
						
					break;
						
				} 
					
			}
			
			if (flag == 0 ) {
				
				System.out.println("\nCustomer not found\n");
			}
				
		} while(flag == 0);
		
		return foundCustomerNumber;
				
	}
	
	// method to add a new cake order
	public void addNewCakeOrder() {
		
		// variable to hold the cake option
		int cakeOption = 0;
		
		// call to the validCustomerNumber method to ensure that a valid customerNumber is obtained
		int customerNumber = this.validCustomerNumber();
		
		int choice = 0;
		
		// create new order object
		Order customerOrder = new Order();
		
		// set up menu to add a cake to the customer order
		while (choice != 2) {
			
			// print the order options
			this.printOrderOptions();
			
			// declare scanner object to take user input
			Scanner inputChoice = new Scanner(System.in);
			
			System.out.println("\nEnter your choice: ");
			
			// declare choice variable
			choice = inputChoice.nextInt();
			
			switch(choice) { 
			
				// if the user wants to add a cake to the order
				case(1):
					
					// now get the type of cake to be added to the order
					try {
						
						while(cakeOption !=4) {
						
						// declare scanner object to take user input
						Scanner cakeInput = new Scanner(System.in);
						
						// print the cake options
						this.printCakeOptions();
						
						// prompt the user for the menu option
						System.out.println("\nChoose an option: ");
						
						// take the menu option
						cakeOption = cakeInput.nextInt();
						
						// switch statement to obtain user's choice
						switch(cakeOption) {
						
							// if the user enters 1 for a cake
							case (1):
												
								// create cake object
								Cake cake = new Cake("Sponge", "Strawberry", "Circle", "Green", 1);
												
								// add to the order
								customerOrder.addCake(cake);
											
								// add the order to the customer's orders
								this.customerList.get(customerNumber).addToOrder(customerOrder);
								
								// add this to the cakes
								this.cakeTotal.add(cake);
								
								this.orderTotal.add(customerOrder);
								
								System.out.print("\nCake with no icing added to order\n");
															
								// break from the switch statement
								break;
													
							// if the user enters 2
							case (2):
													
							
								// create a new printed cake object
								PrintedCake printedCake = new PrintedCake("Sponge", "Strawberry", 
													"Circle", "Green", 2);
													
								// add this to the order
								customerOrder.addCake(printedCake);
												
								// add the order to the customer's orders
								this.customerList.get(customerNumber).addToOrder(customerOrder);
								
								this.orderTotal.add(customerOrder);
								
								System.out.print("\nPrinted Cake added to order\n");
									
								// break from the switch statement
								break;
												
							// if the user enters 3
							case (3):
							
								// create a new hand made cake object
								HandmadeCake handmadeCake = new HandmadeCake("Sponge", "Strawberry", 
										"Heart", "White", 6, "Happy Birthday");
										
													
								// add this to the order
								customerOrder.addCake(handmadeCake);
								
								// add the order to the customer's orders
								this.customerList.get(customerNumber).addToOrder(customerOrder);
								
								this.orderTotal.add(customerOrder);
								
								System.out.print("\nHandmade Cake added to order\n");
							
								// break from the switch statement
								break;
												
							// if the user enters 4
							case (4):
													
								// view the deliveries for a specific day
								System.out.println("\nReturning to Cake Options...\n");
													
								// break from the switch statement
								break;
													
							// default in case invalid input has been entered
							 default:
													
								// print error message
								System.out.println("\nInvalid");
													
								// break from the switch statement
								break;
												
							}
						
						}
									
					// catch input mismatch
					} catch (InputMismatchException e) {
						
						// print error message
						System.out.println("\nInvalid");
							
							
					}
				
					break;
			
					
				case(2):
					
						break;
								
				}
					
			}
				
	}
			
					
			
	// print the cake options to the user
	public void printCakeOptions() {
		
		// print the menu options to the console
		System.out.println("\nCake Order Menu\n");
		System.out.println("1. Add Cake (no iceing) to order");
		System.out.println("2. Add Printed cake to order");
		System.out.println("3. Add Handmade cake to order");
		System.out.println("4. Return to Cake Menu");
		
		
	}
	
	// print the orders for a specific day
	public void printOrders() {
		
		// if the system does not have any orders
		if (orderTotal.isEmpty()) {
			
			// inform the user
			System.out.println("No orders in the system");
			
		// if there are orders in the system
		} else {
		
			// try
			try {
				
				// scanner object for the day input
				Scanner dayInput = new Scanner(System.in);
				
				// prompt the user for the day they want to look through
				System.out.println("\nEnter the day for the orders (yyyy-mm-dd): ");
				
				// take the day in as string
				String dayString = dayInput.next();
				
				LocalDate newUserDate = LocalDate.parse(dayString);
				
				// for all of the customer orders
				for (int i = 0; i < orderTotal.size(); i++) {
					
					// if there are no orders
					if (orderTotal.get(i).getCakes().isEmpty()) {
							
							// continue on
							continue;
						
						} 
					
					// if there user date matches the order date
					else if (newUserDate.compareTo(orderTotal.get(i).getOrderDate()) == 0) {
						
						// print the details of the order
						System.out.println("Order Number: " + orderTotal.get(i).getOrderNumber());
						System.out.println("Order Cost: €" + orderTotal.get(i).calculateTotalOrder());
						System.out.println("\n");
						orderTotal.get(i).displayCakes();
						
					// if there are no orders for that day
					} else {
						
						System.out.println("\nNo orders for that day");
						
					}
				}
		
			// catch input mismatches
			} catch (InputMismatchException e) {
				
				// print error message
				System.out.println("\nInvalid");
				
				
			}
		
		}
			
		
	}
	
	// method to load the customer text file
	public void loadCustomerFile() {
		
		// try
		try {
			
			// read in the file
			BufferedReader customerFile = new BufferedReader(new FileReader("/Users/martinhanna/Downloads/customers.txt"));
			
			// declare a string to hold the line of a file
			String line;
			
			// while the file has lines in the file
			while ( (line = customerFile.readLine()) != null) {
				
				// declare a string array to hold the line
				String[] vals = line.split(",");
				
				// assign the variables to the relevant position within vals array
				int customerNumber = Integer.parseInt(vals[0]);
				
				String firstName = vals[1];
				
				String lastName = vals[2];
				
				String address = vals[3];
				
				String phoneNumber = vals[4];
				
				String email = vals[5];
				
				// create the customer object
				Customer customer = new Customer(customerNumber, firstName, 
						lastName, address, phoneNumber, email);
				
				// add the customer to the array
				customerList.add(customer);
				
				// ensure that the customer object is empty ready for the next line
				customer = null;
				
				
			}
			
			// close the file
			customerFile.close();
			
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// method to print the customers
	public void displayCustomers() {
		
		// customer list heading
		System.out.println("\nCustomers\n");
		
		// for all of the customer
		for (int i = 0; i < customerList.size(); i++) {
			
			// print the customers info
			System.out.println(customerList.get(i).toString());
			
			// print a space
			System.out.println("\n");
		}
		
		
		
	}
	
	// method to add customer
	public void addNewCustomer() {
		
		// try
		try {
			
			// scanner object for the integer input i.e. customerNumber
			Scanner integerInput = new Scanner(System.in);
			
			// scanner object for the string input i.e., everything else
			Scanner stringInput = new Scanner(System.in);
			
			// prompt the user for the customerNumber
			System.out.println("\nEnter new customer number: ");
			
			// take in the customerNumber
			int customerNumber = integerInput.nextInt();
				
			// prompt for the first name
			System.out.println("\nEnter new customer first name: ");
			
			// take in the first name
			String firstName = stringInput.nextLine();
				
			// prompt for the last name
			System.out.println("\nEnter new customer last name: ");
				
			// take in the last name
			String lastName = stringInput.nextLine();
				
			// prompt the address
			System.out.println("\nEnter new customer address: ");
			
			// take in the address
			String address = stringInput.nextLine();
				
			// prompt for the phone number
			System.out.println("\nEnter new customer phone number: ");
				
			// take in the phone number
			String phoneNumber = stringInput.nextLine();
			
			// prompt the email
			System.out.println("\nEnter new customer email: ");
				
			// take in the email
			String email = stringInput.nextLine();
			
			
			// create customer object	
			Customer customer = new Customer(customerNumber, firstName, 
					lastName, address, phoneNumber, email);
				
			// add customer to the array
			customerList.add(customer);
				
		// catch any input mismatch
		} catch (InputMismatchException e) {
				
			System.out.println("\nInvalid");
				
		}
		
	}
		
	// method to save the contents of the customer file
	public void saveCustomerFile() {

		// try
		try {
			
			// declare file object
			File fileName = new File("/Users/martinhanna/Downloads/customers.txt");
			
			// declare file writer
			FileWriter fw = new FileWriter(fileName);
			
			// declare output
			Writer output = new BufferedWriter(fw);
			
			// for all of the customers in the array
			for (int i = 0; i < customerList.size(); i++) {
				
				// overwrite the contents of the customer file
				output.write(customerList.get(i).getCustomerNumber() + "," +
						customerList.get(i).getFirstName() + "," + 
						customerList.get(i).getLastName() + "," +
						customerList.get(i).getAddress() + "," +
						customerList.get(i).getPhoneNumber() + "," +
						customerList.get(i).getEmail() + "," + "\n");
				
			}
			
			// close the file
			output.close();
			
		// catch any exceptions
		} catch (Exception e) {
			
		}
	}
	
	// method to print out the cake option menu
	public void printOrderOptions() {
		
		System.out.println("\nOptions\n");
		System.out.println("1. Create new order");
		System.out.println("2. Return to Main Menu");
		
	}
	
	// method to print out the deliveries
	public void printDeliveries() {
		
		// if there are no deliveries in the system
		if (orderTotal.isEmpty()) {
			
			System.out.println("\nNo deliveries in the system");
			
		} else {
			
			// prompt the user for the day they want to look through
			System.out.println("\nEnter the delivery day required (yyyy-mm-dd): ");
			
			// declare the delivery date to be searched
			Scanner userDeliveryDate = new Scanner(System.in);
			
			String deliveryDateString = userDeliveryDate.next();
			
			LocalDate deliveryDate = LocalDate.parse(deliveryDateString);
		
			// for all of the customers
			for (int i = 0; i < customerList.size(); i++) {
				
				// if there are no orders
				if (customerList.get(i).getOrders().isEmpty()) {
					
					// continue on
					continue;
				
				} 
				
				// if the the user date matches the delivery date
				else if (deliveryDate.compareTo(customerList.get(i).getOrders().get(i).getDeliveryDate()) == 0) {
				
					// print the information
					System.out.println("\n" + this.customerList.get(i).toString() + "\n");
					System.out.println("Orders:");
					System.out.println(this.customerList.get(i).getOrders().toString());
				
				}
				
			
			}
		
		}	
		
	}
	
	// method to print all of the cakes needing to be prepared
	public void printCakes() {

		// if there are no orders and there for no cakes
		if (orderTotal.isEmpty()) {
			
			// print no orders in the system
			System.out.println("\nNo cakes to display in the system");
			
		// if there are orders in the array
		} else {
			
			// scanner object for the day input
			Scanner dayInput = new Scanner(System.in);
			
			// prompt the user for the day they want to look through
			System.out.println("\nEnter the day for the cakes to be viewed (yyyy-mm-dd): ");
			
			// take the day
			String dayString = dayInput.next();
			
			LocalDate newUserDate = LocalDate.parse(dayString);
		
			// for all of the orders
			for (int i = 0; i < orderTotal.size(); i++) {
				
				// if there user date matches the order date
				if (newUserDate.compareTo(orderTotal.get(i).getOrderDate()) == 0) {
					
					// print the order number
					System.out.println("\nOrder Number: " + orderTotal.get(i).getOrderNumber());
					
					// display the cake information
					orderTotal.get(i).displayCakes();
					System.out.println("\n");
				
				// if there are no orders for that day
				} else {
					
					// print no cakes
					System.out.println("\nNo cakes for that day");
					
				}
			}
				
		}
			
	}
		
	
	
	// main program entry point
	public static void main(String[] args) {
		
		// create a LittleCakeFactory object
		LittleCakeFactory lcf = new LittleCakeFactory();
		
	}
	
}
