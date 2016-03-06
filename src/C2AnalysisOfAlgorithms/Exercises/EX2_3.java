package C2AnalysisOfAlgorithms.Exercises;

import java.util.Arrays;
import java.util.Random;

/**
 * Find the largest element in an unsorted array of integers.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class EX2_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[1000];
		// Load Data
		loadData(array);
		System.out.println("Array: " + Arrays.toString(array));
		if (array.length > 0) {
			System.out.println(" Using Full Iteration, Largest Element: " + getLargestFullIteration(array));
			System.out.println(" Using Half Iteration, Largest Element: " + getLargestHalfIteration(array));
		} else {
			System.out.println("Empty Array!");
		}
	}

	/**
	 * @param array
	 */
	private static void loadData(int[] array) {
		Random random = new Random();
		for (int index=0; index < array.length; index++) {
			array[index] = Math.abs(random.nextInt() % 1000);
		}
	}

	/**
	 * This method iterates full array.<br>
	 * Time complexity: O(n).
	 * 
	 * @param array
	 * @return
	 */
	public static int getLargestFullIteration(int[] array) {
		int largest = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > largest) {
				largest = array[i];
			}
		}
		return largest;
	}

	/**
	 * This method iterates half of the array.<br>
	 * Time complexity: O(n).
	 * 
	 * @param array
	 * @return
	 */
	public static int getLargestHalfIteration(int[] array) {
		int largest = array[0];
		for (int i = 0; i < (array.length / 2); i++) {
			if (array[i] > largest) {
				largest = array[i];
			}
			if (array[array.length - 1 - i] > largest) {
				largest = array[array.length - 1 - i];
			}
		}
		// Special case when array size is odd
		if ((array.length % 2) != 0 && largest < array[array.length / 2]) {
			largest = array[array.length / 2];
		}
		return largest;
	}
}
