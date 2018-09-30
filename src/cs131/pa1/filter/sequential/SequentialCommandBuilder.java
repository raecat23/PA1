package cs131.pa1.filter.sequential;

import java.util.*;

import cs131.pa1.filter.Message;

public class SequentialCommandBuilder {
	
	/**
	 * @param command The user input string
	 * @return The list of Sequential filters that need to be executed
	 */
	public static List<SequentialFilter> createFiltersFromCommand(String command){
		List<SequentialFilter> cmds = new LinkedList<>();
		boolean commandProcessed = false;
		while(!commandProcessed) {
			int endCmd = command.indexOf('|');
			String cmd;
			if(endCmd != -1) {
				cmd = command.substring(0, endCmd - 1);
				command = command.substring(endCmd+2);
			} else {
				int carrot = command.indexOf('>');
				if(carrot == -1) {
					cmd = command;
					commandProcessed = true;
				}else {
					if(carrot == 0) {
						cmd = command;
						commandProcessed = true;
					}else{
						cmd = command.substring(0, carrot -1);
						command = command.substring(carrot);
					}
				}
			}
			SequentialFilter next = getCommand(cmd);		
			if(next != null) {
				cmds.add(next);
			}else {
				System.out.print(Message.COMMAND_NOT_FOUND.with_parameter(cmd));
				return null;
			}
		}	
		linkFilters(cmds);
		return cmds;
	}
	
	private static SequentialFilter getCommand(String command) {
		int endCmd = command.indexOf(' ');
		String key = command;
		if(endCmd != -1) {
			key = command.substring(0,endCmd);
		}
		SequentialFilter cmd = null;
		switch(key) {
			case "pwd": cmd = new PWDFilter(); ((PWDFilter) cmd).checkParam(command); break;
			case "ls": cmd = new LSFilter(); ((LSFilter) cmd).checkParam(command); break;
			case "cd": cmd = new CDFilter(); ((CDFilter) cmd).checkParam(command); break;
			case "cat": cmd = new CATFilter(); ((CATFilter) cmd).checkParam(command); break;
			case "grep": cmd = new GREPFilter(); ((GREPFilter) cmd).checkParam(command); break;
			case "wc": cmd = new WCFilter(); ((WCFilter) cmd).checkParam(command); break;
			case "uniq": cmd = new UNIQFilter(); ((UNIQFilter) cmd).checkParam(command); break;
			case ">": cmd = new CarrotFilter(); ((CarrotFilter) cmd).checkParam(command); break;
			case "exit": cmd = new ExitFilter(); ((ExitFilter) cmd).checkParam(command); break;
		}
		return cmd;
	}
	
	private static boolean linkFilters(List<SequentialFilter> filters){
		if(filters != null && filters.size() > 1) {
			for(int i = 1; i < filters.size(); i++) {
				filters.get(i-1).setNextFilter(filters.get(i));
			}
			return true;
		}
		return false;
	}
}
