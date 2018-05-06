package multithreaded_server;

public class Signal {

	public class MonitorObject{

	}
	
	MonitorObject myMonitorObject = new MonitorObject();

	public void doWait(){
		synchronized(myMonitorObject){
			try{
				myMonitorObject.wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public void doNotify(){
		synchronized(myMonitorObject){
			myMonitorObject.notify();
		}
	}
}