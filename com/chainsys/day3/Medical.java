package com.chainsys.day3;
import java.util.Scanner;
public class Medical {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println("enter your medical disability");
        String medicalDisability=sc.next();
        if(medicalDisability.equals("yes")) {
        	System.out.println("you will allow the examination");
        }
        else {
        	System.out.println("you will not allow the examination");
        }
	}

}
