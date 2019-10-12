package ws5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class StudentReader {
	
	public static ArrayList<Student> getStudentArrayList() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			FileInputStream fis = new FileInputStream("students.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o instanceof ArrayList<?>) {
				students = (ArrayList<Student>) o;
			}
		}	
		catch (ClassNotFoundException | IOException e) {
			System.out.println(e.toString());
		}
		
		return students;
		
	}

	public static String getStudents() {
		try {
			FileInputStream fis = new FileInputStream("students.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o instanceof ArrayList<?>) {
				String str = "";
				for (Object s : (ArrayList<?>) o) {
					str += s.toString() + "\n";
				}
				fis.close();
				return str;
			}
			else {
				fis.close();
				return "Incorrect data type in file.";
			}
		}
		catch (ClassNotFoundException | IOException e) {
			return e.toString();
		}
	}
}