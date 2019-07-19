package com.czetsuya.queue;

/**
 * Interface for an immutable stack. A Stack is a Last In First Out (LIFO) data
 * structure. It supports two basic operations called push and pop. The push
 * operation adds an element at the top of the stack, and the pop operation
 * removes an element from the top of the stack.
 * 
 * Example stack of integers: 1, 2, 3. If we push these integer in order we will
 * get:
 * 
 * <pre>
 * 1
 * 2
 * 3
 * </pre>
 * 
 * Invoking pop will return 1 or the last element entered.
 * 
 * @param <T> generic type for the elements of the stack
 * @author Edward P. Legaspi
 */
public interface Stack<T> {

	/**
	 * Adds element at the top of the immutable stack, and returns the updated
	 * stack.
	 * 
	 * @param e generic type element of stack
	 * @return the updated stack after adding to the top of the stack
	 */
	public Stack<T> push(T e);

	/**
	 * Removes the element from the top of the immutable stack, and returns the
	 * updated stack.
	 * 
	 * @return the updated stack after removing the top element
	 * @throws EmptyStackException when stack is empty
	 */
	public Stack<T> pop() throws Exception;

	/**
	 * Returns the head element or top of the stack.
	 * 
	 * @return top element of the stack
	 * @throws EmptyStackException when stack is empty
	 */
	public T head() throws Exception;

	/**
	 * Checks if this stack is empty.
	 * 
	 * @return true when the stack is empty, false otherwise
	 */
	public boolean isEmpty();
}
