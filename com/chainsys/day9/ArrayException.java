package com.chainsys.day9;

public class ArrayException {

	public static void main(String[] args) {
		int no1 = 10, no2 = 2, no3 = 0;
		// System.out.println(no1 / no2);
	    try {
	    	int result=no1+no2;
	    	System.out.println(result);
	    	int avg = result / no3;
	    } catch (Exception e) {
	        System.out.println(e.getMessage());    	
	    	
	    }

	}

}
