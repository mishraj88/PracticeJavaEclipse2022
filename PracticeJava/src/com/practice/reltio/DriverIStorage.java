package com.practice.reltio;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class DriverIStorage{
	private static CachedStore store;
	Random random = new Random();

	public static void main(String[] args) {
		//obj = new CustomStorage();
		int size = 10;
		store = new CachedStore(new CustomStorage(), size);

		//List<Thread> threadList = new ArrayList<>();
		Set<Thread> threadSet = new HashSet<>();
		for(int i =0; i< size+5; i++) {
			try {
				int var = i;
				Thread t = new Thread(() -> {
					String key = new String(String.valueOf(var));
					String value = "abc_"+var;
					store.put(key, value);

				}, "WriterThread-"+var);
				//t.start();
				//threadList.add(t);
				threadSet.add(t);
			}catch(Exception e) {
				Optional<String>  opt = Optional.ofNullable(e.getMessage());

				System.out.println(opt.orElseGet(() -> "some exception"));
			}
		}

		for(int i=0; i< size+5; i++) {
			try {
				int var = i;
				Thread t = new Thread(() -> {
					String key = new String(String.valueOf(var));
					String value = store.get(String.valueOf(var));
					System.out.println(Thread.currentThread().getName()+" gets "
							+ "[value="+value+"] for key=["+key+"]");


				}, "ReaderThread-"+var);
				//t.start();
				//threadList.add(t);
				threadSet.add(t);
			}catch(Exception e){
				Optional<String>  opt = Optional.ofNullable(e.getMessage());

				System.out.println(opt.orElseGet(() -> "some exception"));
			}
		}

		for(Thread t : threadSet) {
			try {
				t.start();
			}catch(Exception e) {
				Optional<String> opt = Optional.ofNullable(e.getMessage());
				System.out.println(opt.orElseGet(() -> "some exception"));
			}
		}

	}


}


