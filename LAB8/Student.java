package ws8;
import java.text.DecimalFormat;

public class Student {

	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	
	
	public Student(String fName, String lName, double grade, String department){
		
		firstName = fName;
		lastName = lName;
		this.grade = grade;
		this.department = department;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public void setGrade(double grade) {
		if(grade > 0) {
		this.grade = grade;}
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return firstName + "\t" + lastName + "   \t" 
				+ new DecimalFormat("0.00").format(grade) + "\t"
				+ department;
	}
	
	
	
}
