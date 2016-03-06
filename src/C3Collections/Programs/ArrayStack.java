package C3Collections.Programs;

/**
 * Array Implementation of Stack.
 * 
 * @author "Jigar Gosalia"
 * 
 */
@SuppressWarnings("unchecked")
public class ArrayStack<T> implements StackADT<T> {

	/**
	 * Default capacity
	 */
	private int DEFAULT_CAPACITY = 100;

	/**
	 * Top of the stack
	 */
	private int top;

	/**
	 * 
	 */
	private T stack[];

	/**
	 * Default Constructor
	 */
	public ArrayStack() {
		top = 0;
		stack = (T[]) new Object[DEFAULT_CAPACITY];
	}

	/**
	 * Constructor with default capacity
	 * 
	 * @param intialCapacity
	 */
	public ArrayStack(int intialCapacity) {
		top = 0;
		stack = (T[]) new Object[intialCapacity];
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#push(java.lang.Object)
	 */
	@Override
	public void push(T element) {
		if (size() == stack.length) {
			expandCapacity();
		}
		stack[top] = element;
		top++;
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#pop()
	 */
	@Override
	public T pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Array-Implementation: Empty Stack Exception!");
		}
		top--;
		T result = stack[top];
		stack[top] = null;
		return result;
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#peek()
	 */
	@Override
	public T peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Array-Implementation: Empty Stack Exception!");
		}
		return stack[top-1];
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see Chapter3.Programs.StackADT#size()
	 */
	@Override
	public int size() {
		return top;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		data.append("[");
		for (int index = 0; index < stack.length; index++) {
			data.append(stack[index]);
			// Special case for avoiding ", " for the last element
			if (index != (stack.length - 1)) {
				data.append(", ");
			}
		}
		data.append("]");
		return data.toString();
	}

	/**
	 * Expand Capacity of internal data structure when stack is full
	 */
	private void expandCapacity() {
		T[] larger = (T[])new Object[stack.length * 2];
		for (int index = 0; index < stack.length; index++) {
			larger[index] = stack[index];
		}
		stack = larger;
	}
}
