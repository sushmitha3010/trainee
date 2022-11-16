package com.chainsys.novbtch;

public class TestBook {

	public static void main(String[] args) {
		Book book1=new Book();
		book1.page=17;
		book1.author="john";
		book1.edition=2020;
		book1.isEnglish=true;
		book1.title="python";
		System.out.println(book1.page);
		System.out.println(book1.author);
		System.out.println(book1.edition);
		System.out.println(book1.isEnglish);
		System.out.println(book1.title);// TODO Auto-generated method stub

	}

}
