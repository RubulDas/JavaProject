/**
 * 
 */
package class2;

import java.util.Scanner;

/**
 * @author zaloni
 *
 */
class Producer extends Thread{

	private volatile boolean running = true;
	@Override
	public void run() {
		while(running){
			System.out.println("Hello");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	public void shutDown(){
		running=false;
	}
}
public class VolatileKeyWordInJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		Producer produce = new Producer();
		produce.start();
		System.out.println("Enter the return key to stop !");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		produce.shutDown();
	}
}
