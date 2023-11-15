package exam;

public class Cake {
	
	// variables required for the cake
	private String cakeName;
	private String flavour;
	private String shape;
	private String cakeColour;
	protected boolean hasIceing;
	
	// customer enters in the diameter
	private int diameter;
	
	// cost per inch is fixed static variable
	protected static final double COST_PER_INCH = 10;
	
	// constructor for the cake class
	public Cake(String cakeName, String flavour, String shape, String cakeColour, int diameter) {
		
		// set this instance of the cake to the parameters
		this.cakeName = cakeName;
		this.flavour = flavour;
		this.shape = shape;
		this.cakeColour = cakeColour;
		this.hasIceing = false;
		
		// if the diameter is less than 6
		if (diameter < 6) {
			
			// inform the customer that the minimum is 6 inches
			System.out.println("Minimum cake size is 6\"\nDiameter set to 6\"\n");
			
			// set the cake to the default
			this.diameter = 6;
			
		// if the diameter is valid
		} else {
			
			// set the diameter to the parameter
			this.diameter = diameter;
		
		}
		
		
	}
	
	// method to calculate the price of a cake
	public double calculatePrice() {

		// return the diameter multiplied by the cost per inch
		return (getDiameter() * COST_PER_INCH);
	
	}
	
	
	// method to get the cake name
	public String getCakeName() {
		
		// return the cake name
		return this.cakeName;
		
	}
	
	
	// method to get the flavour
	public String getFlavour() {
		
		// return the flavour
		return this.flavour;
		
	}
	
	
	// method to get the flavour
	public String getShape() {
		
		// return the shape
		return this.shape;
		
	}
	
	
	// method to get the flavour
	public String getCakeColour() {
		
		// return the cake colour
		return this.cakeColour;
		
	}
	
	// method to get the flavour
	public int getDiameter() {
		
		// return the diameter
		return this.diameter;
		
	}
	
	public boolean getHasIcing() {
		
		return this.hasIceing;
	}
	
	// method to output all of the data to the console
	public String toString()
	{

		//return all of the information regarding the cake
	   return String.format( "Cake Name: %s\nFlavor: %s\nShape: %s\nCake Colour: %s\nDiameter: %d\"\nPrice: €%.2f", 
	     getCakeName(), getFlavour(), getShape(), getCakeColour(), getDiameter(), calculatePrice());
	   
	} 

}