package C4LinkedStructures.Exercises;

import java.util.Scanner;

import C4LinkedStructures.Programs.LinkedStack;

/**
 * Create a simple graphical application that will allow a user to perform push,
 * pop, and peek operations on a stack and display the resulting stack (using
 * toString) in a text area.<br><br>
 * 
 * Below is implemented as console application and not graphical.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP4_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<String>();
		Scanner scanner = new Scanner(System.in);
		boolean process = true;
		System.out.println("Enter your command using push<NUMBER>/pop/peek/stop keywords ... ");
		try {
			do {
				String number = scanner.nextLine();
				if (number.equalsIgnoreCase("stop")) {
					process = false;
				} else if (number.contains("push")) {
					String data = number.replace("push", "").trim();
					if (data.length() > 0) {
						stack.push(data);
					}
					System.out.println("Current State: " + stack);
				} else if (number.contains("pop")) {
					stack.pop();
					System.out.println("Current State: " + stack);
				} else if (number.equalsIgnoreCase("peek")) {
					System.out.println("Peek :" + stack.peek());
				} else {
					System.out.println("Include keywords stop/push/pop/peek");
				}
			} while(process);
			System.out.println("Terminating on request .... ");
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
