package com.zte.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * ObjectInputStreamAndObjectOutputStream.java
 * 2017年5月28日下午10:20:36
 * @author cbb
 * TODO 对IO中的ObjectInputStream 和 ObjectOutputStream的使用 
 * ObjectInputStream和ObjectOutputStream可以实现对Object对象的直接读写，不用
 * 像以前一样，按字节读或者按字节写.要求是Object对象必须要序列化
 */
public class ObjectInputStreamAndObjectOutputStream {
	
	private static final String FILE_PATH_NAME = FileUtil.getInputFilePath() + File.separator + "bean.txt";
	
	public static void write2File(){
		Student student = new Student("cbb", 10086);
		ObjectOutputStream output = null;
		try{
			output = new ObjectOutputStream(new FileOutputStream(FILE_PATH_NAME));
			output.writeObject(student);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ok");
	}
	
	public static void readFromFile() {
		ObjectInputStream input = null;
		try{
			input = new ObjectInputStream(new FileInputStream(FILE_PATH_NAME));
			Student student = (Student)input.readObject();
			System.out.println(student);
			System.out.println(student.getName());
			System.out.println(student.getScore());
		}catch(IOException ex){
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		readFromFile();
		write2File();
	}
}

