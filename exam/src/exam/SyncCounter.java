package exam;

//counter class that implements the runnable interface
public class SyncCounter implements Runnable {
	
	// declare the count variable and set to 0
	private int count = 0;
	
	// method to increase the count variable
	public void increase() {
		
		// try
	    try {
	    	
	    	// sleep the thread for 10ms
	        Thread.sleep(10);
	        
	        // catch an interruption exception
	      } catch (InterruptedException e) {
	    	  
	        // record the error
	        e.printStackTrace();
	      }
	    
	      // increment the count variable	
	      this.count++;
	}
	
	// method to decrease the count variable
	public void decrease() {
		
		// decrement the count variable
		this.count--;
		
	}
	
	// method to get the current value of the count variable
	public int getCount() {
		
		// return the value of the count
		return this.count;
	}

	// overriding the run method required for implementing runnable interface
	// the run method is now synchronised to ensure that the correct output is generated
	@Override
	public synchronized void run() {
		
			// print the initial value
		    System.out.println("Initial value for " 
		    + Thread.currentThread().getName() + " = " + this.getCount());
			
		    // increase the count variable by 1 
		    this.increase();
		    
		    // print the value of count after the increase
		    System.out.println("Increase value for " 
		    + Thread.currentThread().getName() + " = " + this.getCount());
		    
		    // decrease the count variable by 1
		    this.decrease();
		    
		    // print the final value for the count variable
		    System.out.println("Final value for " 
		    + Thread.currentThread().getName() + " = " + this.getCount()); 
	    
		
	}
	
	// main method required to test
	public static void main(String[] args) {
		
		// declare counter object
	    Counter counter = new Counter();
	    
	    // initialise the thread objects
	    Thread t1 = new Thread(counter, "t1");
	    Thread t2 = new Thread(counter, "t2");
	    Thread t3 = new Thread(counter, "t3");
	    
	    // start the threads
	    t1.start();
	    t2.start();
	    t3.start();
	    
	  }   
	
}