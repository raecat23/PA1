package cs131.pa1.filter.sequential;

import java.util.Scanner;

import cs131.pa1.filter.Message;

public class SequentialREPL {

	static String currentWorkingDirectory;
	String presentWorkingDirectory;
	
	public static void main(String[] args){
		System.out.println(Message.WELCOME);

		REPloop();
	}
	
	/*
	 * Houses the actual loop where commands are taken in and processed 
	 */
	public static void REPloop() {
		
		Scanner keyboard = new Scanner(System.in);
		boolean moreCommands = true;
		while(moreCommands){
			System.out.print(Message.NEWCOMMAND);
			String input = keyboard.nextLine();			
			//Send input to Command Builder here
			
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
