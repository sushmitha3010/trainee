package com.chainsys.day5;
import java.util.Scanner;
public class Integer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,sum=0;
		System.out.println("enter the number");
		n=sc.nextInt();
		for(int i=1;i<n;i++) {
			sum+=i;
		}
		System.out.println(sum);

	}

}
