package com.chainsys.novbtch;
import java.util.Scanner;
public class LogicalOperator {

	public static void main(String[] args) {
		int age;
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter your age");
		int yourAge=scanner.nextInt();
		if(yourAge>18) {
			System.out.println("enter marrital status");
			String marritalStatus=scanner.next();
			if(marritalStatus.equals("married")) {
				System.out.println("you are married");
			}
		     else {		
			System.out.println(" you are unmarried");
		    }
		}
		else {
			System.out.println("you are not eligible to married");
		}
	}
}

