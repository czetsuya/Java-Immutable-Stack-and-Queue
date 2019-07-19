package com.czetsuya.queue;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
public class EmptyStackException extends Exception {

	private static final long serialVersionUID = 4080006246718976859L;

	public EmptyStackException() {
		super("Empty stack!");
	}
}
