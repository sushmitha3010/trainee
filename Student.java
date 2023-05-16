package streampractice;

public class Student {

	// Parameters

	String name;
	Long mobileNumber;
	String address;
	String role;

	// Default Constructor

	public Student() {

	}

	// Parameterized Constructor

	public Student(String name, Long mobileNumber, String address, String role) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.role = role;
	}

	// To Generate Getters and Setters

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// To Generate ToString
	@Override
	public String toString() {
		return "Student [name=" + name + ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}
}
