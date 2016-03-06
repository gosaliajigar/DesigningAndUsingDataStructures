package C3Collections.Programs;

import java.util.StringTokenizer;

/**
 * PostFixEvaluator evaluates given post-fix expression.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class PostFixEvaluator {

	private static final char PLUS = '+';

	private static final char MINUS = '-';

	private static final char MULTIPLY = '*';

	private static final char DIVIDE = '/';

	/**
	 * 
	 */
	private ArrayStack<Integer> stack;

	/**
	 * 
	 */
	public PostFixEvaluator() {
		stack = new ArrayStack<Integer>();
	}

	/**
	 * Evaluate given post-fix operation for its validity.
	 * 
	 * @param expression
	 * @return
	 */
	public int evaluate(String expression) {
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
		return result;
	}

	/**
	 * Perform operation on the two operands.
	 * 
	 * @param operator
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private int operate(char operator, int operand1, int operand2) {
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
}
