package com.practice.Threads;

class Counter{

	volatile int value;

	public Counter(int i) {
		value = i;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int i) {
		value = i;
	}
}
class EvenWorker implements Runnable{

	Counter val;

	public EvenWorker(Counter val) {
		this.val = val;
	}
	@Override
	public void run() {


		while(val.getValue()<= 10) {
			//System.out.println("Hello");
			synchronized(val) {
				try {
					while(val.getValue()%2!=0) {
						val.wait();
						System.out.println("Even thread waiting");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(val.getValue()<=10) {
					System.out.println(Thread.currentThread().getName()+" : "+val.getValue());
					val.setValue(val.getValue()+1);
					val.notifyAll();
				} else
					break;
			}
		}
	}

}


class OddWorker implements Runnable{

	Counter val;

	public OddWorker(Counter val){
		this.val = val;
	}
	@Override
	public void run() {


		while(val.getValue()<= 10 ) {
			//System.out.println("Hello2");
			synchronized(val) {
				try {
					while(val.getValue() %2 ==0) {
						val.wait();
						System.out.println("Odd thread waiting");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(val.getValue() <= 10) {
					System.out.println(Thread.currentThread().getName()+" : "+val.getValue());
					val.setValue(val.getValue()+1);
					val.notifyAll();
				}
				else
					break;
			}
		}
	}

}
public class EvenAndOddNaturalNumberPrinters {

	public static void main(String[] args) throws InterruptedException {
		Counter val = new Counter(1);
		EvenWorker even = new EvenWorker(val);
		OddWorker odd = new OddWorker(val);

		Thread t1 = new Thread(even, "Even Thread");
		Thread t2 = new Thread(odd, "Odd Thread");

		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println(Thread.currentThread().getName()+ " ends");
	}

}
