package synchronization.object_level.synchronized_obj2;

import java.util.Random;

public class ThreadDemo extends Thread {

	PrintDemo printDemo;
	Random randomGenerator;
	
	public ThreadDemo(String threadName, PrintDemo printDemo, Random randomGenerator){
		this.setName(threadName);
		this.printDemo = printDemo;
		this.randomGenerator = randomGenerator;
	}
	
	/*
	 * - overwriting this method
	 * - concurrent run/access
	 * 
	 * @see java.lang.Thread#run() */
	public void run() {
		System.out.println(this.getName() + " starting...");
		this.printDemo.printCount(randomGenerator);
		System.out.println(this.getName() + " exiting...");
	}
}
