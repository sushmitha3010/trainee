package com.chainsys.day3;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter any two numbers");
		int number1=scanner.nextInt();
		int number2=scanner.nextInt();
		System.out.println("choose a operations:+,-,/,%,*");
		char operator=scanner.next().charAt(0);
		if(operator=='+') {
			System.out.println("the answer is:"+(number1+number2));
		}
		else if(operator=='-') {
		    System.out.println("the answer is:"+(number1-number2));
	}
	else if(operator=='/') {
		System.out.println("the answer is:"+(number1/number2));
	}
	else if(operator=='%') {
		System.out.println("the answer is:"+(number1%number2));
	}
	else if(operator=='*') {
		System.out.println("the answer is:"+(number1*number2));
		
	}
	else {
		System.out.println("operation invalid");
	}

}
  
    }
