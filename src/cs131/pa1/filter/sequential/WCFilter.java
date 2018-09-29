package cs131.pa1.filter.sequential;

public class WCFilter extends SequentialFilter {
	//Same thing as for cat with the whole process vs process line 
	//Because process line will be happening for each line, the variables for all the counts should be outside of methods (globally?)
	//Then after process line runs all the times you print it out in process
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

