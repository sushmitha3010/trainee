package streamtest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import streampractice.Employee;

public class EmployeeTest {
	
	public static void main(String[] args) {

	List<Employee> employeeList = new ArrayList<Employee>();
	
	//adding products
	employeeList.add(new Employee("Reema",50000f,"Manager"));
	employeeList.add(new Employee("Abinaya",60000f,"TL"));
	employeeList.add(new Employee("Ramya",70000f,"HR"));
	employeeList.add(new Employee("Archana",80000f,"Developer"));
	
	//5). Group an array of employee records into a data map organized by job title
	List<String> employeesList = employeeList.stream().
			filter(p -> p.getTitle().length()>=2)
			.map(p ->p.getTitle())
			.collect(Collectors.toList());
	System.out.println(employeesList);
	
	//12). Calculate average salary of all employee in the list
	double averageSalary = employeeList.stream()
	          .mapToDouble(Employee::getSalary)
	          .average()
	          .orElse(0.0);
	 System.out.println("Average salary: " + averageSalary);
	}
}
