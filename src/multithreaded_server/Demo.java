package multithreaded_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

	/**
	 * Starts a HTTP-server which is waiting for client request on port http://localhost:<port number> 
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer outputStr = new StringBuffer();
		outputStr.append("DEMO - HTTP-Server\n");
		outputStr.append("(p)ort where the server is going to be listen for client requests\n");
		outputStr.append("(q)uit to exit\n");
		String inputStr = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int server_port = 8080;	// default port
		boolean stopApplication = true;
		
		while (true && stopApplication){
			try {
				System.out.println(outputStr);
				inputStr = br.readLine();
			}
			catch (IOException e){
				e.printStackTrace();
				System.out.println("Could not read data from console, try it again!");
				System.out.print(outputStr);
				continue;
			}
			// (q)uit - handling
			if (inputStr.equals("q")){
				break;
			}
			// (n)umber of arrays handling
			else if(inputStr.equals("p")){
				System.out.print("port number: ");
				try {
					inputStr = br.readLine();
					server_port = Integer.parseInt(inputStr);
				}
				catch (IOException e){
					// e.printStackTrace(); // uncommented, because doesn't look good printing an exception on console
					System.out.println("Could not read data from console, try it again!"); // TODO: Is there a chance to avoid this redundant code somehow?
					System.out.print(outputStr.toString());
					continue;
				}
				catch (NumberFormatException e){
					// e.printStackTrace(); // uncommented, because doesn't look good printing an exception on console
					System.out.println("Incorrect number format, try it again!"); // TODO: Is there a chance to avoid this redundant code somehow?
					System.out.print(outputStr.toString());
					continue;
				}
				System.out.println("DEMO HTTP-Server will be started now...");
				Server server = new Server(server_port);
				// starts the main server thread
				new Thread(server, "HTTP-Server").start();
				
				// this console thread is still waiting for console-input				
				while (true){
					try {
						System.out.println("(q)uit to exit\n");
						inputStr = br.readLine();
					}
					catch (IOException e){
						e.printStackTrace();
						System.out.println("Could not read data from console, try it again!");
						System.out.print(outputStr.toString());
						continue;
					}
					// (q)uit - handling
					if (inputStr.equals("q")){
						System.out.println("HTTP-Server will be stopped now...");
						server.stop();
						stopApplication = false; // to break out of the outer while loop
						break;
					}
				}
			}
		}	
		
//		Server server = new Server(9000);
//
//		// starts the main server thread
//		new Thread(server, "HTTP-Server").start();
//		
////		Signal signal = new Signal();
//
//		try {
////			signal.doWait();  // wait until waked up by another thread who is using this object to signal
//							  
//			Thread.sleep(1000 * 1000);	// let the main()-thread sleep
//		    							// TODO: let's the main-thread sleep until he get't a signal to terminate
//		} catch (InterruptedException e) {
//		    e.printStackTrace();  
//		}
		System.out.println("Application terminated.");
//		server.stop();

	}
}
