package com.practice.General;

import java.util.ArrayList;
import java.util.List;

/*
 * Immutable class is a class which once created, it's content can not be changed. 
 * Immutable classes are good choice for HashMap key as their state cannot be changed once they are created. 
 * Objects of immuable classes are also thread safe as threads can not change the value of its fields once it is created.
 * 
 * Please read @link: https://codepumpkin.com/immutable-class-with-mutable-member-fields-in-java/
 */
public class ImmutabilityTester {
	
	public static void main(String[] args) {
		CustomImmutableClass obj = new CustomImmutableClass("Abhiram", "CS", new Address("9","Rustampur", "Gorakhpur", 273016));
		System.out.println("obj : "+obj.toString());
		
		Address addRefOfImmutableClass = obj.getAddress();
		
		System.out.println("addRefOfImmutableClass: "+addRefOfImmutableClass);
		System.out.println("setting new city in above aobject: ");
		
		addRefOfImmutableClass.setCity("Lucknow");
		System.out.println("After update: addRefOfImmutableClass: "+addRefOfImmutableClass);
		
		System.out.println("Checking the custom immutable object again, if its Address ref is updated or not: \n"+obj);
		
		System.out.println("================================");
		System.out.println();
		//System.out.println("capturing address reference directly without using the getter method and trying to modufy the city:");
		//below line would give compilation error
		//the field CustomImmutableClass.address is not visible
		//the above compilation error is because : we have made the field private.
		//so only way to access it is using getters.
		//Address dirctRefFromCustomImmutableObj = obj.address;
		
		System.out.println("Testing immutability when custom class contains Collection object of Mutables as instance variable");
		
		System.out.println();
		
		ArrayList<Address> aList = new ArrayList<>();
		aList.add(new Address("134-F", "KareemNagar", "Gorakhpur", 273001));
		ImmutableClassWithCollectionRefOfMutables newObj = new ImmutableClassWithCollectionRefOfMutables("Pratima", "TAX",
				aList);
		
		ImmutableClassWithCollectionRefOfMutables newObj2 = new ImmutableClassWithCollectionRefOfMutables("Prat", "TAX",
				aList);
		
		
		System.out.println("B4 any update: newObj: \n newObj = "+newObj);
		System.out.println("\n B4 any update: newObj2: \n newObj2 = "+newObj2);
		System.out.println("\n Getting AddressList from newObj: \n ");
		//List<Address> addRefList = newObj.getAddressList_1(); //fail
		//List<Address> addRefList = newObj.getAddressList_2(); //fails
		//List<Address> addRefList = newObj.getAddressList_3(); //fails
		//List<Address> addRefList = newObj.getAddressList_4(); // fails
		//List<Address> addRefList = newObj.getAddressList_5(); // Pass
		List<Address> addRefList = newObj.getAddressList_6(); // Pass
		
		
		
		System.out.println("addRefList before addition: "+addRefList);
		
		addRefList.add(new Address("9", "Rustampur", "Gorakhpur", 273016));
		
		
		System.out.println("\naddRefList after addition of new Adddress: "+addRefList);
		
		System.out.println("\nnewObj's addressList: "+newObj);
		
		
		System.out.println("\nGetting the original address stored in the AddressList received from newObj");
		Address ref = addRefList.get(0);
		System.out.println("\nBefore update, address from the newObj's addressList: \n newObj.addressList.get(0): "+ref);
		System.out.println("\nSetting Lucknow as city in address received from newObj: ");
		ref.setCity("Lucknow");
		System.out.println("\n After update:\n  ref: "+ref);
		System.out.println("\nLets see if the newObj's addressList is updated or not: \n newObj = "+newObj);
		
		//System.out.println("\nwith getAddressList_1(), the object is not immutable, because of the for each loop, used for copying the address \n into the new list.");
		System.out.println("\ngetAddressList_5, getAddressList_6 pass the immutability test");
	}

}
