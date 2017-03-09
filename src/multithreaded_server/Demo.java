package multithreaded_server;

public class Demo {

	public static void main(String[] args) {
		Server server = new Server(9000);
		new Thread(server).start();

		try {
		    Thread.sleep(1000 * 1000); // let the main()-thread sleep
		} catch (InterruptedException e) {
		    e.printStackTrace();  
		}
		System.out.println("Stopping Server");
		server.stop();
	}
}
