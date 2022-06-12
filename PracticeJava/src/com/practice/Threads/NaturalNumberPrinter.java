package com.practice.Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class NaturalNumberPrinter {
	
	static class MyThread implements Runnable{
		
		AtomicInteger ai = new AtomicInteger(1);
		static boolean flag = false;
		/*
		 * below implementation of run method
		 * prints natural numbers but in random order
		 */
		@Override
		public void run() {
			
			while(ai.get() < 100) {
				synchronized(this){
				try {
					System.out.println(Thread.currentThread().getName()+" : "+ai.getAndIncrement());
					Thread.sleep(5);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		Thread T1 = new Thread(t1, "Thread -1");
		Thread T2 = new Thread(t1, "Thread -2");
		T1.start();
		T2.start();
		System.out.println("end");
	}

}
