package C3Collections.Exercises;

import java.util.Scanner;

import C3Collections.Programs.ArrayStack;

/**
 * Implement an integer adder using 3 stacks.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP3_6 {

	public static ArrayStack<Integer> stackOne = new ArrayStack<Integer>(3);

	public static ArrayStack<Integer> stackTwo = new ArrayStack<Integer>(4);

	public static Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter integers for stack one: ");
		fillStack(stackOne);
		System.out.println("Enter integers for stack two: ");
		fillStack(stackTwo);
		System.out.println("Stack One: " + stackOne);
		System.out.println("Stack Two: " + stackTwo);
		ArrayStack<Integer> stackResult = addStacks(stackOne, stackTwo);
		System.out.println("Add Stack: " + stackResult);
		scanner.close();
	}

	/**
	 * Fill stack with user input.
	 * 
	 * @param stackOne
	 */
	private static void fillStack(ArrayStack<Integer> stackOne) {
		boolean process = true;
		do {
			String number = scanner.nextLine();
			if (number.equalsIgnoreCase("stop")) {
				process = false;
			} else if (number.contains("push")) {
				String data = number.replace("push", "").trim();
				if (data.length() > 0) {
					stackOne.push(Integer.valueOf(data));
				}
				System.out.println("Current State: " + stackOne);
			} else {
				System.out.println("Include keywords stop/push");
			}
		} while (process);
	}

	/**
	 * Add 2 stacks and return result in 3rd stack
	 * 
	 * @param stackOne
	 * @param stackTwo
	 * @return
	 */
	private static ArrayStack<Integer> addStacks(ArrayStack<Integer> stackOne,
			ArrayStack<Integer> stackTwo) {
		ArrayStack<Integer> stackResult = new ArrayStack<Integer>(7);
		try {
			// Add 2 stacks, if one of the stack is bigger then add additional
			// elements to result stack 
			while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {
				Integer operandOne = 0;
				Integer operandTwo = 0;
				if (!stackOne.isEmpty()) {
					operandOne = stackOne.pop();
				}
				if (!stackTwo.isEmpty()) {
					operandTwo = stackTwo.pop();
				}
				stackResult.push(operandOne + operandTwo);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return stackResult;
	}
}
