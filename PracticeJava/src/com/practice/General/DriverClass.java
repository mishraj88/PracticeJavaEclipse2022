package com.practice.General;

public class DriverClass {
	
	public static void main(String[] args) {
		InterfaceDemo obj = new InterfaceDemo();
		System.out.println(obj.getClass());
		
		InterfaceDemo_1 obj2 = new InterfaceDemo_1();
		System.out.println(obj2.getClass());
		if(obj.getClass().equals(obj2.getClass()))
		System.out.println("true");
		else
			System.out.println("false");
	}

}
