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
 * 2017��5��28������11:42:28
 * @author cbb Socket�����
 * TODO
 */
public class RpcExporter {
	
	private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	public static void exporter(String hostName, int port)throws Exception{
		ServerSocket server = new ServerSocket();
		InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
		server.bind(socketAddress);
		try{
			while(true){   //�����һֱ�ڼ����ͻ��˵����������
				executor.execute(new ExporterTask(server.accept()));
			}
		}finally{
			server.close(); //����˹ر�
		}
	}
	//�����ܵ��Ŀͻ������󣬷�װ��һ��Task�������ύ���̳߳�������
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
				// parameterTypes ��  arguments����������,parameterTypes���βΣ�Ҳ���Ǻ�������ʱ��Ĳ�����
				// arguments���βΣ�Ҳ���Ǻ�������ʱ��ʵ�ʴ����ȥ�Ĳ���
				Class<?>[] parameterTypes = (Class<?>[])input.readObject();   //����Ĳ���
				Object[] arguments = (Object[])input.readObject(); //ʵ�ʵ���ʱ�Ĳ���
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
	