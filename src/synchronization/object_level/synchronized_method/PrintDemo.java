package synchronization.object_level.synchronized_method;

import java.util.Random;

public class PrintDemo {
	
	// solution: lock the method
	// 
	// => Much better than locking the whole object,
	// but could still lead to a performance degradation, because
	// if there are code lines within this method that could be called by only one thread,
	// but doesn't need to be synchronized.
	public synchronized void printCount(Random randomGenerator){
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
}
