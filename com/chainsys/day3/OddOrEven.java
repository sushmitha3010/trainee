package com.chainsys.day3;
import java.util.Scanner;
public class OddOrEven {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a number");
		int number=scanner.nextInt();
		if(number%2==0) {
			System.out.println("the given number is even");
		}else {
			System.out.println("the given number is odd");
		}

	}

}
