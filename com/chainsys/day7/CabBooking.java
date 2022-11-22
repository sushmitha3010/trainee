package com.chainsys.day7;

import java.util.Scanner;

public class CabBooking {

	public static void main(String[] args) {
		int c;
		Scanner sc = new Scanner(System.in);
		System.out.println("choose your cab type");
		System.out.println("1.mini car:");
		System.out.println("2.micro car:");
		System.out.println("3.prime car:");
		System.out.println("enter your type of cab:");
		int c1 = sc.nextInt();
		switch (c1) {
		case 1: {
			System.out.println("you have select mini car:");
			System.out.println("it cost Rs6/km:");
			System.out.println("do you want to continue with mini?Y/N");
			String s = sc.next();
			while (s.equals("s")) {
				System.out.println("enter how many km you have to travel:");
				int a = sc.nextInt();
				c = a * 6;
				System.out.println(" your payable amount is:" + c);
				System.out.println("do you want to conform your cab booking?");
				char choice = sc.next().charAt(0);
				int bookingNumber = (int) ((float) Math.random()*10000);
				System.out.println("Booking Reference : "+bookingNumber);
				if (choice == 'y') {
					System.out.println("your cab is booked");
				} else {
					System.out.println("you cancelled your cab");
				}
			}
			break;
		}
		case 2: {
			System.out.println("you have select micro car:");
			System.out.println("it cost Rs8/km:");
			System.out.println("do you want to continue with micro?Y/N");
			String s = sc.next();
			while (s.equals("s")) {
				System.out.println("enter how many km you have to travel:");
				int a = sc.nextInt();
				c=a * 8;
				System.out.println(" your payable amount is:" + c);
				System.out.println("do you want to conform your cab booking?");
				char choice = sc.next().charAt(0);
				int bookingNumber = (int) ((float) Math.random()*10000);
				System.out.println("Booking Reference : "+bookingNumber);
				if (choice == 'y') {
					System.out.println("your cab is booked");
				} else {
					System.out.println("you cancelled your cab");
				}
			}
			break;
		}
		case 3: {
			System.out.println("you have select prime car:");
			System.out.println("it cost Rs9/km:");
			System.out.println("do you want to continue with prime?Y/N");
			String s = sc.next();
			while (s.equals("s")) {
				System.out.println("enter how many km you have to travel:");
				int a = sc.nextInt();
				c = a * 9;
				System.out.println(" your payable amount is:" + c);
				System.out.println("do you want to conform your cab booking?");
				char choice = sc.next().charAt(0);
				int bookingNumber = (int) ((float) Math.random()*10000);
				System.out.println("Booking Reference : "+bookingNumber);
				if (choice == 'y') {
					System.out.println("your cab is booked");
				} else {
					System.out.println("you cancelled your cab");
				}
			}
			break;

		}

		default: {
			System.out.println("invalid choice");
		}
		}
	}
}
