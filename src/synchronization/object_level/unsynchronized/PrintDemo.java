package synchronization.object_level.unsynchronized;

import java.util.Random;

public class PrintDemo {
	
	// method that should be normally synchronized
	// leads to a unpredictable behavior
	public void printCount(Random randomGenerator){
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
