package streampractice;

public class Example2 {
	
	//Filtering Collection by using Stream
	
	// Parameters
	String busName;
	Float ticketCost;
	Integer noOfSeats;
	String color;

	// Default Constructor
	public Example2() {

		}

	// Parameterized Constructor
	public Example2(String busName, Float ticketCost, Integer noOfSeats, String color) {
			super();
			this.busName = busName;
			this.ticketCost = ticketCost;
			this.noOfSeats = noOfSeats;
			this.color = color;
		}
}
