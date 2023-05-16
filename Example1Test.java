package streamtest;

import java.util.ArrayList;
import java.util.List;

import streampractice.Example1;

public class Example1Test {

	public static void main(String[] args) {
		List<Example1> busList = new ArrayList<Example1>();
	 
		busList.add(new Example1("BusyBus",20,10,"yellow"));
		busList.add(new Example1("RedBus",30,12,"red"));
		busList.add(new Example1("intercity",40,14,"orange"));
		busList.add(new Example1("kailasa",50,16,"green"));
		
		List<Integer>busPriceList = new ArrayList<Integer>();
		for(Example1 example : busList) {
			if(example.getTicketCost()<50) {
				busPriceList.add(example.getTicketCost());
			}
		}
		System.out.println(busPriceList);
	} 
}
