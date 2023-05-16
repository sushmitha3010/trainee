package streamtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import streampractice.Student;

public class StudentTest {
	
	public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
		
		//adding products
		studentList.add(new Student("Reema",9820447099l,"105/12,anna nagar,chennai","Trainee"));
		studentList.add(new Student("Abinaya",8934447098l,"201/78,krishna nagar,chennai","Employee"));
		studentList.add(new Student("Ramya",8934907654l,"107/14,balaji nagar,chennai","Trainee"));
		studentList.add(new Student("Archana",9940542897l,"108/16,kk nagar,chennai","Employee"));
		
		// 1). Get student with exact match name "Reema"
		 List<Student> studentName = studentList.stream()
                 .filter(Student -> Student.getName().toString().equals("Reema"))
                 .collect(Collectors.toList());
		 System.out.println("Name:"+studentName);
		
		// 2). Get student with matching address "201/78"
		List<Student> studentAddress = studentList.stream()
                .filter(Student -> Student.getAddress().toString().startsWith("201/78"))
                .collect(Collectors.toList());
		 System.out.println("Name:"+studentAddress);
		
	   // 3). Get all student having mobile numbers 8934.
		  List<Student> studentMobileNumber = studentList.stream()
                 .filter(Student -> Student.getMobileNumber().toString().startsWith("8934"))
                 .collect(Collectors.toList());
		 System.out.println("Mobile Number:"+studentMobileNumber);
	
		 // 4). Get all student having mobile number 9820 and 9940
		 List<Student>studentMobileNumberList = studentList.stream()
				  .filter(Student -> Student.getMobileNumber().toString().startsWith("9820")||
				  Student.getMobileNumber().toString().startsWith("9940"))
				  .collect(Collectors.toList());
		 System.out.println("Student Mobile Number:"+studentMobileNumberList);
		 
		 //6). Create a List<Student> from the List<TempStudent>
		 List<String>tempStudentList=studentList.stream()
		            .filter(temporary ->temporary.getRole().equals("Trainee"))
		            .map(temporary -> temporary.getName()) //fetching pages 
		            .collect(Collectors.toList()); //collecting as list 
		 System.out.println("Temporary Student List:"+tempStudentList);
		            
		//7). Convert List<Student> to List<String> of student name     
		 List<String> nameList=studentList.stream()
		              .map(Student::getName)
		              .collect(Collectors.toList());
		 System.out.println("Name List:"+nameList);
		            
		//8). Convert List<students> to String
		String studentString = studentList.stream()
		               .map(student -> "Name:"+student.getName()+
		            	", Address:"+student.getAddress()+
		            	", Mobile Number:"+student.getMobileNumber()+
		            	", Role:"+student.getRole())
                        .collect(Collectors.joining(", "));
		 System.out.println(studentString);

	    //9). Change the case of List<String>
		 List<String> studentsList = Arrays.asList("Reema", "Abinaya", "Ramya","Archana");
		 List<String> upperCaseList = studentsList.stream()
		              .map(String::toUpperCase)
		              .collect(Collectors.toList());
         System.out.println("Upper Case List:"+upperCaseList);
		 List<String> lowerCaseList = studentsList.stream()
		              .map(String::toLowerCase)
		              .collect(Collectors.toList());
		 System.out.println("Lower Case List:"+lowerCaseList);
		 
		 //10). Sort List<String>
		 List<String> studentsLists = Arrays.asList("Reema", "Abinaya", "Ramya","Archana");
		 List<String> sortedList = studentsLists.stream()
				     .sorted()
				     .collect(Collectors.toList());
		 System.out.println("Sorted List:"+sortedList);
		 	
	}
	
}
