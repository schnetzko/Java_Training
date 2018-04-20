package synchronization.object_level.synchronized_lock;

import java.util.Random;

public class Demo {
	public static void main(String args[]) {
		
		// the object which has a method that should by synchronized normally
		PrintDemo printDemo = new PrintDemo();
		
		// to force an unsynchronized behavior
		Random randomGenerator = new Random();
		
		// both threads uses the same randomGenerator
		ThreadDemo threadDemoA = new ThreadDemo("Thread A", printDemo, randomGenerator);
		ThreadDemo threadDemoB = new ThreadDemo("Thread B", printDemo, randomGenerator);
		
		threadDemoA.start();
		threadDemoB.start();
		
		try {
			threadDemoA.join();
			threadDemoB.join();
		}
		catch (InterruptedException e) {
			System.out.println("At least one thread interruppted.");
		}
	}
}

