package Test;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicityDemo implements Runnable{
	int max_size;

	AtomicInteger ai;

	AtomicityDemo(int size){
		this.max_size = size;
		ai = new AtomicInteger(max_size);
	}

	public void put() {
		if(ai.getAndDecrement()> 0) {
			System.out.println(Thread.currentThread().getName()+ ": Hello");

		}
		else {
			throw new IllegalStateException(Thread.currentThread().getName()+": size full");
		}
	}

	public void run() {
		this.put();
	}
}
public class AtomicIntegerTest {
	public static void main(String[] args) {
		int size = 10;

		AtomicityDemo obj = new AtomicityDemo(3);
		try {
			for(int i=0; i< size+5; i++) {
				Thread t = new Thread(obj, "thread -"+i);
				t.start();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());

		}
		//		Thread t1 = new Thread(obj,"thread-1");
		//		Thread t2 = new Thread(obj,"thread-2");
		//		Thread t3 = new Thread(obj,"thread-3");
		//		Thread t4 = new Thread(obj,"thread-4");
		//		Thread t5 = new Thread(obj,"thread-5");
		//		Thread t6 = new Thread(obj,"thread-6");
		//		Thread t7 = new Thread(obj,"thread-7");
		//		Thread t8 = new Thread(obj,"thread-8");
		//		
		//		t1.start();
		//		t2.start();
		//		t3.start();
		//		t4.start();
		//		t5.start();
		//		t6.start();
		//		t7.start();
		//		t8.start();



	}
}
