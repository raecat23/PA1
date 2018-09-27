package cs131.pa1.filter.sequential;

import java.util.Scanner;

public class SequentialREPL {

	static String currentWorkingDirectory;
	String presentWorkingDirectory;
	
	public static void main(String[] args){
		System.out.println(">Welcome to the Unix-like Command Line");

		REPloop();
	}
	
	/*
	 * Houses the actual loop where commands are taken in and processed 
	 */
	public static void REPloop() {
		
		Scanner keyboard = new Scanner(System.in);
		while(true){
			System.out.print(" > ");
			String input = keyboard.nextLine();			
			String [] commands = input.split("[|]");
			for(int i = 0; i<commands.length; i++){
				String currentCommand = commands[i].toLowerCase().trim();
				switch(currentCommand){
					case "pwd":
					case "ls":
					case "cd":
					case "cat":
					case "grep":
					case "wc":
					case "uniq":
					case ">":
					case "exit": System.exit(-1);
					default: //something about invalid command
				//call each command here
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
