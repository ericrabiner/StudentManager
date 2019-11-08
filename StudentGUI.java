package ws5;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentGUI extends JFrame {

	private final JTextArea studentInfo;
	private final JButton submitButton;
	private final JButton loadButton;
	private final JTextField studentIdTextField;
	private final JTextField firstNameTextField;
	private final JTextField lastNameTextField;
	private final JTextField coursesTextField;
	private final JTextField deleteTextField;
	private final JButton deleteButton;
	private JLabel label;

	private StudentGUI() {
		super("Student Program Manager");
		setLayout(null);

		// Labels
		label = new JLabel("Add Student");
		label.setFont(new Font("Courier New", Font.BOLD, 36));
		label.setBounds(10, 0, 250, 50);
		add(label);
		String[] myLabels = {"Student Id", "First Name", "Last Name", "Course"};
		for (int i = 0; i < myLabels.length; i++) {
			label = new JLabel(myLabels[i]);
			label.setFont(new Font("Courier New", Font.PLAIN, 18));
			label.setBounds(10, 40 + (i * 30), 200, 25);
			add(label);
		}
		
		// Text Fields
		studentIdTextField = new JTextField();
		studentIdTextField.setBounds(140, 45, 300, 25);
		add(studentIdTextField);
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(140, 75, 300, 25);
		add(firstNameTextField);
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(140, 105, 300, 25);
		add(lastNameTextField);
		coursesTextField = new JTextField();
		coursesTextField.setBounds(140, 135, 300, 25);
		add(coursesTextField);

		// Submit Button
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Courier New", Font.PLAIN, 16));
		submitButton.setBounds(240, 167, 100, 25);
		submitButton.addActionListener(new ActionListener() {   
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(StudentGUI.this, 
						StudentWriter.writeStudents(
								studentIdTextField.getText(), firstNameTextField.getText(),
								lastNameTextField.getText(), coursesTextField.getText())
						);
			} 
		}); 
		add(submitButton);

		// Student Text Area
		label = new JLabel("Load Students");
		label.setFont(new Font("Courier New", Font.BOLD, 36));
		label.setBounds(10, 200, 300, 50);
		add(label);
		Box box = Box.createHorizontalBox();
		studentInfo = new JTextArea();
		studentInfo.setEditable(false); 
		box.setBounds(10, 250, 480, 115);
		box.add(new JScrollPane(studentInfo));
		add(box);

		// Load Button
		loadButton = new JButton("Load Students");
		loadButton.setFont(new Font("Courier New", Font.PLAIN, 16));
		loadButton.setBounds(167, 375, 170, 25);
		loadButton.addActionListener(new ActionListener() {   
			@Override
			public void actionPerformed(ActionEvent event) {
				studentInfo.setText(StudentReader.getStudents());
			} 
		}); 
		add(loadButton);
		
		// Delete Student
		label = new JLabel("Delete Student");
		label.setFont(new Font("Courier New", Font.BOLD, 36));
		label.setBounds(10, 410, 400, 50);
		add(label);
		label = new JLabel("Student Id");
		label.setFont(new Font("Courier New", Font.PLAIN, 18));
		label.setBounds(10, 450, 200, 25);
		add(label);
		deleteTextField = new JTextField();
		deleteTextField.setBounds(140, 450, 300, 25);
		add(deleteTextField);
		deleteButton = new JButton("Delete Student");
		deleteButton.setFont(new Font("Courier New", Font.PLAIN, 16));
		deleteButton.setBounds(167, 485, 180, 25);
		deleteButton.addActionListener(new ActionListener() {   
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(StudentGUI.this, 
						StudentWriter.deleteStudent(deleteTextField.getText())
				);
			} 
		});
		add(deleteButton);
		
	}

	public static void main(String[] args) {
		
		StudentWriter.initializeStudents(StudentReader.getStudentArrayList());
		
		StudentGUI myFrame = new StudentGUI(); 
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(525, 575); 
		myFrame.setVisible(true);
	}
}