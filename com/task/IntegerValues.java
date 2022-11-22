package com.task;

import java.util.Scanner;

public class IntegerValues {

public static void main(String[] args) {
 int a=0,b=0,c=0, i,j,x=0,y=0;
 int[] arr=new int[10];
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter 10 numbers:");
 for(i=0;i<10;i++)
 arr[i]=sc.nextInt();
 for(i=0;i<10;i++) {
 if(arr[i]>0)
 b++;
 else if(arr[i]>0)
 a++;
 else
 c++;
 }
 System.out.println("\nTotal positive number:"+a);
 System.out.println("Total negative number:"+b);
 System.out.println("Total zero:"+c);
    

	}

}
