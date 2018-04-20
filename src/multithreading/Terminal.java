package multithreading;


import java.io.*;

public class Terminal implements Runnable{

	
	// TODO: This needs to check!
	/* Thread safe, because it's an primitive data type where its values are immutable.
	 * So main thread and terminal thread can concurrently access on it?! */	
	static boolean quit = false;
	
	BufferedReader in; 
		
	public void run(){
		String msg = null;
		in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter (q)uit to exit this application.");
		
		while (true){
			try {
				msg = in.readLine();
			}
			catch(IOException e){
				System.out.println("Couldn't read from the command line, pls try it again.");
			}
			
			if (msg.equals("q")){
				quit = true;	// inform the main thread, this thread will be terminated now
				try {
					in.close();
				}
				catch (IOException e){
					System.out.println("Problem happens while closing the BufferedReader.");
					e.printStackTrace();
				}
				break;
			} else {			// .. do something like parsing the input, run commands,...				
				System.out.println("echo " + "\"" + msg  + "\"");
			}
		}
	}
	
	public static void main (String args[]){
				
		Thread terminalThread = new Thread(new Terminal());	// At this moment, 2 objects are created - 
															// at first the already created Terminal-object and
															// secondly the now created Thread-object.
															// The Thread-object is initialized by a second created Terminal-object.
		
		terminalThread.start(); // The "main"-thread (Terminal-object) is already running.
								// Now  the "terminal"-thread (Thread-object => contains a Terminal object as well)
								// starts running as well.
		while (true){
			// do something ...
			try{
				Thread.sleep(10);
				// TODO: Would be nice to receiving an event instead of active polling?! 
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if (quit){
				try {
					terminalThread.join();	// To be safe, waiting until "terminal"-thread has "officially" finished his work
										  	// even if "quit" variable was already set to true by the "terminal"-thread.  
					System.out.println("...demo terminated");
				}
				catch (InterruptedException e) {
					System.out.println("...\"terminal\"-thread has not successfully terminated");
				} 
				break;
			}
		}	
	}
};
