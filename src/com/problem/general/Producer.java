package com.problem.general;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	
	BlockingQueue<Integer> sharedQueue;
	
	public Producer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(10);
				sharedQueue.put(i);
				System.out.println(" $$$$$$$$$$$$$$$$$$$$ produced "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		sharedQueue.add(-1);
		System.out.println("done");
	}

}
