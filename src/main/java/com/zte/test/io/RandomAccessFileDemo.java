package com.zte.test.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * RandomAccessFile.java
 * 2017年4月20日上午12:20:39
 * @author cbb
 * TODO RandomAccessFile 这是一个随机存取文件的类，很好很强大
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
		//有个文件指针，从文件头0字节开始，一直随着往文件中写入内容，一直持续偏移，以char为单位偏移。写入三个Student对象后，
		// 34 * 3 = 102,从0开始，所以此时文件指针的位置是102。
		// readInt(),文件指针会往后偏移4个字符char
		System.out.println("randomAccessFile.position:" + randomAccessFile.getFilePointer());
		randomAccessFile.seek(10); //设置文件指针的位置
		System.out.println("randomAccessFile.position:" + randomAccessFile.getFilePointer());
		//System.out.println("randomAccessFile.readInt()" + randomAccessFile.readInt()); 
//		randomAccessFile.seek((num-1) * Student.size()); //以char为单位
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
