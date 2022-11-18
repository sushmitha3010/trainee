package com.chainsys.day5;

import java.util.Scanner;

public class AverageNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int count;
		float average=0;
		int number,sum=0;
		System.out.println("enter count of numbers");
		count=sc.nextInt();
		for(int i=0;i<count;i++) {
		number=sc.nextInt();
		 sum=sum+number;
	}
		 average=sum/count;
		 System.out.println("sum of entered numbers:"+sum);
		 System.out.println("enter the average numbers:"+average);

	}

}
