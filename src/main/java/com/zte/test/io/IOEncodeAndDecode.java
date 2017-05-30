package com.zte.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * IOEncodeAndDecode.java
 * 2017年4月13日上午12:05:47
 * @author cbb
 * TODO 在IO中进行编码和解码
 */
public class IOEncodeAndDecode {
	private final static String UTF8 = "UTF-8";
	private final static String GBK = "GBK";
	
	//字符转成字节流
	public static void encode(String fileName) throws FileNotFoundException, UnsupportedEncodingException{
		if(null == fileName){
			return;
		}
		FileOutputStream input = new FileOutputStream(fileName);
		OutputStreamWriter writer = new OutputStreamWriter(input, UTF8);
		try {
			writer.write("test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//字节转成字符
	//最后的时候会出现乱码，是因为buffer是定长为1024的缓存数组，需要考虑如何根据文件实际
	//长度来读取
	public static String decode(String fileName) throws IOException{
		if(null == fileName){
			return "";
		}
		FileInputStream input = new FileInputStream(fileName);
		InputStreamReader reader = new InputStreamReader(input);
		char[] buffer = new char[200];
		int resultBuffer = 0;
		StringBuilder sb = new StringBuilder();
		while(reader.read(buffer, 0, 200) != -1){
			sb.append(new String(buffer));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		String inputfile = FileUtil.getInputFilePath() + File.separator + "input.txt";
		System.out.println(decode(inputfile));
	}
}
