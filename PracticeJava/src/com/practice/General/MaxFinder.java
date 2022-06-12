package com.practice.General;

public class MaxFinder {
	
	public static int maxFinder(int[] arr) {
		int answer = arr[0];
		int i=0;
		while(i< arr.length) {
			if(answer< arr[i]) {
				answer = arr[i];
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int arr1[] = new int[] {3,2,1,5,4,6,10};
		int arr2[] = {-9,-11, -1,-3,-5,-6};
		
		int answer1 = maxFinder(arr1);
		int answer2 = maxFinder(arr2);
		System.out.println(answer1);
		System.out.println(answer2);
	}

}
