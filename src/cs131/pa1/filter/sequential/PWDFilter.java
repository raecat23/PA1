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
				System.out.println(output.remove());
			}
		}
	}
	
	@Override
	protected String processLine(String line) {
		// TODO Auto-generated method stub
		return null;
	}

}