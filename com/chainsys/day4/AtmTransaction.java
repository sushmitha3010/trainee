package com.chainsys.day4;
import java.util.Scanner;
public class AtmTransaction {

	public static void main(String[] args) {
	int balance=10000;
	 Scanner sc=new Scanner(System.in);
	 System.out.println("ATM");
	 System.out.println("choose the functions:"+("withdraw,transaction,check balance,exit"));
	 String function=sc.next();
	 if(function.equals("withdraw")) {
	 System.out.println("enter withdrawl money");
	 int amount=sc.nextInt();
	 	if(balance>=amount) {
	 		balance=balance-amount;
	 		System.out.println("please collect your money");
		 
	}
	 	else {
	 		System.out.println("balance is not sufficient");
	 	}
	 }	
	 else if(function.equals("transaction")){
		 System.out.println("entertransactionmoney");
		 int depositMoney=sc.nextInt();
		 System.out.println("money deposited:"+depositMoney);
			 
		 }
	else if(function.equals("checkbalance")) {
		 System.out.println("entercheckbalance:"+balance);
	 }
	 else if(function.equals("exit")) {
		 System.exit(0);
	 }
	 else {
		 System.out.println("function invalid");
	 }
	
	}
}
