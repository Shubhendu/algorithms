/**
 * 
 */
package com.shubh.javaworld.producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author SSingh
 *
 */
public class Producer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void produce(int i) {
		try {
			this.queue.put(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.produce(i);
			System.out.println("Produced: " + i);
		}

	}

}
