package streampractice;

public class Example1 {

	//Filtering Collection without using Stream
	
	
	// Parameters
	String busName;
	Integer ticketCost;
	Integer noOfSeats;
	String color;

	// Default Constructor
	public Example1() {

	}

	// Parameterized Constructor
	public Example1(String busName, Integer ticketCost, Integer noOfSeats, String color) {
		super();
		this.busName = busName;
		this.ticketCost = ticketCost;
		this.noOfSeats = noOfSeats;
		this.color = color;
	}

	// Generate getters and setters
	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public Integer getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Integer ticketCost) {
		this.ticketCost = ticketCost;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// To generate toString
	@Override
	public String toString() {
		return "Example1 [busName=" + busName + ", ticketCost=" + ticketCost + ", noOfSeats=" + noOfSeats + ", color="
				+ color + "]";
	}

}
