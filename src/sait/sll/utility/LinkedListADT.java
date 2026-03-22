package sait.sll.utility;

public interface LinkedListADT 
{
	
	boolean isEmpty();

	/**
	 * Clears all elements from this list.
	 */
	void clear();
	
	/**
	 * @param data data to append.
	 */
	void append(Object data);

	/**
	 * Prepends element to the beginning of this list.
	 * @param data data to prepend.
	 */
	void prepend(Object data);
	
	/**
	 * @param index index to insert data at.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size of the list.
	 */
	void insert(Object data, int index) throws IndexOutOfBoundsException;

	/**
	 * Replaces the element at a specific index of this list.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	void replace(Object data, int index) throws IndexOutOfBoundsException;

	/**
	 * Gets the number of elements in this list.
	 * @return size of list (0 meaning empty).
	 */
	int size();

	/**
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	void delete(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Returns the data of the element at the specific index of this list.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	Object retrieve(int index) throws IndexOutOfBoundsException;

	/**
	 * Returns the index of the first occurrence of the element with the specific data in this list.
	 * @return index of the first element with matching data, -1 if not found.
	 */
	int indexOf(Object data);

	/**
	 * Returns true if this list contains an element with specified data, otherwise false.
	 * @return true if element containing data exists, false otherwise.
	 */
	boolean contains(Object data);
}
