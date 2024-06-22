package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mentor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String adress;
	
	private String skill;
	
	private int exp;
	
	@OneToMany(mappedBy = "mentor",cascade = CascadeType.ALL)
	private List<Student> students=new ArrayList<>();
	
	public void addStudent(Student student) {
		this.students.add(student);
		student.setMentor(this);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
		student.setMentor(null);
	}

	public Mentor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mentor(int id, String name, String adress, String skill, int exp, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.skill = skill;
		this.exp = exp;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", name=" + name + ", adress=" + adress + ", skill=" + skill + ", exp=" + exp
				+ ", students=" + students + "]";
	}

		

}
