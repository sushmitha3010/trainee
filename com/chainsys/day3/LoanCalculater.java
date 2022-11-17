package com.chainsys.day3;
import java.util.Scanner;
public class LoanCalculater {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter principle amount");
		int principleAmount=sc.nextInt();
		System.out.println("enter the interest percentage");
		int interestPercentage=sc.nextInt();
		System.out.println("enter the term");
		int term=sc.nextInt();
		int rate=(principleAmount/interestPercentage)*term;
		System.out.println("rate of interest,"+rate);
		int total=principleAmount+rate;
		System.out.println("total amount to be paid:"+total);
		int month=total/(term*12);
		System.out.println("paid per month:"+month);
		for(int i=total;i>=0;i++) {
			System.out.println(""+i);
			i=i-month;
		}
		
		
	}

}
