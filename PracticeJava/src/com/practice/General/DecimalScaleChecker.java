package com.practice.General;

import java.math.BigDecimal;

public class DecimalScaleChecker {
	
	
	public static void main(String[] args) {
		int s = 2;
		int t = 5;
		float d = (float)s/t;
		float a = (float)2/3;
		System.out.println(d);
		System.out.println(String.format("%.6f", d));
		System.out.println(a);
		System.out.println(String.format("%.6f", a));
	}
}
