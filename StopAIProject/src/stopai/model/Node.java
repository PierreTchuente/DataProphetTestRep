package stopai.model;

import stopai.List_Iter_Col.Position;

/**
 * A node in the Position List (this is just a doubly-linked node)
 *
 * @param <T> the object type for this node
 */
public class Node<T> implements Position<T> {
	private T element;
	private Node<T> next;
	private Node<T> prev;
	
	public Node(Node<T> next, Node<T> prev, T element) {
		this.next = next;
		this.prev = prev;
		this.element = element;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
		this.next = null;
		this.prev = null;
		this.element = null;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getPrev() {
		return this.prev;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	public String toString() {
		if (element == null) {
			return "<>";
		}
		return "<" + element.toString() + ">";
	}

	@Override
	public T element() {
		return element;
	}
}
