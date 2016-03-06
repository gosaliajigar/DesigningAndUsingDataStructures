package C2AnalysisOfAlgorithms.Exercises;

/**
 * Display terms and their values of a given growth function.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class EX2_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long values[] = { 1, 2, 5, 10, 100, 1000, 10000, 100000, 1000000,
				10000000 };

		// Growth Function: 15n^2 + 45n
		for (int i = -1; i < values.length; i++) {
			if (i < 0) {
				System.out.printf("%-20s %-20s %-20s %-20s", "Value of n",
						"15n^2", "45n", "15n^2 + 45n");
				System.out.println();
			} else {
				System.out.printf("%-20s %-20s %-20s %-20s\n", values[i],
						15 * (values[i] * values[i]), 45 * values[i],
						(15 * (values[i] * values[i])) + (45 * values[i]));
			}
		}
	}
}
