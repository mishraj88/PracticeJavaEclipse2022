package com.practice.General;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * please refer @link: https://codepumpkin.com/immutable-class-with-mutable-member-fields-in-java/
 */
public  final class ImmutableClassWithCollectionRefOfMutables {
	private final String name;
	private final String dept;
	private final ArrayList<Address> addressList;
	
	public ImmutableClassWithCollectionRefOfMutables(String name, String dept, ArrayList<Address> addressList) {
		super();
		this.name = name;
		this.dept = dept;
		this.addressList = new ArrayList<>();
		for(Address add :addressList) {
			this.addressList.add(add);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDept() {
		return this.dept;
	}
	
	/*
	 * of all the given getAddressList_i() methods -
	 * getAddressList_2 and getAddressList_3() are the most preferred
	 * Never use getAddressList_4(), getAddressList_1() - they will not make immutable classes.
	 */
	
	
	/*
	 * below for-each loop, does not create deep clones,
	 * 
	 * instead puts the same old memory references in to the new arrayList to be returned
	 * 
	 * so the caller if tries to modify the content of the addressList received
	 * 
	 * it will modify the original Objects addressList - making the class mutable.
	 */
	
	//fails
	public List<Address> getAddressList_1(){
		List<Address> addressListCopy = new ArrayList<>();
		for(Address add : this.addressList) {
			addressListCopy.add(add);
		}
		return addressListCopy;
	}
	
	/*
	 * below is the immutable version of getAddressList_1()
	 * which is basically deepCloning of our addressList in immutableClass obj
	 */
	
	//passes
	public List<Address> getAddressList_5(){
		List<Address> addressListCopy = new ArrayList<>();
		for(Address add : this.addressList) {
			Address newAddress = new Address();
			newAddress.setCity(add.getCity());
			newAddress.setHouseNum(add.getHouseNum());
			newAddress.setStreetName(add.getStreetName());
			newAddress.setZipCode(add.getZipCode());
			
			addressListCopy.add(newAddress);
		}
		return addressListCopy;
	}
	
	/*
	 * 
	 * Another immutable version of the getAddressList_1()
	 * using clone() on the each address object stored in the 
	 * immutableObject's arrayList.
	 * Clone() method of simple object with primitives and Wrapper instances
	 * creates a deep clone
	 * 
	 */
	
	//passes
	public List<Address> getAddressList_6(){
		List<Address> addressListCopy = new ArrayList<>();
		for(Address address : this.addressList) {
			//for clone method to work, Address needs to implement Comparable interface
			// other wise will get compilation error: the method clone() is not visible. 
			/*
			 * Above compilation issue is coming because clone() method has protected access.
			 * To resolve this, make following changes:
			 * 1- public class Address implements Cloneable
			 * 2- override clone method in Address class as below:
			 * 		public Object clone(){  
	    				try{  
	        					return super.clone();  
	    				}catch(Exception e){ 
	        					return null; 
	    				}
					}
					
					once above changes are done you won't see the compilation error again
			 */
			Address newAddress = (Address) address.clone();
			
			addressListCopy.add(newAddress);
		}
		return addressListCopy;
	}
	
	//fails
	public List<Address> getAddressList_2(){
		return Collections.unmodifiableList(this.addressList);
	}
	
	//fails
	public List<Address> getAddressList_3(){
		return new ArrayList<Address>(this.addressList);
	}
	
	/*
	 * Don't use getAddressList_3 version
	 * this is because the clone() method on Collection objects return a shallow copy of the original list
	 * this means that the although a new ArrayList object will be created - but the contents of this new arraylist
	 * will still be pointing to the same memory references as of the object in the original list.
	 * So the caller function of the below method - will have the memory refs of the original mutable Address objects
	 * and thus will be able to modify the contents of the object,and our class won't be Immutable.
	 */
	
	//fails
	@SuppressWarnings("unchecked")
	public List<Address> getAddressList_4(){
		return (ArrayList<Address>)this.addressList.clone();
	}

	
	public String toString() {
		return "ImmutableClassWithCollectionRefOfMutables = [ name="+this.name+", dept="+this.dept+
				", addressList="+this.addressList.toString()+" ]";
	}
}
