package synchronization.class_level.unsynchronized;

import java.util.Random;

public class Demo {
	public static void main(String args[]) {
		
		// the objects which has a method that should by synchronized normally
		PrintDemo printDemoA = new PrintDemo();
		PrintDemo printDemoB = new PrintDemo();
		
		// to force an unsynchronized behavior
		Random randomGenerator = new Random();
		
		// both threads uses the same randomGenerator
		ThreadDemo threadDemoA = new ThreadDemo("Thread A", printDemoA, randomGenerator);
		ThreadDemo threadDemoB = new ThreadDemo("Thread B", printDemoB, randomGenerator);
		
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

