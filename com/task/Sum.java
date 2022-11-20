package com.task;
import java.util.Scanner;
public class Sum {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int sum=0;
	int product=1;
	int a[]=new int[4];
	System.out.println("enter the 4 elements:");
	for(int i=0;i<a.length;i++) {
		a[i]=sc.nextInt();
		sum=sum+a[i];
		product=product*a[i];
	}
	System.out.println("sum of the elements of an array:"+sum);
	System.out.println("product of the elements of an array:"+product);
	}
}


