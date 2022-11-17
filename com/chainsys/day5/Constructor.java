package com.chainsys.day5;

public class Constructor {
	String name;
	int id;
	Constructor()
	{
		name="lachu";
		id=3333;

	}
	public static void main(String[] args) {
		Constructor con=new Constructor();
				System.out.println("employee name:"+"lachu");
				System.out.println("employee id:"+3333);
	}
}
