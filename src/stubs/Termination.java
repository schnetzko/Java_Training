package stubs;


import java.io.*;

public class Termination implements Runnable{

	static BufferedReader in; 
	
	/* Thread safe, because it's an immutable data type.
	 * So main thread and terminal thread can concurrently access on it. */
	static boolean quit = false;
	
	public void run(){
		String msg = null;
		
		while (true){
			try {
				msg = in.readLine();
			}
			catch(IOException e){
				e.printStackTrace();
			}
			
			if (msg.equals("q")){
				quit = true;
				break;
			}
		}
	}
	
	public static void main (String args[]){
		in = new BufferedReader(new InputStreamReader(System.in));
		Thread terminalThread = new Thread(new Termination());
		terminalThread.start();
		System.out.println("Enter (q)uit to exit this application.");
		while (true){
			// do something ...
			try{
				/* Let's the main thread sleep a little bit that the terminal thread
				 * can take over the control during this time to check the terminal input. */
				Thread.sleep(10);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if (quit){
				System.out.println("...application terminated");
				break;
			}
		}	
	}
};
