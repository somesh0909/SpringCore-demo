package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String courseName;
	private int duration;
	
	@ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
	private List<Student> students=new ArrayList<>();
	
	//helper methods to add or delete student object jhbjhjbjh
	
	public void registerStudent(Student student) {
		this.students.add(student);
		//student.addCourse(this);
	
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
		student.removeCourse(this);
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	

}
