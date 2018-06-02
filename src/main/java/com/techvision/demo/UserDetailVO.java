package com.techvision.demo;

import java.io.Serializable;

public class UserDetailVO implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -819980119891400890L;
	
	private String lastName;
	
	private String firstName;
	
	private String desg;
	
	private String sal;
	
	private byte[] photoArray;
	
	

	public UserDetailVO(String lastName, String firstName, String desg, String sal,byte[] photoArray) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.desg = desg;
		this.sal = sal;
		
		this.photoArray = photoArray;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getDesg() {
		return desg;
	}

	public String getSal() {
		return sal;
	}

	public byte[] getPhotoArray() {
		return photoArray;
	}

	public void setPhotoArray(byte[] photoArray) {
		this.photoArray = photoArray;
	}
	
	
	
	
	
	

}
