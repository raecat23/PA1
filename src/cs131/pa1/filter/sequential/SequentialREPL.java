package cs131.pa1.filter.sequential;

import java.util.*;
import java.util.Scanner;

import cs131.pa1.filter.Message;

public class SequentialREPL {

	static String currentWorkingDirectory;
	private static Scanner keyboard;
	
	public static void main(String[] args){
		System.out.print(Message.WELCOME);
		currentWorkingDirectory = System.getProperty("user.dir");
		REPloop();
	}
	
	/*
	 * Houses the actual loop where commands are taken in and processed 
	 */
	public static void REPloop() {
		
		keyboard = new Scanner(System.in);
		boolean moreCommands = true;
		while(moreCommands){
			System.out.print(Message.NEWCOMMAND);
			String input = keyboard.nextLine();			
			List<SequentialFilter> commands = SequentialCommandBuilder.createFiltersFromCommand(input);
					
			if(commands != null) {				
				for(int i = 0; i < commands.size(); i++) {
					commands.get(i).process();
				}
			}
		}
	}
	
	
	
	/*
	 * For testing purposes 
	 */
	public static String printArr(String [] arr) {
		String array = "[" + arr[0];
		for(int i = 1; i < arr.length; i++) {
			array = array + ", " + arr[i];
		}
		return array + "]";
	}

}