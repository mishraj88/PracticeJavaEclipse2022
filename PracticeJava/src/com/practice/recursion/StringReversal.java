package com.practice.recursion;

public class StringReversal {
	static StringBuilder reverse = new StringBuilder("");
	static String reverseStr(String s) {
		//return "";
		if(s.length()==1) return s;
		return reverseStr(s.substring(1))+s.charAt(0);
	}
	
	public static void main(String[] args) {
		System.out.println(reverseStr("Jyotirmay Mishra"));
	}

}
