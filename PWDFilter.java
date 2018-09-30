package cs131.pa1.filter.sequential;

import java.util.*;

import cs131.pa1.filter.Message;

public class PWDFilter extends SequentialFilter{
	
	public void process() {
		if(this.prev != null) {
			System.out.print(Message.CANNOT_HAVE_INPUT.with_parameter("pwd"));
		}else {
			if(output == null) {
				output = new LinkedList<String>();
			}
			output.add(SequentialREPL.currentWorkingDirectory);
			if(this.next == null) {
				System.out.println(output.poll());
			}else {
				((SequentialFilter)this.next).input = this.output;
			}
		}
	}
	
	@Override
	protected String processLine(String line) {
		// TODO Auto-generated method stub
		return null;
	}

	public void checkParam(String arg) {
		arg = arg.trim();
		int end = arg.indexOf(' ');
		if(end != -1) {
			System.out.print(Message.INVALID_PARAMETER.with_parameter("pwd"));
		}
	}
}