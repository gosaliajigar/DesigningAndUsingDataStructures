package C4LinkedStructures.Exercises;

import java.util.Scanner;
import java.util.StringTokenizer;

import C4LinkedStructures.Programs.LinkedStack;

/**
 * Modify the postfix program from Chapter 3 so that it uses the LinkedStack<T>
 * class instead of the ArrayStack<T> class.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP4_2 {

	/**
	 * 
	 */
	private static final char PLUS = '+';

	/**
	 * 
	 */
	private static final char MINUS = '-';

	/**
	 * 
	 */
	private static final char MULTIPLY = '*';

	/**
	 * 
	 */
	private static final char DIVIDE = '/';

	/**
	 * 
	 */
	private static LinkedStack<Integer> stack;

	/**
	 * Evaluate given post-fix operation for its validity.
	 * 
	 * @param expression
	 * @return
	 */
	private static void evaluate(String expression) {
		int operand1, operand2, result = 0;
		try {
			StringTokenizer tokens = new StringTokenizer(expression);
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				if (isOperator(token)) {
					operand2 = stack.pop();
					operand1 = stack.pop();
					result = operate(token.charAt(0), operand1, operand2);
					stack.push(result);
				} else {
					stack.push(new Integer(token));
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Perform operation on the two operands.
	 * 
	 * @param operator
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private static int operate(char operator, int operand1, int operand2) {
		Integer result = 0;
		switch (operator) {
		case PLUS:
			result = operand1 + operand2;
			break;
		case MINUS:
			result = operand1 - operand2;
			break;
		case MULTIPLY:
			result = operand1 * operand2;
			break;
		case DIVIDE:
			result = operand1 / operand2;
			break;
		}
		return result;
	}

	/**
	 * Checks if given token is one of 4 standard arithmetic operators.
	 * 
	 * @param token
	 * @return
	 */
	private static boolean isOperator(String token) {
		return (token.equals(String.valueOf(PLUS))
				|| token.equals(String.valueOf(MINUS))
				|| token.equals(String.valueOf(MULTIPLY)) 
				|| token.equals(String.valueOf(DIVIDE)));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		stack = new LinkedStack<Integer>();
		Scanner scanner = new Scanner(System.in);
		try {
			String expression = scanner.nextLine();
			evaluate(expression);
			if (stack.size() == 1) {
				System.out.println("PostFix Expression (" + expression + ") is valid: " + stack.peek());
			} else {
				System.out.println("PostFix Expression (" + expression + ") is not valid!");
				System.out.println(" - Stack status : " + stack);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
