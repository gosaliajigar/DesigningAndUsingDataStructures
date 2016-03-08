package C4LinkedStructures.Programs;

/**
 * LinkedNode POJO
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class LinkedNode<T> {

	/**
	 * 
	 */
	private LinkedNode<T> next;

	/**
	 * 
	 */
	private T element;

	/**
	 * 
	 */
	public LinkedNode() {
		super();
		this.next = null;
		this.element = null;
	}

	/**
	 * @param element
	 */
	public LinkedNode(T element) {
		super();
		this.next = null;
		this.element = element;
	}

	/**
	 * @return
	 */
	public LinkedNode<T> getNext() {
		return next;
	}

	/**
	 * @param next
	 */
	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}

	/**
	 * @return
	 */
	public T getElement() {
		return element;
	}

	/**
	 * @param element
	 */
	public void setElement(T element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "LinkedNode:[element=" + element + "]";
	}
}
