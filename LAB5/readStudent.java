package lab5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.Vector;


public class readStudent extends Student {

	public static void main(String[] args) throws IOException, Exception {
		
		BufferedReader in = null;
		in = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("How many students? ");
		int num = Integer.parseInt(in.readLine());
		
		Student[] student = new Student[num];
		
		for(int i = 0; i < num; i++) {
			student[i] = new Student();
		}
		
		Vector<Student> v = new Vector<>();
		
		
		for(int j = 0; j < num; j++) {
		System.out.print("\nStudent ID: ");
		try {
		int studentID = Integer.parseInt(in.readLine());
		student[j].setStdID(studentID);
		} catch(NumberFormatException e) {
			System.err.println("ID has to be an integer");
		}
		
	    System.out.print("First Name: ");
	    String studentFirstName = in.readLine();
	    student[j].setFirstName(studentFirstName);
	    
	    System.out.print("Last Name: ");
	    String studentLastName = in.readLine();
	    student[j].setLastName(studentLastName);
	    
	    System.out.print("Courses(CSV): ");
	    String studentCourses = in.readLine();
	    String courseArr[] = studentCourses.split(",");
	    for(int i = 0; i < courseArr.length; i++) {
	    	student[j].setCourses(courseArr[i]);
	    }
	    v.add(student[j]);
		}
	    File file = new File("output.bin");
	    try {	
	    FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(v);
        oos.flush();
		fos.close();
		System.out.println("Done!");
	    } catch(FileNotFoundException e) {
	    	System.err.println(e);
	    } catch(IOException e) {
	    	System.err.println(e);
	    }
	}
}
