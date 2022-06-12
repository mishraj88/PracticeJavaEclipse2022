package com.test.accolite;

import java.util.ArrayList;

/*
 * sorted array
 * remove duplicates from 
 */
public class TestDemo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		for(int i=1; i< arr.length; i++) {
			
			if(list.get(list.size()-1) != arr[i]) {
				list.add(arr[i]);
			}
			
		}
		
		System.out.println(list);
		
		/*int[] op = new int[list.size()];
		for(int i=0; i< list.size(); i++) {
			op[i] = list.get(i);
		}
		
		Object[] opt = list.toArray();*/
	}
}
