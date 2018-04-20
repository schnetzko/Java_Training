package synchronization.object_level.synchronized_obj;

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
		// solution: lock the whole object
		// 
		// => Could lead to a performance degradation, because
		// if there are code lines that could be called by only one thread,
		// but doesn't need to be synchronized like code of other methods of this object.
		synchronized (printDemo) {
			System.out.println(this.getName() + " starting...");
			this.printDemo.printCount(randomGenerator);
			System.out.println(this.getName() + " exiting...");
		}
	}
}
