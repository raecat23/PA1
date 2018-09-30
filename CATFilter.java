package cs131.pa1.filter.sequential;

import java.io.*;
import java.util.*;

import cs131.pa1.filter.Message;

public class CATFilter extends SequentialFilter {
	private String fileName;
	
	public void process() {
		if(this.prev != null) {
			System.out.print(Message.CANNOT_HAVE_INPUT.with_parameter("cat"));
		}else {
			File catFile = new File(fileName);
			try {
				Scanner catRead = new Scanner(catFile);
				while(catRead.hasNextLine()) {
					input.add(catRead.nextLine());
				}
				super.process();
				
				if(this.next == null) {
					while(!output.isEmpty()) {
						System.out.println(output.poll());
					}
				}
				
			} catch (FileNotFoundException e) {
				System.out.print(Message.FILE_NOT_FOUND.with_parameter("cat"));
			}
		}
	}
	
	@Override
	protected String processLine(String line) {
		return line;
	}
	
	public void checkParam(String arg) {
		int endCat = arg.indexOf(' ');
		if(endCat != -1 && endCat != arg.length()-1) {
			fileName = arg.substring(endCat+1);
		}else {
			System.out.print(Message.REQUIRES_PARAMETER.with_parameter("cd"));
		}
	}

}