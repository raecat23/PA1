package cs131.pa1.filter.sequential;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CarrotFilter extends SequentialFilter{
	File file;
	PrintWriter p;
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

