package synchronization.object_level.synchronized_obj2;

import java.util.Random;

public class PrintDemo {
	
	// solution: lock the code within the method that needs to be synchronized
	// 
	// => Best solution in case of performance! 
	// But keep in mind if threads can call different selected 
	// synchronized code blocks at the same time, the chance is higher getting deadlocks.
	public void printCount(Random randomGenerator){
		
		System.out.println(Thread.currentThread().getName() + " doing something that doesn't need to be synchronized ...");

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
