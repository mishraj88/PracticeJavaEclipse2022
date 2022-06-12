package com.test.spendgo;

public class StringManipulation {

	public static void main(String[] args) {
		String s = "Hello World";
		/*1- String rev = s.reverse; // custom Logic, no in build functions
		2- delete every third character from the reversed String.
		3- character array

		 */

		char[] orig = s.toCharArray();
		//char[] rev = new char[orig.length];

		int start=0;
		int end = orig.length -1;
		//populating rev
		while(start < end) {
			char temp = orig[end];
			orig[end] = orig[start];
			orig[start]= temp;
			end--;
			start++;
		}
		

		//delete every third character from the orig
		StringBuilder sb = new StringBuilder();
		
		System.out.println();
		for(int i =1; i<= orig.length; i++) {
			if(i%3==0) {
				continue;
			}
			sb.append(orig[i-1]);
		}
		
		System.out.println(sb.toString());
		aaproach2(s);
		

	}
	
	public static void aaproach2(String s){
		//int start=0;
		StringBuilder sb = new StringBuilder();
		int end = s.length()-1;
		int counter = 1;
		while(end>=0) {
			if(counter%3!=0) {
				sb.append(s.charAt(end));
				
			}
			end--;
			counter++;
		}
		System.out.println(sb.toString());
	}


}


