package com.chainsys.day8;
import java.util.ArrayList;
public class ListOfArrays {

	public static void main(String[] args) {
		ArrayList a=new ArrayList();
		a.add(12);
		a.add(15);
		a.add(8);
		a.add(27);
		System.out.println(a);
		a.add(47);
        a.add(62);
        a.add(3,90);
        System.out.println(a);
        a.remove(1);
        System.out.println(a);
	}

}
