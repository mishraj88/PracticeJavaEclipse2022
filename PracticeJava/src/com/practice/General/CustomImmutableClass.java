package com.practice.General;

/*
 * Immutable class is a class which once created, it's content can not be changed. 
 * Immutable classes are good choice for HashMap key as their state cannot be changed once they are created. 
 * Objects of immutable classes are also thread safe as threads can not change the value of its fields once it is created.
 * 
 */

/*
 * Steps to make a class immutable:
 * We will declare class as final and all the fields as private final.
 * We will provide one parameterized constructor and getter methods.
 * We will not provide any setter method, so that field values can not be changed after object creation.
 */

/*
 * If all the member variables of the class are immutable such as Wrapper classes from java.lang package or String class
 * above rule suffies.
 * But in our custom class below, we are storing address in Address reference which has setters methods
 * So now are class contains a mutable reference, so we have to make some more changes in the address reference,
 * which is done below - using deep cloning.\, and returning the new version.
 */

/*
 * Please read @link: https://codepumpkin.com/immutable-class-with-mutable-member-fields-in-java/
 */

public final class CustomImmutableClass {
	private final String name;
	private final String dept;
	private final Address address;
	
	public CustomImmutableClass(String name, String dept, Address add) {
		this.name = name;
		this.dept = dept;
		/*
		 * Since Address class is not immutable, we won't directly use the passed reference to 
		 * assign it to our object. Instead we will create a new object and copy the values 
		 * using the setters and getters methods as shown below and use this newly created address object to assign 
		 * it to our field address of current object
		 */
		Address add_new  = new Address();
		add_new.setCity(add.getCity());
		add_new.setHouseNum(add.getHouseNum());
		add_new.setStreetName(add.getStreetName());
		add_new.setZipCode(add.getZipCode());
		
		this.address = add_new;
	}
	
	/*
	 * We won't be having any setters 
	 * Also we won't be returning the exact reference of our Address object
	 * instead while returning, we will make sure that we share a copy of that.
	 * Lets see below.
	 */
	
	public String getName() {
		return this.name;
	}
	
	public String getDept() {
		return this.dept;
	}
	
	public Address getAddress() {
		Address copy = new Address();
		copy.setCity(this.address.getCity());
		copy.setHouseNum(this.address.getHouseNum());
		copy.setStreetName(this.address.getStreetName());
		copy.setZipCode(this.address.getZipCode());
		
		return copy;
	}
	
	public String toString() {
		return "CustomImmutableClass [ name = " +this.getName()+", dept = "+this.getDept()+
				", Address : "+this.getAddress().toString()+" ] ";
	}

}
