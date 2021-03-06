package synchronization.class_level.synchronized_lock;

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
		// consider, the print outs below wont be synchronized
		// only code within printCount(..) will be synchronized
		System.out.println(this.getName() + " starting...");
		this.printDemo.printCount(randomGenerator);
		System.out.println(this.getName() + " exiting...");
	}
}
