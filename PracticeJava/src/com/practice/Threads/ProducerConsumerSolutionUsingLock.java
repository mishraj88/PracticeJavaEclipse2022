package com.practice.Threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerSolutionUsingLock {
	
	public static void main(String[] args) throws InterruptedException {
		
		ProducerConsumerImpl pc = new ProducerConsumerImpl();
		Thread t1 = new Thread(new Producer(pc), "Producer");
		Thread t2 = new Thread(new Consumer(pc), "Consumer");
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("Main thread exits");
		
	}

}

class ProducerConsumerImpl{
	
	private static final int CAPACITY = 10;
	private Queue<Integer> q = new LinkedList<>();
	private Random  random = new Random();
	static boolean flag = false;
	private Lock lock = new ReentrantLock();
	
	private Condition bufferFull = lock.newCondition();
	private Condition bufferEmpty = lock.newCondition();
	
	public void put() throws InterruptedException {
		try {
			lock.lock();
			while(q.size() == CAPACITY) {
				System.out.println(Thread.currentThread().getName()+ " is waiting as Q is full");
				bufferEmpty.await();
			}
			int x = random.nextInt();
			q.offer(x);
			System.out.println(Thread.currentThread().getName()+ " Added to q: "+x);
			bufferFull.signalAll();
		}finally {
			lock.unlock();
		}
	}
	
	public void get() throws InterruptedException {
		try {
			lock.lock();
			while(q.size() == 0) {
				System.out.println(Thread.currentThread().getName() +" is waiting as q is empty");
				bufferFull.await();
			}
			int x = q.poll();
			System.out.println(Thread.currentThread().getName()+ " picked up "+x+ " from q");
			bufferEmpty.signalAll();
		}finally {
			lock.unlock();
		}
	}
	
	
	
}
class Producer implements Runnable {

	ProducerConsumerImpl pc;
	
	Producer(ProducerConsumerImpl pc){
		this.pc = pc;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
				pc.put();
				Thread.sleep(1000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Consumer implements Runnable{
	ProducerConsumerImpl pc;
	
	Consumer(ProducerConsumerImpl pc){
		this.pc = pc;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
				pc.get();
				Thread.sleep(1000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
