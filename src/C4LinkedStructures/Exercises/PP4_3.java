package C4LinkedStructures.Exercises;

import C3Collections.Programs.StackADT;
import C4LinkedStructures.Programs.LinkedNode;

/**
 * 
 * Create a new version of the LinkedStack<T> class that makes use of a dummy
 * record at the head of the list. <br>
 * <br>
 * 
 * Sentinel node eliminates the special handling of first node during addition
 * or deletion.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class PP4_3 {

	class LinkedStack<T> implements StackADT<T> {

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
		public LinkedStack() {
			count = 0;
			// Sentinel node at head of stack
			top = new LinkedNode<T>(null);
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#push(java.lang.Object)
		 */
		@Override
		public void push(T element) {
			LinkedNode<T> node = new LinkedNode<T>(element);
			LinkedNode<T> next = top.getNext();
			node.setNext(next);
			top.setNext(node);
			count++;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#pop()
		 */
		@Override
		public T pop() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP4_3: Empty Stack Collection!");
			}
			LinkedNode<T> next = top.getNext();
			T element = next.getElement();
			next = next.getNext();
			top.setNext(next);
			count--;
			return element;
		}

		/* (non-Javadoc)
		 * @see C3Collections.Programs.StackADT#peek()
		 */
		@Override
		public T peek() throws Exception {
			if (isEmpty()) {
				throw new Exception("PP4_3: Empty Stack Collection!");
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
			PP4_3 instance = new PP4_3();
			LinkedStack<String> stack = instance.new LinkedStack<String>();
			System.out.println("S(" + stack.size() + "):" + stack);
			for (int index = 1; index <= 10; index++) {
				stack.push(String.valueOf(index));
			}
			System.out.println("S(" + stack.size() + "):" + stack);
			while (!stack.isEmpty()) {
				stack.pop();
				System.out.println("S(" + stack.size() + "):" + stack);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
