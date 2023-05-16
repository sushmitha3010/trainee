package streampractice;

public class Example4 {
	
	// Filtering and Iterating Collection
	
	//parameters
	Integer studentRegNo;
	String studentName;
	Integer mark;
	
	//default constructor
	public Example4() {
	
	}

	//parameterized constructor
	public Example4(Integer studentRegNo, String studentName, Integer mark) {
		super();
		this.studentRegNo = studentRegNo;
		this.studentName = studentName;
		this.mark = mark;
	}

	//generate getters and setters
	public Integer getStudentRegNo() {
		return studentRegNo;
	}

	public void setStudentRegNo(Integer studentRegNo) {
		this.studentRegNo = studentRegNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	//to generate to string
	@Override
	public String toString() {
		return "Example4 [studentRegNo=" + studentRegNo + ", studentName=" + studentName + ", mark=" + mark + "]";
	}	
}
