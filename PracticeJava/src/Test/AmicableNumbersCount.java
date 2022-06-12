package Test;

import java.util.HashMap;

public class AmicableNumbersCount {

	static int amicablepair(int n) {
		//return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int answer = 0;
		for(int i =1 ; i<= n ; i++) {

			int sum1=findDivisorsSum(i);
			//System.out.println("Sum1 ="+sum1);

			int sum2 = findDivisorsSum(sum1); //System.out.println("Sum2 ="+sum2);


			if(sum2 == i && i!=sum1 && map.get(i) == null) { 
				//System.out.println("i= "+i);
				//System.out.println("Sum2 = "+sum2); 
				map.put(i, 1);
				map.put(sum1, 1);
				System.out.println("("+i+","+sum1+")"); 
				answer++; 

			}



		}

		return answer;
	}
	private static int findDivisorsSum(int num) {
		//System.out.println("=====================");
		//System.out.println("num: "+num);
		int sum = 1;
		for(int i =2; i< num; i++ ) {
			if(num%i==0) {
				//System.out.println("divisor: "+i);
				sum = sum + i;
			}
		}
		//System.out.println("SumDivisors( "+num+") ="+sum);
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(amicablepair(20000));
		//findDivisorsSum(284);
	}
}
