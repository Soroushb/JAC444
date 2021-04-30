package application;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

public class WriteStudent extends Student {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException  {


		File f = new File("output.bin");

		JFrame frame = new JFrame("Student:");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		try {

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Student student = (Student) ois.readObject();

			ois.close();

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Student object:"));

			JLabel IDLabel = new JLabel("ID: " + student.getStdID());
			panel.add(IDLabel);

			JLabel fNameLabel = new JLabel("First Name: " + student.getFirstName());
			panel.add(fNameLabel);

			JLabel lNameLabel = new JLabel("Last Name: " + student.getLastName());
			panel.add(lNameLabel);

			JLabel coursesLabel = new JLabel("Courses: " + student.getCourses());
			panel.add(coursesLabel);

			frame.add(panel);
			frame.validate();

		} catch (IOException err) {
			JPanel errorPanel = new JPanel();
			errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.Y_AXIS));

			errorPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Student object:"));

			JLabel error = new JLabel(err.getMessage());
			errorPanel.add(error);
			frame.setSize(500, 300);
			frame.add(errorPanel);
			frame.validate();
		}catch(ClassNotFoundException err) {
			JPanel errorPanel = new JPanel();
			errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.Y_AXIS));
			errorPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Student object:"));
			JLabel error = new JLabel(err.getMessage());
			errorPanel.add(error);
			frame.setSize(500, 300);
			frame.add(errorPanel);
			frame.validate();
		};

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}