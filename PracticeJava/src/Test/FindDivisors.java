package Test;

import java.util.ArrayList;

public class FindDivisors {
	
	public static void main(String[] args) {
		int num = 284;
		printDivisors(num);
	}
	
	static void printDivisors(int num) {
		ArrayList<Integer> divisors = new ArrayList<>();
		for(int i =1; i <num; i++) {
			if(num%i==0) {
			divisors.add(i);
			}
		}
		System.out.println(divisors);
		
		int sum = divisors.stream().mapToInt(i -> i).sum();
		
		System.out.println("sum="+sum);
	}

}
