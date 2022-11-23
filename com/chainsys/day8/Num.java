package com.chainsys.day8;

public class Num {
	public static void main(String[] args) {
		int mobileNumber[]= {12345,67890,69876,54321,34786};
		String name[]= {"ria","zoy","ram","siva","tom"};
		System.out.println("Before Sorting");
		for(int i=0;i<mobileNumber.length;i++) {
			System.out.println("Before Sorting:"+mobileNumber[i]);
		}
		System.out.println("After Sorting");
		for(int i=0;i<mobileNumber.length;i++) {
			System.out.println("After Sorting:"+(mobileNumber[i]));
		}
	}

}
