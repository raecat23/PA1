package cs131.pa1.filter.sequential;

import java.util.*;

import cs131.pa1.filter.Message;

public class GREPFilter extends SequentialFilter {
	
	private String search;
	
	public void process() {
		if(this.prev == null) {
			System.out.print(Message.REQUIRES_INPUT.with_parameter("grep"));
		}else{
			if(output == null) {
				output = new LinkedList<>();
			}
			super.process();
			
			if(this.next == null) {
				while(!output.isEmpty()) {
					System.out.println(output.poll());
				}
			}
		}
	}
	
	protected String processLine(String line) {
		if(line.contains(search)) {
			return line;
		}
		return null;
	}
	
	public void checkParam(String arg) {
		int endGrep = arg.indexOf(' ');
		if(endGrep != -1 && endGrep != arg.length()-1) {
			search = arg.substring(endGrep+1);
		}else {
			System.out.print(Message.REQUIRES_PARAMETER.with_parameter("grep"));
		}
	}

}
