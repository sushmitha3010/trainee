package com.chainsys.novbtch;

public class Testvehichle {

	public static void main(String[] args) {
		Vehichle vehichle1=new Vehichle();
		vehichle1.noOfVehichle=3;// TODO Auto-generated method stub
        vehichle1.vehichleName="car";
        vehichle1.vehichleBrandName="maruti suzuki";
        vehichle1.ifVehichleIsTwoWheeler=false;
        vehichle1.numberPlate=46;
        System.out.println(vehichle1.noOfVehichle);
        System.out.println(vehichle1.vehichleName);
        System.out.println(vehichle1.vehichleBrandName);
        System.out.println(vehichle1.ifVehichleIsTwoWheeler);
        System.out.println(vehichle1.numberPlate);
	}

}

