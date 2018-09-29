package cs131.pa1.filter.sequential;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CATFilter extends SequentialFilter {
	//Still have to overwrite Process, how you've written this it will do it for EVERY line lol 
	//The "line" is going to be each individual line in the file, which is fed one by one into this method
	
	//You also have to initialize the Queue input since that isn't done, you can probably do that at the beginning of process
	
	//The file name is being given to us when the user types it, so you need to make a new method to take the file and 
	//turn it into a Queue of strings (I think each line is supposed to be a string in the queue)
	
	//ALSO should check if there is a this.next because if there is you can just send that badboy over to the next one as the 
	//Queue of strings; that'll actually make the next part super easy
	@Override
	protected String processLine(String line) {
		//errors to check: if its a file, if the file exists
		String output = "";
		if(this.prev == null /* || the input is a file and the file exists*/ ){
			Scanner scan = new Scanner(System.in);
			try {
				scan = new Scanner(new File(line));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(scan.hasNextLine()){
				output += scan.nextLine() + "\n";
			}
		}
		else{
			//error handling here
			
		}
		return output;
	}

}

