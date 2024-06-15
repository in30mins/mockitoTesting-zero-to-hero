package com.in30mins.source;

public class Assignment1 {

	public int convertStringToInt(String str) {
		if(str == null || str.trim().length()==0) {
			throw new IllegalArgumentException("enter string only");
		}
		return Integer.valueOf(str);
	}
	public static void main(String[] args) {
		Assignment1 ass = new Assignment1();
		int num = ass.convertStringToInt("20");
		System.out.println(num);
	}
}
