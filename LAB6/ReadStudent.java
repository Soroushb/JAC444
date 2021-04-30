package application;

import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReadStudent extends Student {

	public static void main(String[] args) throws IOException, Exception {

		JFrame f = new JFrame("Saving Students in a file");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
		f.add(input);

		JLabel IDLabel = new JLabel("Student ID: ");
		JTextField ID = new JTextField(10);
		input.add(IDLabel);
		input.add(ID);

		JLabel firstNameLabel = new JLabel("First Name: ");
		JTextField firstNameTxt = new JTextField(15);
		input.add(firstNameLabel);
		input.add(firstNameTxt);

		JLabel lastNameLabel = new JLabel("Last Name: ");
		JTextField lastNameTxt = new JTextField(15);
		input.add(lastNameLabel);
		input.add(lastNameTxt);

		JLabel coursesLabel = new JLabel("Student Courses(CSV): ");
		JTextField courses = new JTextField(20);
		input.add(coursesLabel);
		input.add(courses);

		JButton submitButton = new JButton("Submit");
		input.add(submitButton);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Student student = new Student();

					try {
						int stdid = Integer.parseInt(ID.getText());
						student.setStdID(stdid);
					}catch(Exception err) {
						System.err.println("ID has to be an integer");
					}

					String firstName = firstNameTxt.getText();
					student.setFirstName(firstName);

					String lastName = lastNameTxt.getText();
					student.setLastName(lastName);

					String coursesInput = courses.getText();
					String[] temp = coursesInput.split(",");
					for (int i = 0; i < temp.length; i++) {
						student.setCourses(temp[i]);
					}

					File f = new File("output.bin");
					FileOutputStream fos = new FileOutputStream(f);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(student);

					oos.flush();
					fos.close();


				} catch(IOException err) {
					System.out.println(err);
				}
			}
		});

		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}}

