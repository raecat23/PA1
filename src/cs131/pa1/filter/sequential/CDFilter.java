package cs131.pa1.filter.sequential;

import java.io.*;

import cs131.pa1.filter.Message;

public class CDFilter extends SequentialFilter {
	private String newDir;
	
	public void process() {
		boolean error = false;
		if(this.prev != null) {
			System.out.print(Message.CANNOT_HAVE_INPUT.with_parameter("cd"));
			error = true;
		}
		if(this.next != null) {
			System.out.print(Message.CANNOT_HAVE_OUTPUT.with_parameter("cd"));
			error = true;
		}
		if(!error) {
			if(newDir.equals("..")) {
				int lastSlash = SequentialREPL.currentWorkingDirectory.lastIndexOf("\\");
				SequentialREPL.currentWorkingDirectory = SequentialREPL.currentWorkingDirectory.substring(0, lastSlash);
			}else if(!newDir.equals(".")) { //"." results in no change, so must ensure the rest are not this
				File dir = new File(newDir);
				if(dir.exists()) {
					SequentialREPL.currentWorkingDirectory = newDir;
				}else {
					System.out.print(Message.DIRECTORY_NOT_FOUND.with_parameter(newDir));
				}
			}
		}
		
	}
	
	public void checkParam(String arg) {
		arg = arg.trim();
		int endCD = arg.indexOf(' ');
		if(endCD != -1) {
			newDir = arg.substring(endCD+1);
		}else {
			System.out.print(Message.REQUIRES_PARAMETER.with_parameter("arg"));
		}
	}
	
	protected String processLine(String line) {
		return null;
	}

}
