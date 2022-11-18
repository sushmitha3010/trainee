package com.chainsys.day5;

public class Fibonacci {

	public static void main(String[] args) {
		int n=10,a=0,b=1,sum=0;
		System.out.println(a+""+b);
		for(int i=2;i<n;i++) {
			sum=a+b;
			System.out.println(""+sum);
			a=b;
			b=sum;
		}

	}

}
