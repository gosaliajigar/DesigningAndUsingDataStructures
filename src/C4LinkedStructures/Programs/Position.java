package C4LinkedStructures.Programs;

/**
 * Position POJO for Maze search
 * 
 * @author "Jigar Gosalia"
 *
 */
public class Position {

	int x;

	int y;

	/**
	 * 
	 */
	public Position() {}

	/**
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pos:[x=" + x +  "; y=" + y + "]";
	}
}
