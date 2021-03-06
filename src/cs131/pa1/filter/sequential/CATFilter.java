package cs131.pa1.filter.sequential;

import java.io.*;
import java.util.*;

import cs131.pa1.filter.Message;

public class CATFilter extends SequentialFilter {
	private String fileName;
	//boolean error;
	
	public void process() {
		if(this.prev != null) {
			System.out.print(Message.CANNOT_HAVE_INPUT.with_parameter("cat"));
		}else {
			input = new LinkedList<>();
			output = new LinkedList<>();
			try {
				File catFile = new File(fileName);
				Scanner catRead = new Scanner(catFile);
				while(catRead.hasNextLine()) {
					input.add(catRead.nextLine());
				}
				super.process();
				
				if(this.next == null) {
					while(!output.isEmpty()) {
						System.out.println(output.poll());
					}
				}else {
					((SequentialFilter)this.next).input = this.output;
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
		arg = arg.trim();
		int endCat = arg.indexOf(' ');
		if(endCat != -1) {
			fileName = arg.substring(endCat+1);
		}else {
			System.out.print(Message.REQUIRES_PARAMETER.with_parameter("arg"));
			//error = true;
		}
	}

}