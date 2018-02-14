/**
 * 
 */
package com.shubh.javaworld.producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author SSingh
 *
 */
public class Consumer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> q) {
		this.queue = q;
	}

	public void consumes() {
		while (!queue.isEmpty()) {
			try {
				System.out.println("Consumed: " + queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			consumes();
		}

	}

}
