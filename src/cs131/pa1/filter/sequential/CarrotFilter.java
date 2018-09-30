package cs131.pa1.filter.sequential;

import java.io.*;

import cs131.pa1.filter.Message;

public class CarrotFilter extends SequentialFilter{
	
	String fileName;
	File file;
	PrintWriter p;
	
	@Override
	public void process() {
		if(this.prev == null) {
			System.out.print(Message.REQUIRES_INPUT.with_parameter(">"));
		}else {
			try {
				newFileMaker();
			} catch (FileNotFoundException e) {
				System.out.println("This should never happen...");
			}
			super.process();
		}
	}
	@Override
	protected String processLine(String line) {
		p.println(line);
		if(input.peek() == null){
			p.close();
		}
		return null;
	}
	
	public void newFileMaker() throws FileNotFoundException{
		file = new File(fileName);
		p = new PrintWriter(new File(fileName));
	}
	
	public void checkParam(String arg) {
		arg = arg.trim();
		int endCar = arg.indexOf(' ');
		if(endCar != -1) {
			fileName = arg.substring(endCar+1);
		}else {
			System.out.print(Message.REQUIRES_PARAMETER.with_parameter(">"));
		}
	}

}