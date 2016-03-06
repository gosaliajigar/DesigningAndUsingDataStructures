package C3Collections.Exercises;

import C3Collections.Programs.StackADT;

/**
 * Implement Drop-Out stack that behaves like stack in every aspect except that
 * when n+1 element is pushed, 1st element is lost.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP3_5 {

	@SuppressWarnings("unchecked")
	class DropOutStack<T> implements StackADT<T> {

		/**
		 * Default Capacity
		 */
		private int DEFAULT_CAPACITY = 100;

		/**
		 * Top of the stack
		 */
		private int top;

		/**
		 * Internal data structure
		 */
		private T[] stack;

		/**
		 * 
		 */
		public DropOutStack() {
			top = 0;
			stack = (T[]) new Object[DEFAULT_CAPACITY];
		}

		/**
		 * @param intialCapacity
		 */
		public DropOutStack(int intialCapacity) {
			top = 0;
			stack = (T[]) new Object[intialCapacity];
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#push(java.lang.Object)
		 */
		@Override
		public void push(T element) {
			if (size() == stack.length) {
				shiftElements();
				stack[top-1] = element;
			} else {
				stack[top] = element;
				top++;
			}
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#pop()
		 */
		@Override
		public T pop() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP3_5: Empty Stack Exception!");
			}
			top--;
			T result = stack[top];
			stack[top] = null;
			return result;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#peek()
		 */
		@Override
		public T peek() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP3_5: Empty Stack Exception!");
			}
			return stack[top-1];
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			if (top == 0) {
				return true;
			}
			return false;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#size()
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
				if (index != (stack.length-1)) {
					data.append(", ");
				}
			}
			data.append("]");
			return data.toString();
		}

		/**
		 * Shift Elements so that when n+1 element is added, 1st element from
		 * the stack is dropped instead of expanding capacity.
		 */
		private void shiftElements() {
			for (int index=0; index<(stack.length-1); index++) {
				stack[index] = stack[index+1];
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PP3_5 instance = new PP3_5();
		DropOutStack<Integer> stack = instance.new DropOutStack<Integer>(5);
		System.out.println("S(" + stack.size() + "): " + stack);
		for (int index = 0; index < 10; index++) {
			stack.push(index);
			System.out.println("S(" + stack.size() + "): " + stack);
		}
	}
}
