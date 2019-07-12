package trafficLightSwitcher;

public class TrafficLightThread implements Runnable {
	Thread thrd;
	boolean stopped = false;
	TrafficLightThread(String name) {
		// Construct a new Thread
		thrd = new Thread(this, name);
		thrd.start();	// start the thread
	}
	public void run() {
		// Begin Execution of Thread
		try {
			while(!stopped) {
				for(TrafficLightSimulator.Light color : TrafficLightSimulator.Light.values()) {
					synchronized(this) {
						if(stopped) {
							break;
						}
					}
					System.out.print("Light is " + color);
					switch(color) {
						case Green: 
							System.out.println(" - Go!");
							Thread.sleep(5000);
							synchronized(this) {
								if(stopped) {
									break;
								}
							}
							break;
						case Yellow:
							System.out.println(" - Beware!");
							Thread.sleep(2000);
							synchronized(this) {
								if(stopped) {
									break;
								}
							}
							break;
						case Red:
							System.out.println(" - Stop!");
							Thread.sleep(3000);
							synchronized(this) {
								if(stopped) {
									break;
								}
							}
							break;
						default:
					}
				}
			};
		}catch(InterruptedException exc) {
			System.out.println("Thread " + thrd.getName() + " interrupted.");
		}
	}
	synchronized void mystop() {
		// Stop the Thread
		stopped = true;
		notify();
	}
}
