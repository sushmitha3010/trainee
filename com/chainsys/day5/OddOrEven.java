package com.chainsys.day5;

public class OddOrEven {
	public static void main(String[] args) {
	int number=4;
	System.out.println("the odd or even numbers from 1 to :"+number);
	for(int i=2;i<=number;i++) {
		System.out.println(i);
		if(i%2==0) {
		System.out.println("the number is even number");
		}
		else {
			System.out.println("the number is odd number");
		}
		}
	}
}
