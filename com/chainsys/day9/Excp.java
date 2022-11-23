package com.chainsys.day9;

public class Excp {

	public static void main(String[] args) {
		int rollNo[] = { 2, 4, 6, 8, 10, 12, 5};
		for(int i=0; i<=7;i++) {
			
		}
		try {
			for(int i = 0; i <= 7; i++) {
				System.out.println(rollNo[i]);
			}
		} catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		} catch (ArrayIndexOutOfBoundsException arr) {
			System.out.println(arr.getMessage());
		} catch (NullPointerException arr) {
			System.out.println(arr.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
