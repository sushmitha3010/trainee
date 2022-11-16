package com.chainsys.novbtch;

public class TestHotel {

	public static void main(String[] args) {
		Hotel hotel1=new Hotel();
		hotel1.place="trichy";
		hotel1.name="vasandham";
		hotel1.price=20000;
		hotel1.dish="briyani";
		hotel1.ifHotelIsAc=true;
		System.out.println(hotel1.place);
		System.out.println(hotel1.name);
		System.out.println(hotel1.price);
		System.out.println(hotel1.dish);
		System.out.println(hotel1.ifHotelIsAc);
	}

}
