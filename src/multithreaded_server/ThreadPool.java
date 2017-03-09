package multithreaded_server;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    private boolean isStopped = false;

    // TODO: Does it work without adding and starting threads?
    public ThreadPool(int maxNumberOfTasks){
        taskQueue = new BlockingQueue(maxNumberOfTasks);
    }
    
    /**
     * Constructor for warm-up start, because you can define how much worker threads are already started
     * before the get the first task.
     * 
     * @param numberOfThreads The number of threads which are already initialized to be ready applying
     * for the first task. It doesn't make sense to initialize more threads than maxNumberOfTask.
     * In this case an exception will be thrown.
     * 
     * @param maxNumberOfTasks Initialize the maximum number of tasks that the server can work on at the same time.   
     */
    public ThreadPool(int numberOfThreads, int maxNumberOfTasks){
        taskQueue = new BlockingQueue(maxNumberOfTasks);

        for(int i = 0; i < numberOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }
        for(PoolThread thread : threads){
            thread.start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception{
        if(this.isStopped) throw new IllegalStateException("ThreadPool is stopped");
        this.taskQueue.enqueue(task);
    }

    public synchronized void shutdown(){
        this.isStopped = true;
        for(PoolThread thread : threads){
           thread.doStop();
        }
    }
}