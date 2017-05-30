package com.zte.test.springaop.proxy.staticproxy;

 /**
 * CalculateImpl.java
 * 2017年3月26日下午4:39:33
 * @author cbb
 * TODO
 */
public class CalculateImpl implements Calculate{
	
	public void calculate(){
	//	long starttime = System.currentTimeMillis();
		try{
			Thread.sleep(3* 1000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	//	long endtime = System.currentTimeMillis();
	//  System.out.println("costtime:"+ (endtime - starttime));
	}
}
