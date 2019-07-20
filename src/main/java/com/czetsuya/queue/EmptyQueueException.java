package com.czetsuya.queue;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
public class EmptyQueueException extends Exception {

	private static final long serialVersionUID = 4080006246718976859L;

	public EmptyQueueException() {
		super("Empty queue!");
	}
}
