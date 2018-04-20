package synchronization.class_level.unsynchronized;

import java.util.Random;

public class PrintDemo {
	
	public void printCount(Random randomGenerator){
		
		System.out.println(Thread.currentThread().getName() + " doing something that doesn't need to be synchronized ...");
		// that's the issue: synchronization on object level using "this", but in this
		// case we want to synchronize this code block on class level to be protected
		// for threads that use different objects of this class.
		synchronized (this) {
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
