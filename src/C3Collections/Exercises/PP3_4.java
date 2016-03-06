package C3Collections.Exercises;

import C3Collections.Programs.StackADT;

/**
 * Rewrite array implementation such that stack[top] is actual top of the stack.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP3_4 {

	@SuppressWarnings("unchecked")
	class ArrayStack<T> implements StackADT<T> {

		/**
		 * 
		 */
		private final int DEFAULT_CAPACITY = 100;

		/**
		 * 
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
			top = -1;
			stack = (T[]) new Object[DEFAULT_CAPACITY];
		}

		/**
		 * Constructor with initial capacity
		 * 
		 * @param intialCapacity
		 */
		public ArrayStack(int intialCapacity) {
			top = -1;
			stack = (T[]) new Object[intialCapacity];
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#push(java.lang.Object)
		 */
		@Override
		public void push(T element) {
			if (size() == (stack.length - 1)) {
				expandCapacity();
			}
			top++;
			stack[top] = element;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#pop()
		 */
		@Override
		public T pop() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP3_4: Empty Stack Exception!");
			}
			T result = stack[top];
			stack[top] = null;
			top--;
			return result;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#peek()
		 */
		@Override
		public T peek() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP3_4: Empty Stack Exception!");
			}
			return stack[top];
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			if (top == -1) {
				return true;
			}
			return false;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#size()
		 */
		@Override
		public int size() {
			return (top + 1);
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
		 * 
		 */
		private void expandCapacity() {
			T[] larger = (T[]) new Object[stack.length * 2];
			for (int index = 0; index < stack.length; index++) {
				larger[index] = stack[index];
			}
			stack = larger;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PP3_4 instance = new PP3_4();
			ArrayStack<Integer> stack = instance.new ArrayStack<Integer>(3);

			System.out.println("Before: " + stack);
			System.out.println("Empty : " + stack.isEmpty());
			System.out.println("Size  : " + stack.size());
			System.out.println("After : " + stack);
			System.out.println("-------");

			stack.push(10);
			System.out.println("Before: " + stack);
			System.out.println("Empty : " + stack.isEmpty());
			System.out.println("Size  : " + stack.size());
			System.out.println("Peek  : " + stack.peek());
			System.out.println("After : " + stack);
			System.out.println("-------");

			stack.push(11);
			System.out.println("Before: " + stack);
			System.out.println("Empty : " + stack.isEmpty());
			System.out.println("Size  : " + stack.size());
			System.out.println("Peek  : " + stack.peek());
			System.out.println("After : " + stack);
			System.out.println("-------");

			System.out.println("Before: " + stack);
			System.out.println("Peek  : " + stack.peek());
			System.out.println("Pop   : " + stack.pop());
			System.out.println("Empty : " + stack.isEmpty());
			System.out.println("Size  : " + stack.size());
			System.out.println("After : " + stack);
			System.out.println("-------");

			System.out.println("Before: " + stack);
			System.out.println("Peek  : " + stack.peek());
			System.out.println("Pop   : " + stack.pop());
			System.out.println("Empty : " + stack.isEmpty());
			System.out.println("Size  : " + stack.size());
			System.out.println("After : " + stack);
			System.out.println("-------");

			System.out.println("Before: " + stack);
			System.out.println("Empty : " + stack.isEmpty());
			System.out.println("Size  : " + stack.size());
			// EXCEPTION will be thrown at below statement as stack is empty by
			// now
			System.out.println("Pop   : " + stack.pop());
			System.out.println("-------");

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
