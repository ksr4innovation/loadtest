package com.techvision.demo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LoadTestService {
	
	public UserDetailResp getUserDetails() throws IOException {
		
		System.out.println("  getUserDetails   ");
		UserDetailResp resp = new UserDetailResp();
	
		String fileName = "classpath:20160930_115021.jpg";
		
		
		
		ClassLoader cl = this.getClass().getClassLoader();
		InputStream inputStream = cl.getResourceAsStream(fileName);
		
		 byte[] targetArray = new byte[inputStream.available()];
		 inputStream.read(targetArray);
		
System.out.println("byte array lenght "+targetArray.length);
		
		resp.getUserDetailsList().add(new UserDetailVO("KCR","Rao","CM","400000",targetArray));
		
		
		return resp;
		
		
	}
	
	public UserDetailResp getUserDetailsOutOfMemoryError() throws IOException {
		
		System.out.println("  getUserDetailsOutOfMemoryError   ");
		
		List<UserDetailResp> mainresp  = new ArrayList<UserDetailResp> ();
		
		
		while (true) {
			UserDetailResp resp = new UserDetailResp();	
			for (int i=1;i<10;i++) {
				
				
				try {
					Thread.sleep(2000);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String fileName = "classpath:20160930_115021.jpg";
				ClassLoader cl = this.getClass().getClassLoader();
				InputStream inputStream = cl.getResourceAsStream(fileName);
				
				 byte[] targetArray = new byte[inputStream.available()];
				 inputStream.read(targetArray);
				 System.out.println("byte array lenght "+targetArray.length);
				 
				 UserDetailVO userDetailVO =  new UserDetailVO("KCR","Rao","CM","400000",targetArray);
				if (i%5 == 0) {			
				resp.getUserDetailsList().add(userDetailVO);
				}
				
				
			
			}
			
			mainresp.add(resp);
			
		}
	}
	
	public UserDetailResp getUserDetailsPause(String inputMin) throws IOException {
		UserDetailResp resp = new UserDetailResp();
		
		System.out.println("  getUserDetailsPause   "+inputMin);
	         try {
				Thread.sleep(Integer.valueOf(inputMin)*1000);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	         String fileName = "classpath:20160930_115021.jpg";
				ClassLoader cl = this.getClass().getClassLoader();
				InputStream inputStream = cl.getResourceAsStream(fileName);
				
				 byte[] targetArray = new byte[inputStream.available()];
				 inputStream.read(targetArray);
				
				resp.getUserDetailsList().add(new UserDetailVO("KCR","Rao","CM","400000",targetArray));
		
			return resp;
	}
	
	public static final Object obj = new Object();
	
	public static final Object obj1 = new Object();
	
	public void deadLock() {
		synchronized(obj) {			
			System.out.println("  Entering into synchronized block lock object  "+obj);
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized(obj1) {				
				System.out.println("  Entering into synchronized block   lock object1  "+obj1);
				
			}
			
		}
	}
	
	public void deadLock1() {
		synchronized(obj1) {			
			System.out.println("  Entering into synchronized block lock object1  "+obj1);			
			synchronized(obj) {				
				System.out.println("  Entering into synchronized block   lock object  "+obj);
				
			}
			
		}
	}
	
	public void deadLockInfo(){
		  ThreadMXBean thMxB = ManagementFactory.getThreadMXBean();
		  
		  ThreadInfo[]  processId =   thMxB.dumpAllThreads(true, true);
		  
		  for (ThreadInfo id: processId) {
			
			  
			  System.out.println(" Thread Name   ="+id.getThreadName()+" Lock Name "+id.getLockName()+" LockOwner "+id.getLockOwnerName()
			  +" ThreadId  = "+id.getThreadId()+ " OwnerId ="+id.getLockOwnerId());
		  }
		  
		  
	}

}
