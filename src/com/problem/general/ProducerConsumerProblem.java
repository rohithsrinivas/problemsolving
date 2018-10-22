package com.problem.general;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {
	


	public static void main(String[] args) {
		BlockingQueue<Integer> commonQueue = new ArrayBlockingQueue<>(100);
		Consumer consumer = new Consumer(commonQueue);
		Producer producer = new Producer(commonQueue);
		
		new Thread(producer).start();
		new Thread(consumer).start();
		
	}

}
