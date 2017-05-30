package com.zte.test.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * RpcImporter.java
 * 2017年5月28日下午12:15:50
 * @author cbb 
 * TODO Socket客户端代码
 */
public class RpcImporter {

	@SuppressWarnings("unchecked")
	public <T extends Object> T importer(final Class<T> serviceClass , final InetSocketAddress addr){
		return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{serviceClass.getInterfaces()[0]}
		, new InvocationHandler(){
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Socket socket = null;
				ObjectInputStream input = null;
				ObjectOutputStream output = null;
				try{
					socket = new Socket();
					socket.connect(addr);
					output = new ObjectOutputStream(socket.getOutputStream());
					output.writeUTF(serviceClass.getName());  //注意不能乱顺序，因为读取的顺序已经确定了
					output.writeUTF(method.getName());
					output.writeObject(method.getParameterTypes());
					input = new ObjectInputStream(socket.getInputStream());
					return input.readObject();
				}finally{
					if(socket != null){
						socket.close();
					}
					
					if(input != null){
						input.close();
					}
					
					if(output != null){
						output.close();
					}
				}
			}
		});
	}
}
