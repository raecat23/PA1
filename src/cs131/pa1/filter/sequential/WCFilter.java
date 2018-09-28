package cs131.pa1.filter.sequential;

public class WCFilter extends SequentialFilter {
	
	@Override
	protected String processLine(String line) {
		int wordcount = 0;
		int linecount = 0;
		int charactercount = 0;
		for(int i = 0; i< line.length(); i++){
			String s =line.substring(i,  i+1);
			if(s.equals("\\")){
				if(s.substring(i+1, i+2).equals("n")){
					linecount++;
				}
			}
			else if(s.equals(" ")){
				wordcount++;
				charactercount++;
			}
			else{
				charactercount++;
			}
		}
		return Integer.toString(wordcount) + "      " + Integer.toString(linecount) + "      " + Integer.toString(charactercount);
		//make sure to ignore \n
		//how to add them together?
	}

}

