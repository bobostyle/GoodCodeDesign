package com.zte.test.io;

import java.io.Serializable;

/**
 * Student.java
 * 2017��4��20������10:15:47
 * @author cbb
 * TODO 
 */
public class Student implements Serializable{
	
	private static final long serialVersionUID = 829321893819238L;
	private String name;
	private int score;
	
	public Student(){	
	}
	
	public Student(String name, int score){
		this.name = name;
		this.score = score;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public String getName(){
		return name;
	}
	
	public int getScore(){
		return score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}	
}
