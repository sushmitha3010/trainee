package com.chainsys.day5;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter number 1 to 4");
		 int number1To4=sc.nextInt();
		 switch(number1To4) {
		 case 1:{
			 System.out.println("sunday");
			 break;
		 }
		 case 2:{
			 System.out.println("monday");
			 break;
			 
		 }
		 case 3:{
			 System.out.println("tuesday");
			 break;
		 }
		 case 4:{
             System.out.println("wednesday");
             break;
		 }
		 default:{
			 System.out.println("invalid");
		 }
		 
		 }
	}
}
	

