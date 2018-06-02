package com.techvision.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadTestController {
	
	@Autowired
	private LoadTestService loadTestService;

	@RequestMapping(method=RequestMethod.GET,value="/userDetails")
	public UserDetailResp getUserDetails() throws Exception {
				return loadTestService.getUserDetails();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/userDetailsOutMemory")
	public UserDetailResp getUserDetailsOutMemory() throws Exception {
				return loadTestService.getUserDetailsOutOfMemoryError();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/userDetailsDelay/{delayInput}")
	public UserDetailResp getUserDetailsDelay(@PathVariable String delayInput ) throws Exception {
				return loadTestService.getUserDetailsPause(delayInput);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/deadlock")
	public void deadlock( ) throws Exception {
				 loadTestService.deadLock();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/deadlock1")
	public void deadlock1( ) throws Exception {
		loadTestService.deadLock1();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/deadLockInfo")
	public void deadLockInfo( ) throws Exception {
		loadTestService.deadLockInfo();
	}
}
