import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		System.out.println("Main thread Starting.");
		MyThread mt1 = new MyThread("1");
		MyThread mt2 = new MyThread("2");
		MyThread mt3 = new MyThread("3");
		MyThread mt4 = new MyThread("4");
		MyThread mt5 = new MyThread("5");
		
		JFrame frame = new JFrame("Key Listener");
		Container contentPane = frame.getContentPane();
		KeyListener listener = new KeyListener() {
			byte threadInControl = 0;
			@Override
			public void keyPressed(KeyEvent event) {
				sendCommands(event);
			}
			@Override
			public void keyReleased(KeyEvent event) {
			}
			@Override
			public void keyTyped(KeyEvent event) {
			}
			private void sendCommands(KeyEvent e) {
				int code = e.getKeyCode();
				if(threadInControl == 0) {
					// Default thread until user chooses one of the threads to access.
					switch(KeyEvent.getKeyText(code)) {
					case("1"):
						threadInControl = 1;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("2"):
						threadInControl = 2;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("3"):
						threadInControl = 3;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("4"):
						threadInControl = 4;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("5"):
						threadInControl = 5;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					default:
					}
				}else if(threadInControl == 1) {
					// Control Thread 1
					switch(KeyEvent.getKeyText(code)) {
					case("1"):
						if(!mt1.suspended) {
							mt1.mysuspend();
						}else {
							mt1.myresume();
						}
						break;
					case("T"):
						System.out.println("Setting High Priority");
						mt1.thrd.setPriority(8);
						break;
					case("L"):
						System.out.println("Setting Low Priority");
						mt1.thrd.setPriority(2);
						break;
					case("N"):
						System.out.println("Setting Normal Priority");
						mt1.thrd.setPriority(5);
						break;
					case("S"):
						mt1.mystop();
						System.out.println("Available Threads are:");
						if(mt1.thrd.isAlive()) {
							System.out.println("Thread " + mt1.thrd.getName() + ": " + mt1.thrd.getState() + " - Press Key " + mt1.thrd.getName() + " to control");
						}
						if(mt2.thrd.isAlive()) {
							System.out.println("Thread " + mt2.thrd.getName() + ": " + mt2.thrd.getState() + " - Press Key " + mt2.thrd.getName() + " to control");
						}
						if(mt3.thrd.isAlive()) {
							System.out.println("Thread " + mt3.thrd.getName() + ": " + mt3.thrd.getState() + " - Press Key " + mt3.thrd.getName() + " to control");
						}
						if(mt4.thrd.isAlive()) {
							System.out.println("Thread " + mt4.thrd.getName() + ": " + mt4.thrd.getState() + " - Press Key " + mt4.thrd.getName() + " to control");
						}
						if(mt5.thrd.isAlive()) {
							System.out.println("Thread " + mt5.thrd.getName() + ": " + mt5.thrd.getState() + " - Press Key " + mt5.thrd.getName() + " to control");
						}
						break;
					case("2"):
						threadInControl = 2;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("3"):
						threadInControl = 3;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("4"):
						threadInControl = 4;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("5"):
						threadInControl = 5;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					default:
					}
				}else if(threadInControl == 2) {
					// Control Thread 2
					switch(KeyEvent.getKeyText(code)) {
					case("1"):
						threadInControl = 1;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("2"):
						if(!mt2.suspended) {
							mt2.mysuspend();
						}else {
							mt2.myresume();
						}
						break;
					case("T"):
						System.out.println("Setting High Priority");
						mt2.thrd.setPriority(8);
						break;
					case("L"):
						System.out.println("Setting Low Priority");
						mt2.thrd.setPriority(2);
						break;
					case("N"):
						System.out.println("Setting Normal Priority");
						mt2.thrd.setPriority(5);
						break;
					case("S"):
						mt2.mystop();
						System.out.println("Available Threads are:");
						if(mt1.thrd.isAlive()) {
							System.out.println("Thread " + mt1.thrd.getName() + ": " + mt1.thrd.getState() + " - Press Key " + mt1.thrd.getName() + " to control");
						}
						if(mt2.thrd.isAlive()) {
							System.out.println("Thread " + mt2.thrd.getName() + ": " + mt2.thrd.getState() + " - Press Key " + mt2.thrd.getName() + " to control");
						}
						if(mt3.thrd.isAlive()) {
							System.out.println("Thread " + mt3.thrd.getName() + ": " + mt3.thrd.getState() + " - Press Key " + mt3.thrd.getName() + " to control");
						}
						if(mt4.thrd.isAlive()) {
							System.out.println("Thread " + mt4.thrd.getName() + ": " + mt4.thrd.getState() + " - Press Key " + mt4.thrd.getName() + " to control");
						}
						if(mt5.thrd.isAlive()) {
							System.out.println("Thread " + mt5.thrd.getName() + ": " + mt5.thrd.getState() + " - Press Key " + mt5.thrd.getName() + " to control");
						}
						break;
					case("3"):
						threadInControl = 3;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("4"):
						threadInControl = 4;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("5"):
						threadInControl = 5;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					default:
					}
				}else if(threadInControl == 3) {
					// Control Thread 3
					switch(KeyEvent.getKeyText(code)) {
					case("1"):
						threadInControl = 1;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("2"):
						threadInControl = 2;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("3"):
						if(!mt3.suspended) {
							mt3.mysuspend();
						}else {
							mt3.myresume();
						}
						break;
					case("T"):
						System.out.println("Setting High Priority");
						mt3.thrd.setPriority(8);
						break;
					case("L"):
						System.out.println("Setting Low Priority");
						mt3.thrd.setPriority(2);
						break;
					case("N"):
						System.out.println("Setting Normal Priority");
						mt3.thrd.setPriority(5);
						break;
					case("S"):
						mt3.mystop();
						System.out.println("Available Threads are:");
						if(mt1.thrd.isAlive()) {
							System.out.println("Thread " + mt1.thrd.getName() + ": " + mt1.thrd.getState() + " - Press Key " + mt1.thrd.getName() + " to control");
						}
						if(mt2.thrd.isAlive()) {
							System.out.println("Thread " + mt2.thrd.getName() + ": " + mt2.thrd.getState() + " - Press Key " + mt2.thrd.getName() + " to control");
						}
						if(mt3.thrd.isAlive()) {
							System.out.println("Thread " + mt3.thrd.getName() + ": " + mt3.thrd.getState() + " - Press Key " + mt3.thrd.getName() + " to control");
						}
						if(mt4.thrd.isAlive()) {
							System.out.println("Thread " + mt4.thrd.getName() + ": " + mt4.thrd.getState() + " - Press Key " + mt4.thrd.getName() + " to control");
						}
						if(mt5.thrd.isAlive()) {
							System.out.println("Thread " + mt5.thrd.getName() + ": " + mt5.thrd.getState() + " - Press Key " + mt5.thrd.getName() + " to control");
						}
						break;
					case("4"):
						threadInControl = 4;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("5"):
						threadInControl = 5;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					default:
					}
				}else if(threadInControl == 4) {
					// Control Thread 4
					switch(KeyEvent.getKeyText(code)) {
					case("1"):
						threadInControl = 1;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("2"):
						threadInControl = 2;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("3"):
						threadInControl = 3;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("4"):
						if(!mt4.suspended) {
							mt4.mysuspend();
						}else {
							mt4.myresume();
						}
						break;
					case("T"):
						System.out.println("Setting High Priority");
						mt4.thrd.setPriority(8);
						break;
					case("L"):
						System.out.println("Setting Low Priority");
						mt4.thrd.setPriority(2);
						break;
					case("N"):
						System.out.println("Setting Normal Priority");
						mt4.thrd.setPriority(5);
						break;
					case("S"):
						mt4.mystop();
						System.out.println("Available Threads are:");
						if(mt1.thrd.isAlive()) {
							System.out.println("Thread " + mt1.thrd.getName() + ": " + mt1.thrd.getState() + " - Press Key " + mt1.thrd.getName() + " to control");
						}
						if(mt2.thrd.isAlive()) {
							System.out.println("Thread " + mt2.thrd.getName() + ": " + mt2.thrd.getState() + " - Press Key " + mt2.thrd.getName() + " to control");
						}
						if(mt3.thrd.isAlive()) {
							System.out.println("Thread " + mt3.thrd.getName() + ": " + mt3.thrd.getState() + " - Press Key " + mt3.thrd.getName() + " to control");
						}
						if(mt4.thrd.isAlive()) {
							System.out.println("Thread " + mt4.thrd.getName() + ": " + mt4.thrd.getState() + " - Press Key " + mt4.thrd.getName() + " to control");
						}
						if(mt5.thrd.isAlive()) {
							System.out.println("Thread " + mt5.thrd.getName() + ": " + mt5.thrd.getState() + " - Press Key " + mt5.thrd.getName() + " to control");
						}
						break;
					case("5"):
						threadInControl = 5;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					default:
					}
				}else if(threadInControl == 5) {
					// Thread Control 5
					switch(KeyEvent.getKeyText(code)) {
					case("1"):
						threadInControl = 1;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("2"):
						threadInControl = 2;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("3"):
						threadInControl = 3;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("4"):
						threadInControl = 4;
						System.out.println("Controlling Thread " + threadInControl);
						break;
					case("5"):
						if(!mt5.suspended) {
							mt5.mysuspend();
						}else {
							mt5.myresume();
						}
						break;
					case("T"):
						System.out.println("Setting High Priority");
						mt5.thrd.setPriority(8);
						break;
					case("L"):
						System.out.println("Setting Low Priority");
						mt5.thrd.setPriority(2);
						break;
					case("N"):
						System.out.println("Setting Normal Priority");
						mt5.thrd.setPriority(5);
						break;
					case("S"):
						mt5.mystop();
						System.out.println("Available Threads are:");
						if(mt1.thrd.isAlive()) {
							System.out.println("Thread " + mt1.thrd.getName() + ": " + mt1.thrd.getState() + " - Press Key " + mt1.thrd.getName() + " to control");
						}
						if(mt2.thrd.isAlive()) {
							System.out.println("Thread " + mt2.thrd.getName() + ": " + mt2.thrd.getState() + " - Press Key " + mt2.thrd.getName() + " to control");
						}
						if(mt3.thrd.isAlive()) {
							System.out.println("Thread " + mt3.thrd.getName() + ": " + mt3.thrd.getState() + " - Press Key " + mt3.thrd.getName() + " to control");
						}
						if(mt4.thrd.isAlive()) {
							System.out.println("Thread " + mt4.thrd.getName() + ": " + mt4.thrd.getState() + " - Press Key " + mt4.thrd.getName() + " to control");
						}
						if(mt5.thrd.isAlive()) {
							System.out.println("Thread " + mt5.thrd.getName() + ": " + mt5.thrd.getState() + " - Press Key " + mt5.thrd.getName() + " to control");
						}
						break;
					default:
					}
				}
			}
		};
		JTextField textField = new JTextField();
		textField.addKeyListener(listener);
		contentPane.add(textField, BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
		
		do {
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException exc) {
				System.out.println("Main thread interrupted.");
			}
		}while(mt1.thrd.isAlive() || mt2.thrd.isAlive() || mt3.thrd.isAlive() || mt4.thrd.isAlive() || mt5.thrd.isAlive());
		System.out.println("This app is now exiting, all threads have been stopped.");
		System.exit(0);
	}
}
