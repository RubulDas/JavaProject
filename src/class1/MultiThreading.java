/**
 * 
 */
package class1;

/**
 * @author rubul.d
 *
 */
class Runner extends Thread{

	@Override
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println("Hello "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
public class MultiThreading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();
		Runner runner = new Runner();
		runner.start();
		runner.run();
	}

}
