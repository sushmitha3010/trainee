package com.chainsys.day3;
import java.util.Scanner;
public class Cricket {
	
	private void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter two team name");
	String TeamA=scanner.next();
	String TeamB=scanner.next();
	System.out.println("enter team score");
	int score=scanner.nextInt();
	if(score<250) {
		System.out.println("team A is winner");
	}
	else {
		System.out.println("team B is winner");
	}
	}

}
