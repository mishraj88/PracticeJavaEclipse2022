package com.practice.leetCode;

public class Palindrome {
	public static void main(String[] args) {
		
		PalSolution obj = new PalSolution();
		int x = 121;
		boolean flag = obj.isPalindrome(x);
		if(flag)
		System.out.println(x+" is pallindrome");
		else {
			System.out.println(x+" is not pallindrome");
		}
	}
}

class PalSolution {
    public boolean isPalindrome(int x) {
        int num = x;
        boolean negative = false;
        int reverse = 0;
        int lastDigit = 0;
        if(x<0){
            negative = true;
            x = x*-1;
        }
        while(x>0){
            lastDigit = x%10;
            reverse = reverse*10+lastDigit;
            x =x/10;
        }
        System.out.println("reverse : "+reverse);
        if(negative)
            reverse = reverse * -1;
        return num == reverse;
        
    }
}
