package sait.sll.utility;

import java.io.Serializable;

/**
 * Represents a node in the linked list.
 * @version 2025
 *
 */
public class Node implements Serializable {
	private static final long serialVersionUID = 1L;

	private Object data;
	private Node next;

	/**
	 * Creates a node with data.
	 * @param data data stored in the node.
	 */
	public Node(Object data) {
		this.data = data;
	}

	/**
	 * Gets the data in the node.
	 * @return data in the node.
	 */
	public Object getData() {
		return this.data;
	}

	/**
	 * Sets the data in the node.
	 * @param data data to set.
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * Gets the next node.
	 * @return next node reference.
	 */
	public Node getNext() {
		return this.next;
	}

	/**
	 * Sets the next node.
	 * @param next next node reference.
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}
