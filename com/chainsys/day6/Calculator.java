package com.chainsys.day6;

public class Calculator {

	public static void main(String[] args) {
		add();
		sub();
		div();
		module();
	}
		public static void add() {
			int a=5,b=10;
			int add=a+b;
			System.out.println("addition:"+add);
		}		
        public static void sub(){
        	int a=5,b=10;
        	int sub=a-b;
	        System.out.println("substraction:"+sub);
        }
        public static void div() {
        	int a=5,b=10;
        	int div=a/b;
    	   System.out.println("division:"+div);
        }
        public static void module() {
        	int a=5,b=10;
        	int mod=a%b;
        	System.out.println("module:"+mod);
        
	}

}
