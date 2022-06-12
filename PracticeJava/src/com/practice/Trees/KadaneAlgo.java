package com.practice.Trees;



//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class KadaneAlgo {
 
	public static void main (String[] args) throws IOException {
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
		 * t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		 * while(t-->0){ //size of array int n = Integer.parseInt(br.readLine().trim());
		 * int arr[] = new int[n]; String inputLine[] = br.readLine().trim().split(" ");
		 * 
		 * //adding elements for(int i=0; i<n; i++){ arr[i] =
		 * Integer.parseInt(inputLine[i]); }
		 * 
		 * KadaneDemo obj = new KadaneDemo();
		 * 
		 * //calling maxSubarraySum() function
		 * //System.out.println(obj.maxSubarraySum(arr, n));
		 * 
		 * Map<String, Integer> map = obj.maxSubarraySum(arr, n);
		 * 
		 * map.entrySet().stream().forEach(k ->
		 * System.out.println("key : "+k.getKey()+", value: "+k.getValue())); t=0; }
		 */
		
		//int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		//int[] arr = {-1,-2,-3,-4};
		int[] arr = {1,2,3,4,5};
		KadaneDemo obj = new KadaneDemo();
		Map<String, Integer> map = obj.maxSubarraySum(arr);
		map.entrySet().stream().forEach(k ->
		 System.out.println("key : "+k.getKey()+", value: "+k.getValue())); 
		
		int start = map.get("start");
		int end = map.get("end");
		System.out.print("Subarray: [ ");
		for(int i=start; i<=end; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println(" ]");
		//t=0;
		
	}
}

//} Driver Code Ends


class KadaneDemo{

 // arr: input array
 // n: size of array
 //Function to find the sum of contiguous subarray with maximum sum.
 //long maxSubarraySum(int arr[], int n){
 Map<String,Integer> maxSubarraySum(int arr[]){
     
     // int start, end =0;
     // int maxSum = Integer.MIN_VALUE;
     // //end = start +1;
     
     // int tempSum =0;
     // while(end < arr.length){
         
     //     tempSum = Math.max(arr[end], tempSum  +arr[end]);
     //     maxSum = Math.max(maxSum, tempSum);
     //     end++;
         
     // }
     // return maxSum;
     
     int max_sum = Integer.MIN_VALUE;
     int start = 0;
     int end = 0;
     int local_max = 0;
     //int result[] = new int[3];
     
     Map<String, Integer> map = new HashMap<>();
     int n = arr.length;
     while(end < n){
         int tempSum = local_max + arr[end];
         local_max = Math.max(arr[end], tempSum);
         if(local_max == arr[end]){
             //map.put("start", start);
             //map.put("end", end);
             start= end;
         }
         //end++;
         if(local_max > max_sum){
             max_sum = local_max;
             map.put("start", start);
             map.put("end", end);
             map.put("max_sum", max_sum);
             
         }
         end++;
     }
     
     // result[0] = start;
     // result[1] = end;
     // result[2] = max_sum;
     
//     list.add(start);
//     list.add(end);
//     list.add(max_sum);
//     
     //return result;
     
     return map;
     
     
 }
 
}


