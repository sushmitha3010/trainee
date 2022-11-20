package com.task;
import java.util.Scanner;
public class Inputs {

	public static void main(String[] args) {
      int element[]= new int[] {1,2,3,4,5,6,7,8,9,10};
      System.out.println("the original array is:");
      for(int i=0;i<element.length;i++) {
          System.out.println(element[i]+"");
	}
	
	System.out.println(" the reverse array is:");
	for(int i=element.length-1;i>=0;i--){
		System.out.println(element[i]+"");
	}
    
}
}
