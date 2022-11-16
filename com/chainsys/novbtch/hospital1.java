package com.chainsys.novbtch;
import java.util.Scanner;
public class hospital1 {

	public static void main(String[] args) {
		hospital1 hospital1=new hospital1();
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter number of rooms");
		int numberOfRooms=scanner.nextInt();
		System.out.println("enter department");
		String department=scanner.next();
		System.out.println("enter hospital name");
		String hospitalName=scanner.next();
        System.out.println("enter number of docters are working");
        int noOfDoctersAreWorking=scanner.nextInt();
        System.out.println("if it is specialised hospital");
        Boolean ifItIsSpecialisedHospital=scanner.nextBoolean();
        System.out.println(numberOfRooms);
        System.out.println(department);
        System.out.println(hospitalName);
        System.out.println(noOfDoctersAreWorking);
        System.out.println(ifItIsSpecialisedHospital);
        
        

	}
	

}
