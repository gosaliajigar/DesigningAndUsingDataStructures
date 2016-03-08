package C4LinkedStructures.Programs;

import C3Collections.Programs.StackADT;

/**
 * Linked Structure implementation of Stack
 * 
 * @author "Jigar Gosalia"
 *
 */
public class LinkedStack<T> implements StackADT<T> {

	/**
	 * Number of elements in stack
	 */
	private int count;

	/**
	 * Top of the stack
	 */
	private LinkedNode<T> top;

	/**
	 * Default Constructor
	 */
	public LinkedStack() {
		count = 0;
		top = null;
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#push(java.lang.Object)
	 */
	@Override
	public void push(T element) {
		LinkedNode<T> node = new LinkedNode<T>(element);
		node.setNext(top);
		top = node;
		count++;
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#pop()
	 */
	@Override
	public T pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("LinkedList-Implementation: Empty Stack Exception");
		}
		LinkedNode<T> current = top;
		top = top.getNext();
		current.setNext(null);
		count--;
		return current.getElement();
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#peek()
	 */
	@Override
	public T peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("LinkedList-Implementation: Empty Stack Exception");
		}
		return top.getElement();
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#size()
	 */
	@Override
	public int size() {
		return count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		data.append("[");
		LinkedNode<T> current = top;
		while(current != null) {
			data.append(current.getElement());
			current = current.getNext();
			// Special case to avoid adding ", " to last element
			if (current != null) {
				data.append(", ");
			}
		}
		data.append("]");
		return data.toString();
	}
}
