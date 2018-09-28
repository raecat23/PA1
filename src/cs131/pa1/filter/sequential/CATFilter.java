package cs131.pa1.filter.sequential;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CATFilter extends SequentialFilter {

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

