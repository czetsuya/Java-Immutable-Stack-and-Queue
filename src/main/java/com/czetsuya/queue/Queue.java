package com.czetsuya.queue;

/**
 * Interface for an immutable queue. A Queue is a First In First Out (FIFO) data
 * structure. It supports two basic operations called enQueue and deQueue. The
 * enQueue operation adds an element at the beginning of the queue, and the
 * deQueue operation removes an element from the end of the queue.
 * 
 * Example queue of integers: 1, 2, 3. If we queue these integer in order we
 * will get:
 * 
 * <pre>
 * 1 -> 2 -> 3
 * </pre>
 * 
 * Invoking deQueue will return 3 or the first element entered.
 * 
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
public interface Queue<T> {

	/**
	 * Adds element at the beginning of the immutable queue, and returns the updated
	 * queue.
	 * 
	 * @param e generic type element of queue
	 * @return the updated queue after adding to the beginning of the queue
	 */
	public Queue<T> enQueue(T t);

	/**
	 * Removes the element from the end of the immutable queue, and returns the
	 * updated queue.
	 * 
	 * @return the updated queue after removing the last element
	 * @throws EmptyQueueException when queue is empty
	 * @throws EmptyStackException when stack is empty
	 */
	public Queue<T> deQueue() throws EmptyQueueException, EmptyStackException;

	/**
	 * Returns the head or first element of the queue.
	 * 
	 * @return first element of the queue
	 * @throws EmptyQueueException when queue is empty
	 * @throws EmptyStackException when stack is empty
	 */
	public T head() throws EmptyQueueException, EmptyStackException;

	/**
	 * Checks if this queue is empty.
	 * 
	 * @return true when the queue is empty, false otherwise
	 */
	public boolean isEmpty();
}
