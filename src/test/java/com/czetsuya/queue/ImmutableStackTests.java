package com.czetsuya.queue;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.Test;

/**
 * Tests for Immutable Stack.
 * 
 * There are some extra tests that compute the average run time to push and pop
 * 1M and 10M elements.
 * 
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
public class ImmutableStackTests {

	private final static int ONE_M = 1_000_000;
	private final static int TEN_M = 10_000_000;

	@SuppressWarnings("unchecked")
	@Test
	void emptyStack_push_Ok() throws Exception {
		assertEquals(1, ImmutableStack.emptyStack().push(1).head());
	}

	@Test
	void emptyStack_pop_Ok() throws Exception {

		assertThrows(EmptyStackException.class, () -> {
			ImmutableStack.emptyStack().pop();
		});
	}

	@Test
	void emptyStack_head_Ok() throws Exception {

		assertThrows(EmptyStackException.class, () -> {
			ImmutableStack.emptyStack().head();
		});
	}

	@Test
	void emptyStack_isEmpty_Ok() {
		assertTrue(ImmutableStack.emptyStack().isEmpty());
	}

	@SuppressWarnings("unchecked")
	@Test
	void popAndPush1M_Time() throws Exception {

		Instant start = Instant.now();
		Stack<Integer> stack = ImmutableStack.emptyStack();

		for (int i = 1; i < ONE_M; i++) {
			stack = stack.push(i);
		}

		for (int i = 1; i < ONE_M - 1; i++) {
			stack = stack.pop();
		}

		assertEquals(1, stack.head());
		stack = stack.pop();
		assertTrue(stack.isEmpty());
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Average time taken to push and pop 1M elements: " + timeElapsed.toMillis() + " milliseconds");
	}

	@SuppressWarnings("unchecked")
	@Test
	void popAndPush10M_Time() throws Exception {

		Instant start = Instant.now();
		Stack<Integer> stack = ImmutableStack.emptyStack();

		for (int i = 1; i < TEN_M; i++) {
			stack = stack.push(i);
		}

		for (int i = 1; i < TEN_M - 1; i++) {
			stack = stack.pop();
		}

		assertEquals(1, stack.head());
		stack = stack.pop();
		assertTrue(stack.isEmpty());
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Average time taken to push and pop 10M elements: " + timeElapsed.toMillis() + " milliseconds");
	}
}