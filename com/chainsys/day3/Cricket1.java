package com.chainsys.day3;
import java.util.Scanner;
public class Cricket1 {
	
   public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter two team name");
	String teamA=scanner.next();
	String teamB=scanner.next();
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