package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    //@Column(name = "id")
	    private int id;

	   // @Column(name = "first_name")
	    private String firstName;

	    //@Column(name = "last_name")
	    private String lastName;

	    //@Column(name = "email")
	    private String email;
	    
	    
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="hotel_id",unique=true)
	    private Hostel hostel;
	    
	    @ManyToOne(cascade = CascadeType.PERSIST)
	    @JoinColumn(name="mentor_id")
	    private Mentor mentor;
	    
	    @ManyToMany(cascade = CascadeType.ALL )
	    @JoinTable(name="student_course",joinColumns=@JoinColumn (name="sid"),inverseJoinColumns =@JoinColumn(name="cid"))
	    private List<Course> courses=new ArrayList<>();
	    
	    public void addCourse(Course course) {
	    	this.courses.add(course);
	    	//course.registerStudent(this);
	    }
	    
	    public void removeCourse(Course course) {
	    	this.courses.remove(course);
	    	course.removeStudent(this);
	    }

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Student(int id, String firstName, String lastName, String email, Mentor mentor) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.mentor = mentor;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Mentor getMentor() {
			return mentor;
		}

		public void setMentor(Mentor mentor) {
			this.mentor = mentor;
		}
		

		public Hostel getHostel() {
			return hostel;
		}

		public void setHostel(Hostel hostel) {
			this.hostel = hostel;
		}
		
		

		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", mentor=" + mentor + "]";
		}
	    
	    

	    
		}
