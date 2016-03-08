package C4LinkedStructures.Exercises;

import C3Collections.Programs.StackADT;
import C4LinkedStructures.Programs.LinkedNode;

/**
 * Write an algorithm for the add method that will add at the end of the list
 * instead of the beginning. What is the time complexity of this algorithm?
 * <br><br>
 * Assumptions:<br> 
 * 1. Keeping "top" pointing to start of Linked Structure else if
 * top is pointing to last added element then we would need another LinkedNode
 * that will point to starting of the Linked Structure.
 * 
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class EX4_4 {

	class LinkedStack<T> implements StackADT<T> {

		/**
		 * Number of elements in stack
		 */
		private int count;

		/**
		 * As top points to end of the Linked Structure, top will be pointing to
		 * last element in linked structure. Hence we need another LinkedNode to
		 * point to start of Linked Structure.
		 */
		private LinkedNode<T> start;

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
			// Pushing element at the end of the list instead of at the
			// beginning of the linked structure.  
			LinkedNode<T> node = new LinkedNode<T>(element);
			LinkedNode<T> current = start;
			if (current != null) {
				while(current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(node);
			} else {
				start = node;
			}
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
			T element = null;
			LinkedNode<T> previous = null;
			LinkedNode<T> current = start;
			if (current != null) {
				while(current.getNext() != null) {
					previous = current;
					current = current.getNext();
				}
				previous.setNext(null);
				element = current.getElement();
				count--;
			}
			return element;
		}

		/* (non-Javadoc)
		 * @see Chapter3.Programs.StackADT#peek()
		 */
		@Override
		public T peek() throws Exception {
			if (isEmpty()) {
				throw new Exception("LinkedList-Implementation: Empty Stack Exception");
			}
			T element = null;
			LinkedNode<T> current = top;
			if (current != null) {
				while(current.getNext() != null) {
					current = current.getNext();
				}
				element = current.getElement();
			}
			return element;
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
			LinkedNode<T> current = start;
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

	public static void main(String[] args) throws Exception {
		EX4_4 instance = new EX4_4();
		LinkedStack<Integer> stack = instance.new LinkedStack<Integer>();
		System.out.println("S(" + stack.size() + "): " + stack);
		for (int index = 10; index < 20; index++) {
			stack.push(index);
			System.out.println("S(" + stack.size() + "): " + stack);
		}
		System.out.println("-----------------------------");
		for (int index = 10; index < 20; index++) {
			System.out.print("Popping: " + stack.pop());
			System.out.println(" S(" + stack.size() + "): " + stack);
		}
	}
}
