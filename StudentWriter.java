package ws5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentWriter {
	
	private static ArrayList<Student> students; 
	
	public static void initializeStudents(ArrayList<Student> students) {
		StudentWriter.students = students;
	}
	
	private static int getStudentAtId(int stdId) {
		int index = -1;
		for (int i = 0; i < students.size(); i++) {
			Integer x = students.get(i).getStdId();
			Integer y = stdId;
			if (x.equals(y)) {
				index = i;
			}
		}
		return index;
	}
	
	public static String writeStudents(String stdId, String firstName, String lastName, String courses) {

		ArrayList<String> courseList = new ArrayList<String>(Arrays.asList(courses.split(",")));
		String returnMsg = "";
		
		try {
			int studentId = Integer.parseInt(stdId);
			int index = getStudentAtId(studentId);
			
			if (index == -1) {
				Student student = new Student(studentId, firstName, lastName, courseList);
				students.add(student);
			}
			else {
				returnMsg = "Student with id:" + stdId + " already exists.";
			}
		}
		catch (NumberFormatException e) {
			returnMsg = "Invalid studentId: Must be a whole number with no decimals.";
		}
		catch (StudentException e) {
			returnMsg = e.toString();
		}
	
		try {
			FileOutputStream fos = new FileOutputStream("students.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(students);
			oos.flush();
			oos.close();
			if (returnMsg.equals("")) {
				returnMsg = "Student saved successfully.";
			}
			
		}
		catch (IOException e) {
			returnMsg = e.toString();
		}
		
		return returnMsg;
	}
	
	public static String deleteStudent(String stdId) {
		String returnMsg = "";
		try {
			int studentId = Integer.parseInt(stdId);
			int index = getStudentAtId(studentId);
			if (!(index == -1)) {
				students.remove(index);
				try {
					FileOutputStream fos = new FileOutputStream("students.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(students);
					oos.flush();
					oos.close();
					returnMsg = "Student deleted.";
				}
				catch (IOException e) {
					returnMsg = e.toString();
				}
			}
			else {
				returnMsg = "Student not found.";
			}

		}
		catch (NumberFormatException e) {
			returnMsg = "Invalid studentId: Must be a whole number with no decimals.";
		}
		return returnMsg;
	}
}
