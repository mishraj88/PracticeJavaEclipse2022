package com.practice.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class NaturalNumbers {
	
	/*
	 * natural numbers from one two 100;
	 * using multiple threads
	 */
	
	void displayNums() {
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> q = new LinkedList<>();
		Numbers obj = new Numbers(0,q);
		try{ 
			Thread t1 = new Thread(obj);
			Thread t2  = new Thread ( obj);
			t1.start();
			t2.start();
			
			 t1.join(); t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		 System.out.println("end");
		 	
	}

}

class Numbers implements Runnable {
	
	AtomicInteger ai;
	volatile int i;
	Queue<Integer>  q;
	static volatile boolean stop = false;
	Numbers(int i, Queue<Integer> q){
		ai = new AtomicInteger(i);
		this.i =i;
		this.q = q;
	}
	
	@Override
	public void run() {
		
			while(i<101 && !stop) {
				System.out.println(Thread.currentThread().getName()+"i = "+i);
				synchronized(this){
					if(i<100)
					System.out.println("ThreadName = : "+
							Thread.currentThread().getName()+", value = "+(++i));
					i+=1;
				}
				//Thread.currentThread().interrupt();
				/*
				 * synchronized(this){ if(ai.get() < 100) }
				 */
			}
			//stop = true;
			Thread.currentThread().interrupt();
			
		
		
		
	}
}
