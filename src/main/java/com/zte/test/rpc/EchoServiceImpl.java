package com.zte.test.rpc;

 /**
 * EchoServiceImpl.java
 * 2017��5��28������11:38:48
 * @author cbb
 * TODO 
 */
public class EchoServiceImpl implements EchoService{
	@Override
	public String echo(String ping) {
		return (ping != null) ? ping + "---> I am ok." : " I am ok."; 
	}
}
