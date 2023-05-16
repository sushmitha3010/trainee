package streamtest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import streampractice.Example1;

public class Example2Test {

	public static void main(String[] args) {
		List<Example1> busList = new ArrayList<Example1>();

		busList.add(new Example1("BusyBus", 20, 10, "yellow"));
		busList.add(new Example1("Red", 30, 12, "red"));
		busList.add(new Example1("intercity", 40, 14, "orange"));
		busList.add(new Example1("kailasa", 50, 16, "green"));

		//sum by using collector methods
		
		List<Integer> busPriceList = busList.stream().filter(p -> p.getTicketCost()>40).map(p ->p.getTicketCost()).collect(Collectors.toList());
		System.out.println(busPriceList);
		
		List<String> busnameList = busList.stream().filter(p -> p.getBusName().length()>4).map(p ->p.getBusName()).collect(Collectors.toList());
		System.out.println(busnameList);
		
		List<Integer> busSeatList = busList.stream().filter(p -> p.getNoOfSeats()>10).map(p ->p.getNoOfSeats()).collect(Collectors.toList());
		System.out.println(busSeatList);

		List<String> busColorList = busList.stream().filter(p -> p.getColor().length()<4).map(p ->p.getColor()).collect(Collectors.toList());
		System.out.println(busColorList);
	}
}
