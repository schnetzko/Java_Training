package synchronization.object_level.synchronized_obj;

import java.util.Random;

public class PrintDemo {
	
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
