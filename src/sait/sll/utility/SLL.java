package sait.sll.utility;

import java.io.Serializable;

/**
 * Singly linked list implementation.
 * @version 2025
 *
 */
public class SLL implements LinkedListADT, Serializable {
	private static final long serialVersionUID = 1L;

	private Node head;
	private Node tail;
	private int size;

	/**
	 * Returns true if the list is empty.
	 * @return true if empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	/**
	 * Clears the list.
	 */
	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Adds data to the end of the list.
	 * @param data data to append.
	 */
	@Override
	public void append(Object data) {
		Node newNode = new Node(data);

		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}

		this.size++;
	}

	/**
	 * Adds data to the beginning of the list.
	 * @param data data to prepend.
	 */
	@Override
	public void prepend(Object data) {
		Node newNode = new Node(data);

		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.setNext(this.head);
			this.head = newNode;
		}

		this.size++;
	}

	/**
	 * Inserts data at a specific index.
	 * @param data data to insert.
	 * @param index index to insert at.
	 * @throws IndexOutOfBoundsException when index is invalid.
	 */
	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		if (index == 0) {
			this.prepend(data);
		} else if (index == this.size) {
			this.append(data);
		} else {
			Node newNode = new Node(data);
			Node previous = this.getNode(index - 1);

			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
			this.size++;
		}
	}

	/**
	 * Replaces data at a specific index.
	 * @param data replacement data.
	 * @param index index to replace.
	 * @throws IndexOutOfBoundsException when index is invalid.
	 */
	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		Node current = this.getNode(index);
		current.setData(data);
	}

	/**
	 * Gets the number of items in the list.
	 * @return size of list.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Deletes data at a specific index.
	 * @param index index to delete.
	 * @throws IndexOutOfBoundsException when index is invalid.
	 */
	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		if (index == 0) {
			this.head = this.head.getNext();

			if (this.size == 1) {
				this.tail = null;
			}
		} else {
			Node previous = this.getNode(index - 1);
			Node current = previous.getNext();

			previous.setNext(current.getNext());

			if (current == this.tail) {
				this.tail = previous;
			}
		}

		this.size--;
	}

	/**
	 * Retrieves the data at a specific index.
	 * @param index index to retrieve.
	 * @return data at index.
	 * @throws IndexOutOfBoundsException when index is invalid.
	 */
	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		return this.getNode(index).getData();
	}

	/**
	 * Finds the index of matching data.
	 * @param data data to find.
	 * @return matching index, or -1 if not found.
	 */
	@Override
	public int indexOf(Object data) {
		Node current = this.head;
		int index = 0;

		while (current != null) {
			Object currentData = current.getData();

			if (currentData == null) {
				if (data == null) {
					return index;
				}
			} else if (currentData.equals(data)) {
				return index;
			}

			current = current.getNext();
			index++;
		}

		return -1;
	}

	/**
	 * Checks if matching data exists in the list.
	 * @param data data to find.
	 * @return true if found, false otherwise.
	 */
	@Override
	public boolean contains(Object data) {
		return this.indexOf(data) >= 0;
	}

	/**
	 * Gets the node at the specified index.
	 * @param index index to search.
	 * @return node at index.
	 * @throws IndexOutOfBoundsException when index is invalid.
	 */
	private Node getNode(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		Node current = this.head;

		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}

		return current;
	}
}
