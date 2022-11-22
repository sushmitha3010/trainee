package com.chainsys.day8;

import java.util.Scanner;

public class EmailArray {

	public static void main(String[] args) {
		/*String m[]={"ramu@gmail.com,ravi@gmail.com,raju@gmail.com,raja@gmail.com,taml@gmail.com"};
		for(int i=0;i<m.length;i++) {
			System.out.println("email id:"+m[i]);
		}*/
		Scanner sc=new Scanner(System.in);
        String s[]=new String[1];
		System.out.println("enter a email id:");
		for(int i=0;i<s.length;i++) {
			s[i]=sc.next();
			if(s[i].length()>5) {
				System.out.println("your email id is valid:");
		}
			else {
				System.out.println("invalid email id:");
			}
		}	
		for(int i=0;i<s.length;i++) {
			if(s.length>10) {
			System.out.println("email id:"+s[i]);
		}
			
			}
	}

}

