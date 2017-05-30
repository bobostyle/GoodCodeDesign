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
 * 2017��4��13������12:05:47
 * @author cbb
 * TODO ��IO�н��б���ͽ���
 */
public class IOEncodeAndDecode {
	private final static String UTF8 = "UTF-8";
	private final static String GBK = "GBK";
	
	//�ַ�ת���ֽ���
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
	
	//�ֽ�ת���ַ�
	//����ʱ���������룬����Ϊbuffer�Ƕ���Ϊ1024�Ļ������飬��Ҫ������θ����ļ�ʵ��
	//��������ȡ
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
