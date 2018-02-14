package com.shubh.javaworld.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		Thread p = new Thread(new Producer(queue));
		Thread c = new Thread(new Consumer(queue));

		p.start();
		c.start();
	}

}
