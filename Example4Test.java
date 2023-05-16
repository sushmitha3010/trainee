package streamtest;

import java.util.ArrayList;
import java.util.List;

import streampractice.Example4;

public class Example4Test {

	public static void main(String []args) {
		
		List<Example4> studentList = new ArrayList<Example4>();
		
		//adding products
		studentList.add(new Example4(810418101,"ramya",80));
		studentList.add(new Example4(810418102,"sus",85));
		studentList.add(new Example4(810418103,"kaaviya",90));
		studentList.add(new Example4(810418104,"meenakumari",95));
		
		//5). Group an array of employee records into a data map organized by job title
		//filtering data 
		studentList.stream().filter(example ->example.getStudentName()=="sus").forEach(example -> System.out.println(example.getStudentRegNo()));
	}
}
