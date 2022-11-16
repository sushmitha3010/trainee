package com.chainsys.novbtch;
import java.util.Scanner;
public class Employee {

	public static void main(String[] args) {
			Employee employee=new Employee();
			Scanner scanner=new Scanner(System.in);
			System.out.println("enter employee name");
			String name=scanner.next();
			System.out.println("enter employee id");
			int employeeId=scanner.nextInt();
			System.out.println(name);
			System.out.println(employeeId);
			

	}

}
