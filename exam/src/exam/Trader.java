package exam;

// imports required
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Trader extends Thread {
	
	// declare a semaphore to ensure only 1 trader's trades is logged at a time
    private static Semaphore tradesFileSemaphore = new Semaphore(1);
    
    // declare a unique trader number
    private int traderNumber;

    // declare an exchange object
    private CryptoExchange cryptoExchange;
    
    // declare the flag variable for trading
    private boolean isTrading;
    
    // declare objects required for the trades.log file
    private static Logger tradesLogger = Logger.getLogger("Trades");  
    private static FileHandler tradesFileHandler;
    private static SimpleFormatter tradesFormatter = new SimpleFormatter();
    
    // constructor for the trader object
    public Trader(int traderNumber, CryptoExchange cryptoExchange) {
    	
    	// set the variables to the parameters given
        this.traderNumber = traderNumber;
        this.cryptoExchange = cryptoExchange;
        
        // set the trader to trading
        this.isTrading = true;
    }
    
    // method to open the trades.log file for writing
    public static void openTradesFile() {
    	
    	// try
        try {
            
            // This block configure the logger with handler and formatter  
            tradesFileHandler = new FileHandler("/Users/martinhanna/Downloads/trades.log");  
            
            // add the file handler to the trades logger
            tradesLogger.addHandler(tradesFileHandler);
            
            // disable console updates
            tradesLogger.setUseParentHandlers(false); 
            
            // set the formatter
            tradesFileHandler.setFormatter(tradesFormatter); 
            
        // catch any exceptions
        } catch (Exception e) {
        	
        	// print the exception
            e.printStackTrace(System.out);
        }
    }
    
    // method to close the trades.log file
    public static void closeTradesFile() {
    	
    	// try
        try {
            
            // close the trades logger
            tradesFileHandler.close();
            
        // catch any exceptions
        } catch (Exception e) {
        	
        	// print any exceptions
            e.printStackTrace(System.out);
        }
    }
    
    // method to stop the trading
    public void stopTrading() {
    	
    	// set the trading flag variable to false
        this.isTrading = false;
    }

    
    // method to run the trader threads
    @Override
    public void run() {
    	
    	// while the trader is trading
        while (this.isTrading) {
        	
        	// generate a random amount for an offer
            int cryptoAmount = ThreadLocalRandom.current().nextInt(1001);
            
            // declare variable to hold the time
            long timeStamp = this.cryptoExchange.submitOffer(cryptoAmount);
            
            // try
            try {
            	
            	// acquire the trades file semaphore
                tradesFileSemaphore.acquire();
                
                // write the data to the trades.log file
                tradesLogger.info(timeStamp + " - Trader " + this.traderNumber + " - " + cryptoAmount + " - satoshi");
                
                // release the semaphore so other threads can use it
                tradesFileSemaphore.release();
                
             // catch any exceptions
            } catch (Exception e) {
            	
            	// print any exceptions
                e.printStackTrace(System.out);
            }
            
            // try
            try {
            	
            	// the trader sleeps for 100 - 300 milliseconds before trading again
                Thread.sleep(ThreadLocalRandom.current().nextInt(101) + 200);
                
            // catch any exceptions
            } catch (Exception e) {
            	
            	// print any exceptions
                e.printStackTrace(System.out);
            }
        }
    }

}

