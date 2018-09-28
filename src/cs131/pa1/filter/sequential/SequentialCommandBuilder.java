package cs131.pa1.filter.sequential;

import java.util.*;

public class SequentialCommandBuilder {
	
	/**
	 * 
	 * @param command The user input string
	 * @return The list of Sequential filters that need to be executed
	 */
	public static List<SequentialFilter> createFiltersFromCommand(String command){
		List<SequentialFilter> cmds = new LinkedList<>();
		boolean commandProcessed = false;
		while(!commandProcessed) {
			int endCmd = command.indexOf('|');
			String cmd = "";
			if(endCmd != -1) {
				cmd = command.substring(0, endCmd - 1);
				command = command.substring(endCmd+2);
			} else {
				cmd = command;
				commandProcessed = true;
			}
		}		
		return null;
	}
	
	private static SequentialFilter determineFinalFilter(String command){
		return null;
	}
	
	private static String adjustCommandToRemoveFinalFilter(String command){
		return null;
	}
	
	private static SequentialFilter constructFilterFromSubCommand(String subCommand){
		return null;
	}

	private static boolean linkFilters(List<SequentialFilter> filters){
		return false;
	}
}
