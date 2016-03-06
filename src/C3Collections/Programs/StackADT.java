package C3Collections.Programs;

/**
 * Stack Abstract Data Type Interface.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public interface StackADT<T> {

	/**
	 * Push elements in stack. <br><br>
	 * 
	 * Time Complexity: Worst Case O(n) & Average Case O(1)
	 * 
	 * @param element
	 */
	public void push(T element);

	/**
	 * Push elements from stack. <br><br>
	 * 
	 * Time Complexity: Worst Case O(1) & Average Case O(1)
	 * 
	 * @return
	 */
	public T pop() throws Exception;

	/**
	 * Peek top most element from stack. <br><br>
	 * 
	 * Time Complexity: Worst Case O(1) & Average Case O(1)
	 * 
	 * @return
	 */
	public T peek() throws Exception;

	/**
	 * Check if stack is empty. <br><br>
	 * 
	 * Time Complexity: Worst Case O(1) & Average Case O(1)
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Get size of stack. <br><br>
	 * 
	 * Time Complexity: Worst Case O(1) & Average Case O(1)
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Print stack. <br><br>
	 * 
	 * Time Complexity: Worst Case O(n) & Average Case O(n)
	 * 
	 * @return
	 */
	public String toString();
}
