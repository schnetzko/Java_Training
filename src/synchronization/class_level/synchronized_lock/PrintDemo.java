package synchronization.class_level.synchronized_lock;

import java.util.Random;

public class PrintDemo {
	
	private static final Object lock = new Object();
	
	// Synchronization on class level: Even if there are different PrintDemo objects
	// used by threads and threads are trying to call the synchronized block, 
	// only one thread can call it at the same time, 
	// because only one thread can have the lock-object. 
	public void printCount(Random randomGenerator){
		
		System.out.println(Thread.currentThread().getName() + " doing something that doesn't need to be synchronized ...");

		synchronized (lock) {
			try {
				for (int count = 10; count > 0; count--) {
					System.out.println(Thread.currentThread().getName() + " count: " + count);
					Thread.sleep(randomGenerator.nextInt(500));
				}
			}
			catch (Exception e) {
				System.out.println("Thread interrupted!");
			}
		}
		
		System.out.println(Thread.currentThread().getName() + " doing something that doesn't need to be synchronized ...");
		
	}
}
