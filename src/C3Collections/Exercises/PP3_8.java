package C3Collections.Exercises;

import java.util.Scanner;

import C3Collections.Programs.ArrayStack;

/**
 * Reverse given string using stacks.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class PP3_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayStack<Character> stack = new ArrayStack<Character>(10);
		Scanner scanner = new Scanner(System.in);
		try {
			String data = scanner.nextLine();
			for (int index = 0; index < data.length(); index++) {
				stack.push(data.charAt(index));
			}
			System.out.println("Input : " + data);
			System.out.print("Reverse : ");
			while (!stack.isEmpty()) {
				System.out.print(stack.pop());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
