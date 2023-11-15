package exam;

public class HandmadeCake extends Cake {
	
	// variable to hold the message on the cake
	private String cakeMessage;
	
	// variable to hold the cost per letter in €
	private final double COST_PER_LETTER = 2;
	
	// constructor for printed cake that takes in the 
	public HandmadeCake(String cakeName, String flavour, String shape, String cakeColour, int diameter, String cakeMessage) {
		
		// initialise the attributes from the Cake super class
		super(cakeName, flavour, shape, cakeColour, diameter);
		
		// set this instance of cakeMessage to the parameter
		this.cakeMessage = cakeMessage;
		
		// set the icing to true
		this.hasIceing = true;
		
	}
	
	// overridden method to calculate the price of a printed cake in € including the letter fee
	@Override
	public double calculatePrice() {

		// return the price of the cake
		return (getDiameter() * COST_PER_INCH + calculateLetterFee());
	
	}
	
	// method to get the message written on the cake
	public String getCakeMessage() {
		
		return this.cakeMessage;
		
	}
	
	// method to calculate the cost of each letter on the cake i €
	public double calculateLetterFee() {
		
		// return the length of the cake
		return (getCakeMessage().length() * COST_PER_LETTER);
		
	}

}
