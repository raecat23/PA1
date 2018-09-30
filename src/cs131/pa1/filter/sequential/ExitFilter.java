package cs131.pa1.filter.sequential;

import cs131.pa1.filter.Message;

public class ExitFilter extends SequentialFilter{

	public void process() {
		boolean error = false;
		if(this.prev != null) {
			System.out.print(Message.CANNOT_HAVE_INPUT.with_parameter("exit"));
			error = true;
		}
		if(this.next != null) {
			System.out.print(Message.CANNOT_HAVE_OUTPUT.with_parameter("exit"));
			error = true;
		}
		
		if(!error) {
			System.out.print(Message.GOODBYE);
			System.exit(-1);	
		}
	}
	
	@Override
	protected String processLine(String line) {
		return null;
	}
	
	public void checkParam(String arg) {
		arg = arg.trim();
		int endCat = arg.indexOf(' ');
		if(endCat != -1) {
			System.out.print(Message.INVALID_PARAMETER.with_parameter("arg"));
		}
	}
	
}