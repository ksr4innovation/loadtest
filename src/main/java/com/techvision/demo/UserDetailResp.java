package com.techvision.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDetailResp implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1495371583841000481L;
	private List<UserDetailVO> userDetailsList = new ArrayList<UserDetailVO>();
	public List<UserDetailVO> getUserDetailsList() {
		return userDetailsList;
	}
	public void setUserDetailsList(List<UserDetailVO> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}
	
	

}
