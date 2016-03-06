package C3Collections.Exercises;

import java.util.Scanner;

import C3Collections.Programs.ArrayStack;

/**
 * Implement a graphical application that provides buttons for push and pop and
 * text area to display its activity and stack status.
 * 
 * Below is implemented as console application and not graphical.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP3_9 {

	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>(5);
		Scanner scanner = new Scanner(System.in);
		boolean process = true;
		System.out.println("Enter your command using push<NUMBER>/pop/stop keywords ... ");
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
				} else {
					System.out.println("Include keywords stop/push/pop");
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
