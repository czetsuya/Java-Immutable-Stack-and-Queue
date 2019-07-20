package com.czetsuya.queue;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
public class TestQueue {

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {

		try {
			Queue<Integer> q = ImmutableQueue.empty();
			q = q.enQueue(1);
			q = q.enQueue(2);
			q = q.deQueue();
			System.out.println(q.head());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
