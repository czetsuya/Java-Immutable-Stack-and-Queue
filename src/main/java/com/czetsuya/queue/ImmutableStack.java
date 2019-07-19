package com.czetsuya.queue;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
public final class ImmutableStack<T> implements Stack<T> {

	private final T value;
	private final Stack<T> tail;

	private ImmutableStack(T value, Stack<T> tail) {
		this.value = value;
		this.tail = tail;
	}

	@Override
	public Stack<T> push(T e) {
		return new ImmutableStack<>(e, this);
	}

	@Override
	public Stack<T> pop() {
		return tail;
	}

	@Override
	public T head() {
		return value;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@SuppressWarnings("rawtypes")
	public static final Stack emptyStack() {
		return EmptyStack.getInstance();
	}

	private static final class EmptyStack<T> implements Stack<T> {

		@SuppressWarnings("rawtypes")
		private static final EmptyStack instance = new EmptyStack();

		@SuppressWarnings("rawtypes")
		public static final EmptyStack getInstance() {
			return instance;
		}

		@Override
		public Stack<T> push(T e) {
			return new ImmutableStack<>(e, this);
		}

		@Override
		public Stack<T> pop() throws Exception {
			throw new EmptyStackException();
		}

		@Override
		public T head() throws Exception {
			throw new EmptyStackException();
		}

		@Override
		public boolean isEmpty() {
			return true;
		}
	}
}
