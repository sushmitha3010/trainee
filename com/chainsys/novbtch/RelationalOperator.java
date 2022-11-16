package com.chainsys.novbtch;
import java.util.Scanner;
public class RelationalOperator {

	public static void main(String[] args) {
	  Scanner scanner=new Scanner(System.in);
	  System.out.println("enter your age");
	  int yourAge=scanner.nextInt();
	  if(yourAge>18) {
		  System.out.println("you are a mager");
	  }
	  else {
		  System.out.println("you are a minor");
	  }
	}

}
