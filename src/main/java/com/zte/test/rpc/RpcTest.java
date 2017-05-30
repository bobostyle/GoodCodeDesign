package com.zte.test.rpc;

import java.net.InetSocketAddress;

/**
 * RpcTest.java
 * 2017��5��28������7:16:53
 * @author cbb
 * TODO
 */
public class RpcTest {
	public static void main(String[] args) {
		//�߳�����socket�ķ���ˣ��Զ˿�8090���м���
		new Thread(new Runnable(){
			@Override
			public void run() {
				try{
					RpcExporter.exporter("localhost", 8090);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}}).start();
		
		RpcImporter importer = new RpcImporter();
		EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8090));
		System.out.println(echo.echo("Are you ok?"));
	}			
}
