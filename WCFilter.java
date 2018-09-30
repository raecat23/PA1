package cs131.pa1.filter.sequential;

import cs131.pa1.filter.Message;

public class WCFilter extends SequentialFilter {
	private int lines;
	private int words;
	private int chars;
	
	public void process() {
		if(this.prev == null) {
			System.out.print(Message.REQUIRES_INPUT.with_parameter("wc"));
		}else {
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
		while(space != -1) {
			temp = temp.substring(space).trim();
			words++;
		}
	}
	
	@Override
	protected String processLine(String line) {
		// TODO Auto-generated method stub
		return null;
	}

}