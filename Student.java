package ws5;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	
	// Fields
	private static final long serialVersionUID = 1L;
	private int stdId;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;
	
	// Constructors
	// Student may have zero courses.
	public Student(int stdId, String firstName, String lastName, ArrayList<String> courses) throws StudentException {
		if (stdId >= 0 && !firstName.equals("") && !lastName.equals("")) {
			this.stdId = stdId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.courses = new ArrayList<String>(courses);
		}
		else {
			throw new StudentException("Invalid student!");
		}
	}
	
	// Queries
	public int getStdId() {
		return stdId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public ArrayList<String> getCourses() {
		return courses;
	}
	
	public String toString() {
		return "Student: {stdId=" + getStdId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", courses=" + getCourses() + "}";
	}
	
	// Modifiers
	public void setStdId(int stdId) throws StudentException {
		if (stdId >= 0) {
			this.stdId = stdId;
		}
		else {
			throw new StudentException("Invalid student id!");
		}
	}
	
	public void setFirstName(String firstName) throws StudentException {
		if (!firstName.equals("")) {
			this.firstName = firstName;
		}
		else {
			throw new StudentException("Invalid first name!");
		}
	}
	
	public void setLastName(String lastName) throws StudentException {
		if (!lastName.equals("")) {
			this.lastName = lastName;
		}
		else {
			throw new StudentException("Invalid last name!");
		}
	}
	
	// Student may have zero courses.
	public void setCourses(ArrayList<String> courses) throws StudentException {
		this.courses = new ArrayList<String>(courses);	
	}
	
}
