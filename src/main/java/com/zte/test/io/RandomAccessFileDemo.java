package com.zte.test.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * RandomAccessFile.java
 * 2017��4��20������12:20:39
 * @author cbb
 * TODO RandomAccessFile ����һ�������ȡ�ļ����࣬�ܺú�ǿ��
 */
public class RandomAccessFileDemo {
	
	public static void writeFile(String fileName, int num) throws IOException{
		if(fileName == null || fileName.isEmpty()){
			return ;
		}
		File file = new File(fileName);
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		Student[] students = getStudentInfo();
		for(Student student : students){
			randomAccessFile.writeChars(student.getName());
			randomAccessFile.writeInt(student.getScore());
		}
		//�и��ļ�ָ�룬���ļ�ͷ0�ֽڿ�ʼ��һֱ�������ļ���д�����ݣ�һֱ����ƫ�ƣ���charΪ��λƫ�ơ�д������Student�����
		// 34 * 3 = 102,��0��ʼ�����Դ�ʱ�ļ�ָ���λ����102��
		// readInt(),�ļ�ָ�������ƫ��4���ַ�char
		System.out.println("randomAccessFile.position:" + randomAccessFile.getFilePointer());
		randomAccessFile.seek(10); //�����ļ�ָ���λ��
		System.out.println("randomAccessFile.position:" + randomAccessFile.getFilePointer());
		//System.out.println("randomAccessFile.readInt()" + randomAccessFile.readInt()); 
//		randomAccessFile.seek((num-1) * Student.size()); //��charΪ��λ
//		Student stu = new Student();
//		stu.setName(readName(randomAccessFile));
//		stu.setScore(randomAccessFile.readInt());
//		System.out.println(stu.getName());
//		System.out.println(stu.getScore());
	}

	public static Student[] getStudentInfo(){
		Student[] students = {new Student("Justdsfd", 90), new Student("mosdfsdfdfsddfmor", 97), new Student("nicetomeetyouandyou", 90)};
		return students;
	}
	
	private static String readName(RandomAccessFile randomAccessFile) throws IOException{
		char[] name = new char[15];
		for(int i = 0; i < name.length; i++){
			name[i] = randomAccessFile.readChar();
		}
		return new String(name).replace('\0', ' ');
	}
	
	public static void main(String[] args) throws IOException {
		String filePath = FileUtil.getInputFilePath() + File.separator + "random.txt";
		writeFile(filePath, 1);
	}
	
}
