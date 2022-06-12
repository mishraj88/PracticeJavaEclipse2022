package com.test.spendgo;

public class TestArray {

	/*[-12, 11, -13, -5, 6, -7, 5, -3, -6] -- move -ve to left & +ve to right , 
	no sorting, 
	no additional data-structures
	 */

	public static void main(String[] args) {
		int[] arr = new int[5];
		reStructure(arr);
		System.out.print("[ ");
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("]");
	}
	public static void reStructure(int[] a){
		int start =0;
		int end = a.length -1;
		while(start < end){
			System.out.println("end: "+end);
			System.out.println("a[end] ="+a[end]);
			System.out.println("start: "+start+" a[start] = "+a[start]);
			if(a[start] > 0 && a[end] <0)  {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				start++;
				end--;
			}else{
				if(a[end]<0){

					start++;
				}else {	
					if(a[start] > 0)
						end--;
					else {
						start++;
						end--;
					}
				}//start++;
			}
			//return a;
		}


	}
}
