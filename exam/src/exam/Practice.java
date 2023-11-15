package exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Practice {
	
	 private static void pressAnyKeyToContinue()
	 { 
	        System.out.println("Press Enter key to continue...");
	        
	        try
	        
	        {
	            System.in.read();
	            
	        }  
	        catch(Exception e)
	        {}  
	 }


	// main program entry point
	public static void main(String[] args) throws FileNotFoundException {
		
		pressAnyKeyToContinue();
		
		File txt = new File("/Users/martinhanna/Downloads/text.txt");
		
		Scanner scan = new Scanner(txt);
		
		ArrayList<String> data = new ArrayList<String>();
		
		while(scan.hasNextLine()){
			
		    data.add(scan.nextLine());
		}
		
		System.out.println(data);
		
		String[] simpleArray = data.toArray(new String[]{});
		
		System.out.println(simpleArray[1]);
		
		}

}
