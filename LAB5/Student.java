package lab5;
import java.util.ArrayList;

public class Student implements java.io.Serializable{

	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;

	public Student() {
		courses = new ArrayList<String>(); 
		stdID = 0;
		firstName = "";
		lastName = "";
	}

	public int getStdID() {
		return stdID;
	}

	public void setStdID(int stdID) throws Exception {
		if(stdID < 0) {
			throw new Exception("The ID is not valid");
		}else
			this.stdID = stdID;
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

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses.add(courses);
	}


	public Student(int stdID, String firstName, String lastName, ArrayList<String> courses) throws Exception {
		if(stdID > 0) {
			this.stdID = stdID;
		}else
			throw new Exception("The ID is not valid");

		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;
	}

}
