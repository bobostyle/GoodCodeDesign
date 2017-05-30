package com.zte.test.rpc;

import java.net.InetSocketAddress;

/**
 * RpcTest.java
 * 2017年5月28日下午7:16:53
 * @author cbb
 * TODO
 */
public class RpcTest {
	public static void main(String[] args) {
		//线程启动socket的服务端，对端口8090进行监听
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
