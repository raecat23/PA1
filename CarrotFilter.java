package cs131.pa1.filter.sequential;

import java.io.*;

import cs131.pa1.filter.Message;

public class CarrotFilter extends SequentialFilter{

	File file;
	PrintWriter p;
	
	public void process() {
		if(this.prev == null) {
			System.out.print(Message.REQUIRES_INPUT.with_parameter(">"));
		}else {
			super.process();
		}
	}
	@Override
	protected String processLine(String line) {
		p.write(line);
		if(input.peek() == null){
			p.close();
		}
		return null;
	}
	
	public void newFileMaker(String fileName) throws FileNotFoundException{
		file = new File(fileName);
		p = new PrintWriter(file);
	}

}