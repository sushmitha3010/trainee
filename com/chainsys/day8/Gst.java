package com.chainsys.day8;
import java.util.Scanner;
public class Gst {

	public static void main(String[] args) {
		int productQuantity = 0;
		String price;
		String productName=null;
		int amount = 0,gstAmount=0,bill=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter user name:");
		String name=sc.next();
		if(name.length()>2) {
			System.out.println("valid user name");
		
		System.out.println("enter category:");
		System.out.println("1.mobile");
		System.out.println("2.textile");
		System.out.println("3.food");
		System.out.println("4.electronics");
		System.out.println("5.plastic");
		int c1=sc.nextInt();
        switch (c1) {
	    case 1:{
		System.out.println("enter your moile name:");
		productName=sc.next();
		System.out.println("enter your product quantity:");
		 productQuantity=sc.nextInt();
		System.out.println("do you want to purchase this mobile?(y/n)");
		String s=sc.next();
		if(s.equals("yes")) {
			System.out.println("the gst will be 20%");
			System.out.println("Enter amount:");
			amount=sc.nextInt();
			gstAmount=(amount*20)/100;
			bill=amount+gstAmount;
			System.out.println("Bill amount:"+bill);
			
	System.out.println("you have purchase a mobile:"+bill);
		}
		else {
			System.out.println("you could not purchase a mobile:");
		}
			
	    }	
	    break;
	    
	
        case 2:{
        	System.out.println("enter type of dress:");
            productName=sc.next();
        	System.out.println("enter your product quantity:");
        	 productQuantity=sc.nextInt();
        	System.out.println("do you want to purchase this dress?(y/n)");
        	String s=sc.next();
        	if(s.equals("yes") ){
        		System.out.println("the gst will be 15%");
        		System.out.println("enter amount:");
        	   amount=sc.nextInt();
        	   gstAmount=(amount*15)/100;
        	   bill=amount+gstAmount;
        		System.out.println("price amount:"+bill);
        		System.out.println("you have purchase a dress:"+bill);
        	}
        	else {
        		System.out.println("you could not purchase a dress:");
        	}
        		
        		}
        	break;
        	
        case 3:{
        	System.out.println(" enter your food name:");
        	productName=sc.next();
        	System.out.println("enter your product quantity:");
        	 productQuantity=sc.nextInt();
        	System.out.println("you have purchase a food?(y/n)");
        	String s=sc.next();
        		if(s.equals("yes")) {
        			System.out.println("the gst will be 5%");
        			System.out.println("enter amount:");
        		    amount=sc.nextInt();
        		    gstAmount=(amount*5)/100;
        		    bill=amount+gstAmount;
        			System.out.println("you have purchase a food:"+bill);
        		}
        		else {
        			System.out.println("you could not  purchase a food:");
        		}
        		break;
        }
        case 4:{
        	System.out.println("enter prouduct name:");
        	productName=sc.next();
        	System.out.println("enter your product quantity:");
        	productQuantity=sc.nextInt();
        	System.out.println("do you want to buy this product?(y/n)");
        	String s=sc.next();
    		if(s.equals("yes")) {
    			System.out.println("the gst will be 25%");
    			System.out.println("enter amount:");
    		    amount=sc.nextInt();
    		    gstAmount=(amount*25)/100;
    		    bill=amount+gstAmount;
    			System.out.println("you have buy this product:"+bill);
    		}
    		else {
    			System.out.println("you could not buy this product:");
    		}
    		break;
        	
        }
        case 5:{
        	System.out.println("enter prouduct name:");
        	productName=sc.next();
        	System.out.println("enter your product quantity:");
        	productQuantity=sc.nextInt();
        	System.out.println("do you want to buy this product?(y/n)");
        	String s=sc.next();
    		if(s.equals("yes")) {
    			System.out.println("the gst will be 20%");
    			System.out.println("enter amount:");
    		    amount=sc.nextInt();
    		    gstAmount=(amount*20)/100;
    		    bill=amount+gstAmount;
    			System.out.println("you have buy this product:"+bill);
    		}
    		else {
    			System.out.println("you could not buy this product:");
    		}
    		break;
        }
        default:
        	System.out.println("Invalid data");
        }
        System.out.println("       Welcome!!!!!");
        System.out.println("Date:"+("23/11/2022")+"\n"+"time:"+("2:30 pm")+"\t"+             "bill no:"+("15"));
        System.out.println("--------------------");
        System.out.println("Customer Name:"+name );
        System.out.println("-----------------");
		System.out.println("Product Name:"+productName);
        System.out.println("------------------");
        System.out.println("Product quantity:"+ productQuantity );
        System.out.println("------------------");
        System.out.println("Price:"+ amount );
        System.out.println("------------------");
        System.out.println("GST Price:"+ gstAmount );
        System.out.println("-------------------"); 
        System.out.println("Total:"+ bill );
        System.out.println("-------------------");
        System.out.println("Thank You! Visit Again");
        System.out.println("---------------------");
        
}
	    else {
        	System.out.println("invalid user name");
            
        }
}
}
	


		
		
		
	

	


