package com.chainsys.day5;

public class FizzBuzz {

	public static void main(String[] args) {
		int i;
		for(i=1;i<=10;i++) {
			if(i%5==0) {
				System.out.println("buzz");
			}
			else if(i%3==0) {
				System.out.println("fizz");
			}
			else {
				System.out.println(i);
			}
		}
		

	}

}
