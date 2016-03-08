package C4LinkedStructures.Exercises;

import java.util.Scanner;

import C4LinkedStructures.Programs.LinkedStack;

/**
 * Design and implement an application that reads a sentence from the user and
 * prints the sentence with the characters of each word backwards. Use a stack
 * to reverse the characters of each word.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP4_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			scanner.close();
			System.out.println("Input Line   :" + line);
			LinkedStack<String> stack = new LinkedStack<String>();
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
