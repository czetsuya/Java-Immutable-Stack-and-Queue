package com.czetsuya.queue;

/**
 * A concrete class that represents an Immutable Queue.
 * 
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 * @param <T> generic type for elements of Queue
 * @see Queue
 */
public final class ImmutableQueue<T> implements Queue<T> {

	private final Stack<T> backwards;
	private final Stack<T> forwards;

	private ImmutableQueue(Stack<T> forwards, Stack<T> backwards) {
		this.forwards = forwards;
		this.backwards = backwards;
	}

	@SuppressWarnings("rawtypes")
	public static final Queue empty() {
		return EmptyQueue.getInstance();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final Stack reverseStack(Stack stack) throws EmptyStackException {

		Stack r = ImmutableStack.empty();
		for (Stack f = stack; !f.isEmpty(); f = f.pop()) {
			r = r.push(f.head());
		}

		return r;
	}

	@Override
	public final Queue<T> enQueue(T e) {
		return new ImmutableQueue<>(forwards, backwards.push(e));
	}

	@SuppressWarnings("unchecked")
	@Override
	public final Queue<T> deQueue() throws EmptyQueueException, EmptyStackException {

		Stack<T> f = forwards.pop();
		if (!f.isEmpty()) {
			return new ImmutableQueue<>(f, backwards);

		} else if (backwards.isEmpty()) {
			return ImmutableQueue.empty();

		} else {
			return new ImmutableQueue<>(ImmutableQueue.reverseStack(backwards), ImmutableStack.empty());
		}
	}

	@Override
	public final T head() throws EmptyQueueException, EmptyStackException {
		return forwards.head();
	}

	@Override
	public final boolean isEmpty() {
		return false;
	}

	/**
	 * A singleton class that represents an empty Queue.
	 * 
	 * @author Edward P. Legaspi <czetsuya@gmail.com>
	 *
	 * @param <T> generic type for elements of Queue
	 * @see Queue
	 */
	private static final class EmptyQueue<T> implements Queue<T> {

		@SuppressWarnings("rawtypes")
		private static final EmptyQueue instance = new EmptyQueue();

		@SuppressWarnings("rawtypes")
		public static final EmptyQueue getInstance() {
			return instance;
		}

		@SuppressWarnings("unchecked")
		@Override
		public final Queue<T> enQueue(T e) {
			return new ImmutableQueue<>(ImmutableStack.empty().push(e), ImmutableStack.empty());
		}

		@Override
		public final Queue<T> deQueue() throws EmptyQueueException {
			throw new EmptyQueueException();
		}

		@Override
		public final T head() throws EmptyQueueException {
			throw new EmptyQueueException();
		}

		@Override
		public final boolean isEmpty() {
			return true;
		}
	}
}
