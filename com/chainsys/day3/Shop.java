package com.chainsys.day3;
import java.util.Scanner;
public class Shop {

	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("enter your purchasing rate");
	  int purchasingRate=sc.nextInt();
	  if(purchasingRate>1000) {
		  purchasingRate=purchasingRate-(purchasingRate/100)*10;
		  System.out.println("you will get discount,10%,"+purchasingRate);
	  }
	  else {
		  System.out.println("you will not get discount");
	  }

	}

}
