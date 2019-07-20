package com.czetsuya.queue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.Test;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
public class ImmutableQueueTests {

	private final static int ONE_M = 1_000_000;
	private final static int TEN_M = 10_000_000;

	@Test
	void empty_queue_ok() {
		assertNotNull(ImmutableQueue.empty());
	}

	@Test
	@SuppressWarnings("unchecked")
	void enqueue_empty_queue_ok() throws EmptyQueueException, EmptyStackException {

		Queue<Integer> q = ImmutableQueue.empty().enQueue(1);
		assertEquals(1, q.head());
	}

	@Test
	void dequeue_empty_queue_ok() {

		assertThrows(EmptyQueueException.class, () -> {
			ImmutableQueue.empty().deQueue();
		});
	}

	@Test
	void head_empty_queue_ok() {

		assertThrows(EmptyQueueException.class, () -> {
			ImmutableQueue.empty().head();
		});
	}

	@Test
	void isEmpty_empty_queue_ok() {
		assertTrue(ImmutableQueue.empty().isEmpty());
	}

	@SuppressWarnings("unchecked")
	@Test
	void enqueue_non_empty_queue_ok() throws EmptyQueueException, EmptyStackException {

		Queue<Integer> q = ImmutableQueue.empty();
		q = q.enQueue(1);
		assertEquals(1, q.head());
	}

	@SuppressWarnings("unchecked")
	@Test
	void dequeue_non_empty_queue_ok() throws EmptyQueueException, EmptyStackException {

		Queue<Integer> q = ImmutableQueue.empty();
		q = q.enQueue(1);
		Queue<Integer> finalQueue = q.deQueue();
		assertThrows(EmptyQueueException.class, () -> {
			finalQueue.deQueue();
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	void head_non_empty_queue_ok() throws EmptyQueueException, EmptyStackException {

		Queue<Integer> q = ImmutableQueue.empty();
		q = q.enQueue(1);
		assertEquals(1, q.head());
	}

	@SuppressWarnings("unchecked")
	@Test
	void isEmpty_non_empty_queue_ok() {

		Queue<Integer> q = ImmutableQueue.empty();
		q = q.enQueue(1);
		assertFalse(q.isEmpty());
	}

	@SuppressWarnings("unchecked")
	@Test
	void dequeue_isEmpty_queue_ok() throws EmptyQueueException, EmptyStackException {

		Queue<Integer> q = ImmutableQueue.empty();
		q = q.enQueue(1);
		q = q.enQueue(2);
		q = q.deQueue();
		assertEquals(2, q.head());
	}

	@SuppressWarnings("unchecked")
	@Test
	void dequeue_backwards_queue_empty_ok() throws EmptyQueueException, EmptyStackException {

		Queue<Integer> q = ImmutableQueue.empty();
		q = q.enQueue(1);
		q = q.enQueue(2);
		q = q.deQueue();
		q = q.deQueue();
		assertEquals(ImmutableQueue.empty(), q);
	}

	@SuppressWarnings("unchecked")
	@Test
	void enqueueAndDequeue1M_Time() throws Exception {

		Instant start = Instant.now();
		Queue<Integer> q = ImmutableQueue.empty();

		for (int i = 1; i < ONE_M; i++) {
			q = q.enQueue(i);
		}

		for (int i = 1; i < ONE_M - 1; i++) {
			q = q.deQueue();
		}

		assertEquals(ONE_M - 1, q.head());
		q = q.deQueue();
		assertTrue(q.isEmpty());
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Average time taken to enqueue and dequeue 1M elements: " + timeElapsed.toMillis() + " milliseconds");
	}

	@SuppressWarnings("unchecked")
	@Test
	void enqueueAndDequeue10M_Time() throws Exception {

		Instant start = Instant.now();
		Queue<Integer> q = ImmutableQueue.empty();

		for (int i = 1; i < TEN_M; i++) {
			q = q.enQueue(i);
		}

		for (int i = 1; i < TEN_M - 1; i++) {
			q = q.deQueue();
		}

		assertEquals(TEN_M - 1, q.head());
		q = q.deQueue();
		assertTrue(q.isEmpty());
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Average time taken to enqueue and dequeue 10M elements: " + timeElapsed.toMillis() + " milliseconds");
	}

	@SuppressWarnings("unchecked")
	@Test
	void random_queue_dequeue() throws Exception {
		Queue<Integer> q = ImmutableQueue.empty();
		q = q.enQueue(1);
		q = q.enQueue(2);
		q = q.deQueue();

		q = q.enQueue(3);
		q = q.enQueue(4);
		q = q.deQueue();

		assertEquals(3, q.head());
		q = q.deQueue();
		assertEquals(4, q.head());
	}
}
