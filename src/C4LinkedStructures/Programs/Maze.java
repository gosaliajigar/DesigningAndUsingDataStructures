package C4LinkedStructures.Programs;

import C3Collections.Programs.StackADT;

/**
 * Represents a maze of characters. The goal is to get from the top left corner
 * to the bottom right, following a path of 1’s.
 * 
 * @author "Jigar Gosalia"
 */
public class Maze {

	/**
	 * constant to represent tried paths
	 */
	private final int TRIED = 3;

	/**
	 * constant to represent the final path
	 */
	private final int PATH = 7;

	/**
	 * two dimensional array representing the grid
	 */
	private int[][] grid = {
			{ 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 },
			{ 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
		};

	/**
	 * push a new attempted move onto the stack
	 * 
	 * @param x
	 *            represents x coordinate
	 * @param y
	 *            represents y coordinate
	 * @param stack
	 *            the working stack of moves within the grid
	 * @return StackADT<Position> stack of moves within the grid
	 */
	private StackADT<Position> push_new_pos(int x, int y, StackADT<Position> stack) {
		Position npos = new Position(x, y);
		if (valid(npos.getX(), npos.getY())) {
			System.out.println("  -- Pushing x:" + x + " y:" + y);
			stack.push(npos);
		}
		return stack;
	}

	/**
	 * Attempts to iteratively traverse the maze. It inserts special characters
	 * indicating locations that have been tried and that eventually become part
	 * of the solution. This method uses a stack to keep track of the possible
	 * moves that could be made.
	 * 
	 * @return boolean returns true if the maze is successfully traversed
	 * @throws EmptyCollectionException 
	 */
	public boolean traverse() throws Exception {
		boolean done = false;
		Position pos = new Position();
		StackADT<Position> stack = new LinkedStack<Position>();
		stack.push(pos);
		System.out.println("Grid size x:" + grid.length + " y:" + grid[0].length + "\n");
		while (!done) {
			System.out.println("--------------------------------------------------");
			System.out.println("Stack(" + stack.size() + ") : " + stack.toString());
			pos = stack.pop();
			System.out.println("Popping " + pos.toString());
			// this cell has been tried
			grid[pos.getX()][pos.getY()] = TRIED;
			if (pos.getX() == grid.length - 1
					&& pos.getY() == grid[0].length - 1) {
				// the maze is solved
				done = true;
			} else {
				stack = push_new_pos(pos.getX(), pos.getY() - 1, stack);
				stack = push_new_pos(pos.getX(), pos.getY() + 1, stack);
				stack = push_new_pos(pos.getX() - 1, pos.getY(), stack);
				stack = push_new_pos(pos.getX() + 1, pos.getY(), stack);
			}
		}
		return done;
	}

	/**
	 * Determines if a specific location is valid.
	 * 
	 * @param row
	 *            int representing y coordinate
	 * @param column
	 *            int representing x coordinate
	 * @return boolean true if the given coordinate is a valid move
	 */
	private boolean valid(int row, int column) {
		boolean result = false;
		/** Check if cell is in the bounds of the matrix */
		System.out.println("Checking x:" + row + " y:" + column);
		if (row >= 0 && row < grid.length && column >= 0
				&& column < grid[row].length)
			/** Check if cell is not blocked and not previously tried */
			if (grid[row][column] == 1) {
				result = true;
			}
		return result;
	}

	/**
	 * Returns the maze as a string.
	 * 
	 * @return String representation of the maze grid
	 */
	public String toString() {
		String result = "\n";
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++)
				result += grid[row][column] + "";
			result += "\n";
		}
		return result;
	}
}