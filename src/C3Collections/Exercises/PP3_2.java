package C3Collections.Exercises;

import java.util.Scanner;

import C3Collections.Programs.ArrayStack;

/**
 * Program to read a sentence from user and print the sentence with the
 * characters of each word backwards using stack.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP3_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Enter a sentence that will be reversed using stack: ");
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			scanner.close();
			System.out.println("Input Line   :" + line);
			ArrayStack<String> stack = new ArrayStack<String>();
			for (int index = 0; index < line.length(); index++) {
				stack.push(String.valueOf(line.charAt(index)));
			}
			System.out.print("Reverse Line :");
			while (!stack.isEmpty()) {
				System.out.print(stack.pop());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
