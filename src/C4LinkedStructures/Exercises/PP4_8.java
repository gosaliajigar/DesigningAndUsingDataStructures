package C4LinkedStructures.Exercises;

import C3Collections.Programs.StackADT;
import C4LinkedStructures.Programs.LinkedNode;

/**
 * There is a data structure called a drop-out stack that behaves like a stack
 * in every respect except that if the stack size is n, when the n+1 element is
 * pushed, the first element is lost. Implement a drop-out stack using links.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP4_8 {

	class DropOutStack<T> implements StackADT<T> {

		/**
		 * Max Capacity of the Linked Structure after which elements will be
		 * popped from top of the stack.
		 */
		private static final int MAX_CAPACITY = 5;

		/**
		 * 
		 */
		private int count;

		/**
		 * 
		 */
		private LinkedNode<T> top;

		/**
		 * 
		 */
		public DropOutStack() {
			count = 0;
			top = null;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#push(java.lang.Object)
		 */
		@Override
		public void push(T element) {
			LinkedNode<T> node = new LinkedNode<T>(element);
			if (count < MAX_CAPACITY) {
				count++;
			} else {
				shiftElements();
			}
			node.setNext(top);
			top = node;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#pop()
		 */
		@Override
		public T pop() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP4_8: Empty Stack Exception!");
			}
			LinkedNode<T> current = top;
			top = top.getNext();
			current.setNext(null);
			count--;
			return current.getElement();
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#peek()
		 */
		@Override
		public T peek() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP4_8: Empty Stack Exception!");
			}
			return top.getElement();
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			if (count == 0) {
				return true;
			}
			return false;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#size()
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
			while (current != null) {
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

		private void shiftElements() {
			LinkedNode<T> previous = null;
			LinkedNode<T> current = top;
			while (current.getNext() != null) {
				previous = current;
				current = current.getNext();
			}
			previous.setNext(null);
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PP4_8 instance = new PP4_8();
		DropOutStack<Integer> stack = instance.new DropOutStack<Integer>();
		System.out.println("S(" + stack.size() + "): " + stack);
		for (int index = 0; index < 10; index++) {
			stack.push(index);
			System.out.println("S(" + stack.size() + "): " + stack);
		}
	}

}
