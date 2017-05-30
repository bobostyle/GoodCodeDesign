package com.zte.test.rpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * RpcExporter.java
 * 2017年5月28日上午11:42:28
 * @author cbb Socket服务端
 * TODO
 */
public class RpcExporter {
	
	private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	public static void exporter(String hostName, int port)throws Exception{
		ServerSocket server = new ServerSocket();
		InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
		server.bind(socketAddress);
		try{
			while(true){   //服务端一直在监听客户端的链接请求等
				executor.execute(new ExporterTask(server.accept()));
			}
		}finally{
			server.close(); //服务端关闭
		}
	}
	//将接受到的客户端请求，封装成一个Task，并且提交给线程池来处理
	private static class ExporterTask extends Thread{
		private Socket client;
		public ExporterTask(Socket client){
			this.client = client;
		}
			
		@Override
		public void run() {
			ObjectInputStream input = null;
			ObjectOutputStream output = null;
			try{
				input = new ObjectInputStream(client.getInputStream());
				String interfaceName = input.readUTF();
				Class<?> service = Class.forName(interfaceName);
				String methodName = input.readUTF();
				// parameterTypes 和  arguments的区别在于,parameterTypes是形参，也就是函数定义时候的参数。
				// arguments是形参，也就是函数调用时候，实际传入进去的参数
				Class<?>[] parameterTypes = (Class<?>[])input.readObject();   //定义的参数
				Object[] arguments = (Object[])input.readObject(); //实际调用时的参数
				Method method = service.getMethod(methodName, parameterTypes);
				Object result = method.invoke(service.newInstance(), arguments);
				output = new ObjectOutputStream(client.getOutputStream());
				output.writeObject(result);
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				closeInputStream(input);
				closeOutputStream(output);
				closeSocket(client);
			}
		}
		
		private void closeSocket(Socket socket){
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private void closeInputStream(InputStream input){
			if(input != null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private void closeOutputStream(OutputStream output){
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}	
	