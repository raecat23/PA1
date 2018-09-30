package cs131.pa1.filter.sequential;

import java.util.LinkedList;

import cs131.pa1.filter.Message;

public class UNIQFilter extends SequentialFilter {
	
	public void process() {
		if(this.prev == null) {
			System.out.print(Message.REQUIRES_INPUT.with_parameter("uniq"));
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
		if(!output.contains(line)) {
			return line;
		}
		return null;
	}
}
