package com.problem.general;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
	
	BlockingQueue<Integer> sharedQueue;
	
	public Consumer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		try {
			Integer message;
			while((message = sharedQueue.take()) != -1) {
					Thread.sleep(10);
					System.out.println(" #################### consumed "+message);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done consuming");
	}

}