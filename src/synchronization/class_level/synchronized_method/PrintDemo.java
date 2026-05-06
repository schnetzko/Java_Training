package synchronization.class_level.synchronized_method;

import java.util.Random;

public class PrintDemo {
	
	// Synchronization on class level: Even if there are multiple PrintDemo objects
	// used by threads and threads are trying to call this synchronized static method, 
	// only one thread can execute it at the same time.
	public synchronized static void printCount(Random randomGenerator){
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
