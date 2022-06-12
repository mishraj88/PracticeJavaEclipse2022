package com.practice.General;
/*
 * generic mutable class
 */
public class Address implements Cloneable {
	
	private String houseNum, streetName, city;
	private int zipCode;
	
	public Address() {
		super();
	}
	public Address(String houseNum, String streetName, String city, int zipCode) {
		super();
		this.houseNum = houseNum;
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Address [houseNum=" + houseNum + ", streetName=" + streetName + ", city=" + city + ", zipCode="
				+ zipCode + "]";
	}
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	
	

}
