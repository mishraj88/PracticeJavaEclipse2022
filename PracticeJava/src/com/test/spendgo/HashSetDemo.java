package com.test.spendgo;

import java.util.HashSet;

public class HashSetDemo {
	
	public static void main(String[] args) {
		Book b1 = new Book("one", 1);
		Book b2 = new Book("two", 2);
		Book b3 = new Book("three", 3);
		Book b4 = new Book("five", 5);
		Book b6 = new Book("one", 1);
		//output false, because Book.java did not have hashCode() and equals()
		//overridden
		System.out.println(b1.hashCode());
		System.out.println(b6.hashCode());
		System.out.println(b1==b6);
		System.out.println(b1.equals(b6));
		
		HashSet<Book> set_1 = new HashSet<>();
		boolean flag1 = set_1.add(b1);
		boolean flag6 = set_1.add(b6);
		boolean flag2 = set_1.add(b2);
		boolean flag3 = set_1.add(b3);
		boolean flag4 = set_1.add(b4);
		//boolean flag_5 = set_1.add(b5);
		System.out.println("flag1="+flag1);
		System.out.println("flag6="+flag6);
		System.out.println("flag2="+flag2);
		System.out.println("flag3="+flag3);
		System.out.println("flag4="+flag4);
		
		for(Book b: set_1) {
			System.out.println(b);
		}
	}

}
