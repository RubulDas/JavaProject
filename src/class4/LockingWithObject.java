package class4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LockingWithObject {
	private static Random random = new Random();
	private static List<Integer> list1 = new ArrayList<Integer>();
	private static List<Integer> list2 = new ArrayList<Integer>();
	
	private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    
	public static void main(String args[]){
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				process();
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				process();
			}
		});
		Long start=System.currentTimeMillis();
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}
		Long end = System.currentTimeMillis();
		System.out.println("Time Taken :"+(end-start));
		System.out.println("List1 size: "+list1.size()+"----"+"List2 size: "+list2.size());
		
	}
	public static void addValesToListOne(){
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			list1.add(random.nextInt(100));
		}		
	}
	public static void addValesToListTwo(){
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			list2.add(random.nextInt(100));
		}
	}
	public static void process() {
	    for(int i=0; i<1000; i++) {
	    	addValesToListOne();
	    	addValesToListTwo();
	    }
	}
	
}
