package exam;

// imports required
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CryptoExchange {
	
	// declare a thread-safe array blocking queue
    private ArrayBlockingQueue<Integer> ledger;
    
    // a list of the traders created that are trading in the exchange
    private List<Trader> traders;

    // declare variables required for writing to the market.log file
    private Logger marketLogger = Logger.getLogger("Market");  
    private FileHandler marketFileHandler;
    private SimpleFormatter marketFormatter = new SimpleFormatter();
    
    // constructor for the exchange
    public CryptoExchange() {
    	
    	// create an array with size 1 so that only one sell offer is submitted at a time
        this.ledger = new ArrayBlockingQueue<>(1);
        
        // create an array list of traders
        this.traders = new ArrayList<>();

        // try
        try {
            
            // create a new file handler
            this.marketFileHandler = new FileHandler("/Users/martinhanna/Downloads/market.log");  
            
            // add the market file to the logger
            this.marketLogger.addHandler(this.marketFileHandler);
            
            // ensure that the market is displayed to the console
            this.marketLogger.setUseParentHandlers(true); 
            
            // set the market file handler to the formatter
            this.marketFileHandler.setFormatter(this.marketFormatter); 
            
        // catch any exceptions
        } catch (Exception e) {
        	
        	// record any exceptions
            e.printStackTrace(System.out);
        }
    }
    
    // method to open the exchange for trading
    public void openExchange() {
    	
    	// open the trades.log file
        Trader.openTradesFile();
        
        // generate between 5 and 10 traders
        int totalTraders = ThreadLocalRandom.current().nextInt(6) + 5;
        
        // for all of the traders generated
        for (int i = 0; i < totalTraders; i++) {
        	
        	// create new trader object
            Trader trader = new Trader(i + 1, this);
            
            // start the trader trading
            trader.start();

            // add the trader to the list
            this.traders.add(trader);
        }
    }
    
    // method to close the exchange
    public void closeExchange() {
    	
        // for all of the traders in the list
        for (Trader trader : this.traders) {
        	
        	// signal for the traders to stop
            trader.stopTrading();
            
        }
        
        // for all of the traders in the list
        for (Trader trader : this.traders) {
        	
        	// try
            try {
            	
            	// wait for the trader to stop trading
                trader.join();
                
            // catch any exceptions
            } catch (Exception e) {
            	
            	// record any exceptions
                e.printStackTrace(System.out);
            }
        }

        // try
        try {
        	
        	// close the market file
            this.marketFileHandler.close();
            
        // catch any exceptions
        } catch (Exception e) {
        	
        	// record any exceptions
            e.printStackTrace(System.out);
        }

        // close the trades file
        Trader.closeTradesFile();
    }
    
    // method for a trader to submit an offer
    public long submitOffer(int cryptoAmount) {
    	
    	// offer the amount generated
        this.ledger.offer(cryptoAmount);
        
        // declare the time as a time stamp
        long timeStamp = System.currentTimeMillis();

        // try 
        try {
        	
        	// write the trade offer to the market.log file
            this.marketLogger.info(timeStamp + " - " + cryptoAmount + " satoshi");
            
            
        // catch any exceptions
        } catch (Exception e) {
        	
        	// record any exceptions
            e.printStackTrace(System.out);
        }
        
        // remove the head of the queue
        this.ledger.poll();
        
        // return the time stamp
        return timeStamp;
    }

    // main program entry point
    public static void main(String[] args) {
    	
        // create a new exchange object
    	CryptoExchange cryptoExchange = new CryptoExchange();
    	
        // print that the exchange is open
        System.out.println("The Crypto Exchange is now open for trading.");
    	
    	// open the exchange to start trading showing the trades in the console
        cryptoExchange.openExchange();
        
        // print information on how to close the exchange
        System.out.print("Press Enter to close the exchange and end the trading...\n\n");
        
        // create scanner object
        Scanner input = new Scanner(System.in);
        
        // if the user hits the Enter key
	    input.nextLine();
	
	    // close the exchange to stop trading
	    cryptoExchange.closeExchange();
	    
	    // print transactions logged
	    System.out.println("Transactions saved to market.log");
	    
	    // print trades logged
	    System.out.println("Trader transactions saved to trades.log");
	        
        }
  
    
}
