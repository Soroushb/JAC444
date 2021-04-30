package lab5;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Vector;
import java.io.FileNotFoundException;


public class writeStudent extends Student {

	public static void main(String[] args) throws ClassNotFoundException, IOException{

		try{
			FileInputStream fis = new FileInputStream("output.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Vector<Student> newStudents = (Vector<Student>) ois.readObject();

			fis.close();

			Iterator<Student> iter = newStudents.iterator();
			while(iter.hasNext()) {
				Student s = iter.next();
				System.out.println("Student ID: " + s.getStdID());
				System.out.println("First Name: " + s.getFirstName());
				System.out.println("Last Name: " + s.getLastName());
				System.out.println("Courses: " + s.getCourses() + '\n');
			}

		}catch(FileNotFoundException e) {
			System.err.println(e);
		}catch(IOException e) {
			System.err.println(e);
		}
	}
}
