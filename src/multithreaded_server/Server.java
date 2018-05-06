package multithreaded_server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
// import java.util.concurrent.ExecuterService
// import java.util.concurrent.Executers

public class Server implements Runnable{

    protected int			serverPort = 8080; /* default */
    protected ServerSocket	serverSocket = null;
    protected String		serverName = null;
    protected boolean		isStopped = false;
    protected Thread		runningThread= null;
    protected ThreadPool	threadPool = new ThreadPool(1, 10);
    //    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public Server(int port){
        this.serverPort = port;
    }

//    public Server(int port, String serverName){
//        this.serverPort = port;
//        this.serverName = serverName;
//    }
    
    public void run(){
        synchronized(this){		// TODO: Why is synchronization needed here?
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();

        /* handle client requests */        
        while(!isStopped()){
            Socket clientSocket = null;
            try {
            	// System.out.println("Server is running now...");
            	/* listening for client request */
            	System.out.println("\"" + this.runningThread + "\" port " + this.serverPort + ": waiting for HTTP-Client request...");
                clientSocket = this.serverSocket.accept();
            } 
            catch (IOException e) {
                if(isStopped()) {
                    // System.out.println("Server stopped listing for request...") ;
                    break;
                }
                throw new RuntimeException(
                    "Error accepting client connection", e);
            }            
            try {
            	System.out.println("\"" + this.runningThread + "\" port " + this.serverPort + ": incoming HTTP-Client request, trying to instruct a worker thread...");
            	this.threadPool.execute(new WorkerThread(clientSocket, "Worker Thread from Thread Pool"));
            }
            catch (Exception e){
            	e.printStackTrace();
            }
//            this.threadPool.execute(new WorkerRunnable(clientSocket,"Worker Thread from Thread Pool"));
        }
        
        this.threadPool.shutdown(); // similar to ExecuterService.shutdown()?
        // System.out.println("HTTP-Server has stopped now...");
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } 
        catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } 
        catch (IOException e) {
            throw new RuntimeException("Cannot open port " + this.serverPort, e);
        }
    }
}