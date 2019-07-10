
public class MyThread implements Runnable {
	Thread thrd;
	boolean suspended;
	boolean stopped;
	// Construct a new thread.
	MyThread(String name) {
		thrd = new Thread(this, name);
		thrd.start();	// start the thread
	}
	// Begin execution of new thread.
	public void run() {
		System.out.println("Thread " + thrd.getName() + " starting.");
		try {
			for(int count=0; count < 100; count++) {
				System.out.println("Executing Thread " + thrd.getName());
				Thread.sleep(1000);
				// Use synchronized block to check suspended and stopped.
				synchronized(this) {
					while(suspended) {
//						System.out.println("suspended from running");
						wait();
					}
//					System.out.println("not suspended from running");
					if(stopped) {
						break;
					}
				}
			}
		}
		catch(InterruptedException exc) {
			System.out.println("Thread " + thrd.getName() + " interrupted.");
		}
		System.out.println("Thread " + thrd.getName() + " terminating.");
	}
	// Stop the thread.
	synchronized void mystop() {
		stopped = true;
		// The following ensures that a suspended thread can be stopped.
		System.out.println("Permanently stopping the execution of Thread " + thrd.getName());
		suspended = false;
		notify();
	}
	// Suspend the thread.
	synchronized void mysuspend() {
		System.out.println("Pausing Thread " + thrd.getName());
		suspended = true;
	}
	// Resume the thread.
	synchronized void myresume() {
		System.out.println("Resuming Thread " + thrd.getName());
		suspended = false;
		notify();
	}
}
