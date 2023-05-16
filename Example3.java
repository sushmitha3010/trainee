package streampractice;

import java.util.stream.Stream;

public class Example3 {
	
//Java Stream Iterating Example
	
	public static void main(String[] args) {
		Stream.iterate(1,element ->element + 1).filter(element -> element %3==0).limit(12).forEach(System.out::println);
	}
}
