package cs131.pa1.filter.sequential;

import java.util.LinkedList;

import cs131.pa1.filter.Message;

public class WCFilter extends SequentialFilter {
	private int lines;
	private int words;
	private int chars;
	
	public void process() {
		if(this.prev == null) {
			System.out.print(Message.REQUIRES_INPUT.with_parameter("wc"));
		}else {
			if(output == null) {
				output = new LinkedList<>();
			}
			while(!input.isEmpty()) {
				String curr = input.poll();
				lines++;
				getWords(curr);
				chars += curr.length();
			}
			output.add(lines+" "+words+" "+chars);
			if(this.next == null) {
				while(!output.isEmpty()) {
					System.out.println(output.poll());
				}
			}else {
				((SequentialFilter)this.next).input = this.output;
			}
		}
	}
		
	protected void getWords(String curr) {
		curr = curr.trim();
		if(!curr.isEmpty()) { //this accounts for last word, or only word if only one word
			words++;
		}
		
		String temp = curr;
		int space = temp.indexOf(' ');
		while(space > -1) {
			temp = temp.substring(space).trim();
			words++;
			space = temp.indexOf(' ');
		}
	}
	
	public void checkParam(String arg) {
		arg = arg.trim();
		int end = arg.indexOf(' ');
		if(end != -1) {
			System.out.print(Message.INVALID_PARAMETER.with_parameter("arg"));
		}
	}
	
	@Override
	protected String processLine(String line) {
		// TODO Auto-generated method stub
		return null;
	}

}