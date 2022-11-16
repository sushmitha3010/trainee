package com.chainsys.novbtch;

public class TestHospital {

	public static void main(String[] args) {
		Hospital hospital1=new Hospital();
		hospital1.numberOfRooms=10;
		hospital1.department="cardiologist";
		hospital1.hospitalName="annai";
		hospital1.numberOfDoctersAreWorking=20;
		hospital1.ifItIsSpecialisedHospital=true;
		System.out.println(hospital1.numberOfRooms);
		System.out.println(hospital1.department);
		System.out.println(hospital1.hospitalName);
		System.out.println(hospital1.numberOfDoctersAreWorking);
		System.out.println(hospital1.ifItIsSpecialisedHospital);

	}

}
