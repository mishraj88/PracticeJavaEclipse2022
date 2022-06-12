package com.practice.reltio;

import java.util.concurrent.atomic.AtomicInteger;

class CachedStore implements IStorage {
	   private int maxSize;
	   private IStorage storage;
	   private static AtomicInteger ai;
	   public CachedStore(IStorage storage, int maxSize) {
	       this.storage = storage;
	       this.maxSize = maxSize;
	       ai = new AtomicInteger(maxSize);
	   }

	   public void put(String key, String value) {
		//?
		   if(ai.getAndDecrement()>0) {
			   storage.put(key, value);
			   System.out.println(Thread.currentThread().getName()+" has put [key="
			   		+ ""+key+", value="+value+"]");
		   }
		   else 
			   //throw new IllegalStateException(Thread.currentThread().getName()+ ": size full");
			   System.out.println(Thread.currentThread().getName()+ "size is full");
	   }

	   public String get(String key) {
		//?
		   
		   return storage.get(key);
	   }

	
	}


