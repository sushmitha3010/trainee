package com.task;
import java.util.Scanner; 
public	class LargestSmallest {
public static void main(String[] args) {
  int numbers[]=new int[] {10,20,30,40,50,60};
  int smallest=numbers[0];
  int largest= numbers[0];
  for(int i=0;i<numbers.length;i++) {
 if(numbers[i]>largest)
 largest=numbers[i];
 else if(numbers[i]<smallest)
 smallest=numbers[i];
  }
  System.out.println("Largest number:"+largest);
  System.out.println("smallest number:"+smallest);
 
}

}
	

    

    

