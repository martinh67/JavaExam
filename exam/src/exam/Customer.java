package exam;

import java.util.ArrayList;

public class Customer {
	
	// variables required for the customer
	private int customerNumber;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	
	// order array for the customer
	private ArrayList<Order> orders = new ArrayList<>();
	
	// constructor for customer
	public Customer(int customerNumber, String firstName, 
			String lastName, String address, String phoneNumber, String email) {
		
		// setting the instance variables to the parameters
		
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
	}
	
	// method to get the customer number
	public int getCustomerNumber() {
		
		return this.customerNumber;
		
	}
	
	// method to get the first name of the customer
	public String getFirstName() {
		
		return this.firstName;
		
	}
	
	// method to get the last name of the customer
	public String getLastName() {
		
		return this.lastName;
		
	}
	
	// method to get the address of the customer
	public String getAddress() {
		
		return this.address;
		
	}
	
	// method to get the phone number of the customer
	public String getPhoneNumber() {
		
		return this.phoneNumber;
		
	}
	
	// method to get the customer's email address
	public String getEmail() {
		
		return this.email;
		
	}
	
	// method to add an order 
	public void addToOrder(Order order) {
		
		// add the order to the orders array
		orders.add(order);
		
	}
	
	// method to return the orders made by a customer
	public ArrayList<Order> getOrders() {
		
		// return the orders
		return this.orders;
		
	}
	
	// method to print the orders
	public void printOrders() {
		
		// for all of the orders
		for (int i = 0; i < orders.size(); i++) {
			
			// print the order
			System.out.println(orders.get(i).toString());
			
		}
	}
	
	// method to print the delivery information
	public void printDeliveryInformation() {
		
		// for all of the order
		for (int i = 0; i < orders.size(); i++) {
			
			// print the delivery information
			System.out.println(String.format("Name: %s %s\nPhone Number: %s\nAddress: "
					+ "%s\nEmail: %s\nOrders: %d", getFirstName(), getLastName(), getPhoneNumber(),
					getAddress(), getOrders()));
			
		}
		
		
	}
	
	@Override
	public String toString() {
		
		//return all of the information regarding the customer
		   return String.format( "Customer Number: %d\nFirst Name: %s\nLast Name: "
		   		+ "%s\nAddress: %s\nPhone Number: %s\"\nEmail: %s", 
		     getCustomerNumber(), getFirstName(), getLastName(), getAddress(), getPhoneNumber(), getEmail());
		   
	}
	

}
