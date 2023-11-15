package exam;

public class PrintedCake extends Cake{
	
	// fixed fee for the printed cake
	private final double FIXED_FEE = 10;
	
	// constructor for printed cake that takes in the 
	public PrintedCake(String cakeName, String flavour, String shape, String cakeColour, int diameter) {
		
		// initialise the attributes from the Cake super class
		super(cakeName, flavour, shape, cakeColour, diameter);
		
		// set the iceing to true
		this.hasIceing = true;
	}
	
	// overridden method to calculate the price of a printed cake
	@Override
	public double calculatePrice() {

		// return the price of the cake
		return (getDiameter() * COST_PER_INCH + FIXED_FEE);
	
	}

}
