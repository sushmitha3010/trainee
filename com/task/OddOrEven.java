package com.task;

public class OddOrEven {

	public static void main(String[] args) {
		int a[]= {1,2,5,6,2,8,20};
		System.out.println("odd numbers are:");
		for(int i=0;i<a.length;i++) {
		if(a[i]%2!=0) {
			System.out.println(a[i]);
		}
		}
     System.out.println("even numbrs are:");
     for(int i=0;i<a.length;i++) {
    	 if(a[i]%2==0) {
    		 System.out.println(a[i]);
    	 }
     }
	}

}
