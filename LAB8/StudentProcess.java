package ws8;

import java.util.Arrays;
import java.util.Optional;
import java.util.Comparator;
import java.util.List;

public class StudentProcess {

	private static Student[] students = {
			new Student("Jack", "Smith", 50.0, "IT"),
			new Student("Aaron", "Johnson", 76.0, "IT"),
			new Student("Maaria", "White", 35.8, "Business"),
			new Student("John", "White", 47.0, "Media"),
			new Student("Laney", "White", 62.0, "IT"),
			new Student("Jack", "Jones", 32.9, "Business"),
			new Student("Wesley", "Jones", 42.89, "Media")
	};
	
	public static void main(String[] args) {
		
		//make a list of students
		List<Student> studentList = Arrays.asList(students);
		
		//task 1
		System.out.println("Task 1: \n");
		System.out.println("Complete Student list:");
		
		studentList.forEach(System.out::println); //print each student
		
		//task 2
		System.out.println("\nTask 2: \n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		
		studentList.stream().filter(std -> std.getGrade() >= 50 && std.getGrade() <= 100).sorted(Comparator.comparing(Student::getGrade))//sorting ascendingly by grades
		.forEach(System.out::println);
		
		//task 3
		System.out.println("\nTask 3:\n");
		System.out.println("First Student who got 50.0-100.0:");
		
		Optional<Student> student = studentList.stream().filter(std -> std.getGrade() >= 50 && std.getGrade() <= 100).findFirst();
		System.out.println(student.get());
		
		//task 4
		System.out.println("\nTask 4:\n");
		System.out.println("Students in ascending order by last name then first:");
				
		studentList.stream().sorted(Comparator.comparing(Student::getFirstName)).sorted(Comparator.comparing(Student::getLastName))
		.forEach(System.out::println);
	
	    System.out.println("\nStudents in descending order by last name then first:");
	    studentList.stream().sorted(Comparator.comparing(Student::getFirstName).reversed()).sorted(Comparator.comparing(Student::getLastName).reversed())
		.forEach(System.out::println);		
		
	  //task 5
	  System.out.println("\nTask 5:\n");
	  System.out.println("Unique Student last names:");
	  
	  studentList.stream().sorted(Comparator.comparing(Student::getLastName)).map(Student::getLastName).distinct()
		.forEach(System.out::println);
		
	}
}
