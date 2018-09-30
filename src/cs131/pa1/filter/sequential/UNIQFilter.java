package cs131.pa1.filter.sequential;

import java.util.LinkedList;

import cs131.pa1.filter.Message;

public class UNIQFilter extends SequentialFilter {
	
	public void process() {
		if(this.prev == null) {
			System.out.print(Message.REQUIRES_INPUT.with_parameter("uniq"));
		}else {
			output = new LinkedList<>();
			super.process();
			if(this.next == null) {
				while(!output.isEmpty()) {
					System.out.println(output.poll());
				}
			}else {
				((SequentialFilter)this.next).input = this.output;
			}
		}
	}
	
	protected String processLine(String line) {
		if(!output.contains(line)) {
			return line;
		}
		return null;
	}
	
	public void checkParam(String arg) {
		arg = arg.trim();
		int end = arg.indexOf(' ');
		if(end != -1) {
			System.out.print(Message.INVALID_PARAMETER.with_parameter("arg"));
		}
	}
}
