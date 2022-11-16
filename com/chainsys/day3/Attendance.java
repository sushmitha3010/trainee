package com.chainsys.day3;
import java.util.Scanner;
public class Attendance {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of classes held");
		int numberOfClassesHeld=sc.nextInt();
		System.out.println("enter number of classes attended");
		int numberOfClassesAttended=sc.nextInt();
		float percentage=((numberOfClassesAttended*100)/( numberOfClassesHeld));
		System.out.println("percentageOfClassAttended:"+percentage+"%");
		if(percentage>=75) {
			System.out.println("you can write the exam");
		}
		else {
			System.out.println("you can not write the exam");
		}

	}

}
