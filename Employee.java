package streampractice;

public class Employee {
	
	String name;
	double salary;
	String title;
	
	public Employee() {
		
	}

	public Employee(String name, double salary, String title) {
		super();
		this.name = name;
		this.salary = salary;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", title=" + title + "]";
	}
	
	

}
