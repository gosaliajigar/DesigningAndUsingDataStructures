package C3Collections.Programs;

import java.util.Scanner;

/**
 * PostFix evaluates given post-fix expression and prints the result. 
 * 
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PostFix {

	public static void main(String[] args) {
		PostFixEvaluator evaluator = new PostFixEvaluator();
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		scanner.close();
		int result = evaluator.evaluate(expression);
		System.out.println("PostFix Expression (" + expression + ") evaluates to "
				+ result);
	}
}
