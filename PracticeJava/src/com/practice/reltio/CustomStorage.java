package com.practice.reltio;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomStorage implements IStorage {
	
	
	private final ConcurrentHashMap<String, String> cmap ;
	
	public CustomStorage(){
		cmap = new ConcurrentHashMap<String, String>();
	}
	@Override
	public void put(String key, String value) {
		cmap.put(key, value);

	}

	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return cmap.get(key);
	}
	
	public int size() {
		return cmap.size();
	}

}
