package com.chainsys.novbtch;
import java.util.Scanner;
public class CHotel {

	public static void main(String[] args) {
		CHotel chotel=new CHotel();
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter hotel place");
		String place=scanner.next();
		System.out.println("enter hotel name");
		String name=scanner.next();
		System.out.println("enter hotel price");
		int hotelPrice=scanner.nextInt();
		System.out.println("enter dish name");
		String dishName=scanner.next();
		System.out.println("if hotel is ac");
		Boolean IfHotelIsAc=scanner.nextBoolean();
		System.out.println(place);
		System.out.println(name);
		System.out.println( hotelPrice);
		System.out.println(dishName);
		System.out.println(IfHotelIsAc);
		

	}

}
