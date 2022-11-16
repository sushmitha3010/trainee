package com.chainsys.novbtch;
import java.util.Scanner;
public class book1 {

	public static void main(String[] args) {
		book1 book1=new book1();
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter book page number");
		int pageNumber=scanner.nextInt();
		System.out.println("enter author name");
		String authorName=scanner.next();
		System.out.println("enter edition");
		int edition=scanner.nextInt();
		System.out.println("enter is english");
		Boolean isEnglish=scanner.nextBoolean();
		System.out.println("enter title");
		String title=scanner.next();
		System.out.println(pageNumber);
		System.out.println(authorName);
		System.out.println(edition);
		System.out.println(isEnglish);
		System.out.println(title);

	}

}
