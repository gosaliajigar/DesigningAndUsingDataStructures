package C4LinkedStructures.Programs;

/**
 * MazeSearch main class
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MazeSearch {

	/**
	 * Creates a new maze, prints its original form, attempts to solve it, and
	 * prints out its final form.
	 * 
	 * @param args
	 *            array of Strings
	 */
	public static void main(String[] args) {
		try {
			Maze labyrinth = new Maze();
			System.out.println(labyrinth);
			if (labyrinth.traverse()) {
				System.out.println("The maze was successfully traversed!");
			} else {
				System.out.println("There is no possible path.");
			}
			System.out.println(labyrinth);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}