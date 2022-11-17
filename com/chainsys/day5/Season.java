package com.chainsys.day5;

import java.util.Scanner;

public class Season {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the month");
		int month = sc.nextInt();
		switch (month) {
		case 1:
		case 2:
		case 3:
			System.out.println("spring season");
			break;
		case 4:
		case 5:
		case 6:
			System.out.println("summer season");
			break;
		case 7:
		case 8:
		case 9:
			System.out.println("monsoon season");
			break;
		case 10:
		case 11:
		case 12:
			System.out.println("winter season");
			break;
		default:
			System.out.println("invalid");
		}
	}
}
