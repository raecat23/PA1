package cs131.pa1.filter.sequential;

import java.io.*;
import java.util.*;

import cs131.pa1.filter.Message;

public class LSFilter extends SequentialFilter {
	
	public void process() {
		if(this.prev != null) {
			System.out.print(Message.CANNOT_HAVE_INPUT.with_parameter("ls"));
		}else {
			File currDir = new File(SequentialREPL.currentWorkingDirectory);
			File[] listFiles = currDir.listFiles();
			if(output == null) {
				output = new LinkedList<String>();
			}
			for(int i = 0; i < listFiles.length; i++) {
				output.add(listFiles[i].getName());
			}
			if(this.next == null) {
				while(!output.isEmpty()) {
					System.out.println(output.poll());
				}
			}
		}
	}
	
	protected String processLine(String line) {
		return null;
	}

}
