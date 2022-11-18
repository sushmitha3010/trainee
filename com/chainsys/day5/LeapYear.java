package com.chainsys.day5;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println("enter a year:");
        int num=sc.nextInt();
        while(num<=2000) {
        	System.out.println(""+num);
        	if(num%4<=0) {
        		System.out.println("is leap year:");
        		num++;
        	}
        	else {
        		System.out.println("in not leap year:");
        		num++;
        	}
        }
	}

}
