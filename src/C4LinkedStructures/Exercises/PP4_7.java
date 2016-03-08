package C4LinkedStructures.Exercises;

import C3Collections.Programs.StackADT;
import C4LinkedStructures.Programs.LinkedNode;

/**
 * The linked implementation in this chapter uses a count variable to keep track
 * of the number of elements in the stack. Rewrite the linked implementation
 * without a count variable.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP4_7 {

	class LinkedStack<T> implements StackADT<T> {

		/**
		 * 
		 */
		private LinkedNode<T> top;

		/**
		 * 
		 */
		public LinkedStack() {
			top = null;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#push(java.lang.Object)
		 */
		@Override
		public void push(T element) {
			LinkedNode<T> node = new LinkedNode<T>(element);
			node.setNext(top);
			top = node;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#pop()
		 */
		@Override
		public T pop() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP4_7: Empty Stack Collection!");
			}
			LinkedNode<T> current = top;
			top = top.getNext();
			current.setNext(null);
			return current.getElement();
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#peek()
		 */
		@Override
		public T peek() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP4_7: Empty Stack Collection!");
			}
			return top.getElement();
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			// Without count variable, there are 2 ways to check if stack is
			// empty or not .... 
			// 1. O(1) : check if top is NULL
			// 2. O(n) : traverse stack and find the no. of elements in stack
			if (top == null) {
				return true;
			}
			return false;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#size()
		 */
		@Override
		public int size() {
			// Without count variable, time complexity increases from O(1) to
			// O(n).
			LinkedNode<T> current = top;
			int count = 0;
			while (current != null) {
				current = current.getNext();
				count++;
			}
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PP4_7 instance = new PP4_7();
			LinkedStack<Integer> stack = instance.new LinkedStack<Integer>();
			for (int index = 0; index < 10; index++) {
				stack.push(index);
			}
			while (!stack.isEmpty()) {
				System.out.println("S(" + stack.isEmpty() + "): " + stack);
				stack.pop();
			}
			System.out.println("S(" + stack.isEmpty() + "): " + stack);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
