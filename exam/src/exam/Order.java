package exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Order {
	
	// declare order variables
	private int orderNumber;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	
	// need to have an array list of cakes
	private ArrayList<Cake> cakes;
	
	// variable to hold the order count
	private static int orderCount = 1;
	
	// constructor for the order class
	public Order() {
		
		// the order date is the date today
		LocalDate orderDate1 = LocalDate.now();
		
		// the delivery date is the order date plus 3 days
		LocalDate deliveryDate1 = orderDate1.plusDays(3);
		
		this.orderNumber = orderCount++;
		this.orderDate = orderDate1;
		this.deliveryDate = deliveryDate1;
		this.cakes = new ArrayList<Cake>();
		
	}
	
	// method to get the order number
	public int getOrderNumber() {
		
		// return the order number
		return this.orderNumber;
		
	}
	
	// method to get the order date
	public LocalDate getOrderDate() {
		
		// return the order date
		return this.orderDate;
		
	}
	
	// method to get the delivery date
	public LocalDate getDeliveryDate() {
		
		// return the delivery date
		return this.deliveryDate;
		
	}
	
	// method to get the cakes
	public ArrayList<Cake> getCakes() {
		
		// return the cakes within the order
		return this.cakes;
		
	}
	
	
	// method to add the cakes to the order array
	public void addCake(Cake cake) {
		
		// add the cake to the order
		cakes.add(cake);
		
	}
	
	// methods to display the cakes in the array
	public void displayCakes() {
		
		for (int i = 0; i < cakes.size(); i++) {
			
			System.out.println(cakes.toString());
			
		}
	}
	
	// method to calculate the total order
	public double calculateTotalOrder() {
		
		// declare total variable 
		double total = 0;
		
		// for all of the cakes in the order
		for (int i = 0; i < cakes.size(); i++) {
			
			// add to the total
			total += cakes.get(i).calculatePrice();
			
			
		}
		
		// return the total
		return total;
		
	}
	
	
	// method to output string
	public String toString() {

		//return all of the information regarding the cake
	   return String.format( "Order Number: %d\nOrder Date: %s\nDelivery Date: %s", 
			   getOrderNumber(), getOrderDate(), getDeliveryDate());
	   
	} 


}
