package Main;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Repository.StudentRepository;
import config.AppConfig;
import entity.Course;
import entity.Hostel;
import entity.Mentor;
import entity.Student;
import repositoryimpl.StudentImplem;

public class Test {
	
	public static void main(String[] args) {
		
		//StudentRepository repository=new StudentImplem();
		//Student student=repository.get(2).get();
		/*Student student=new Student();
		student.setFirstName("bapathi");
		student.setLastName("tejaashwini");
		student.setEmail("Suri@gmail.com");
		repository.insert(student);*/
		//repository.update(1, student);
		//repository.delete(1);
		//repository.getAll().forEach(stunt->System.out.println(stunt.getFirstName()+""+stunt.getLastName()+""+stunt.getEmail()));
		///////////////////////////////////////////////////////////////
		//insertStudent();
		
		//insertMentor();
		
		//getStudent();
		
		//getMentor();
		
		//updateStudentAndHostel();
		

		insertCourses();




	}



	private static void insertCourses() {
		Session session= getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			Student st=session.get(Student.class, 1);
			Course c1=new Course();
			c1.setCourseName("java");
			c1.setDuration(30);
			Course c2=new Course();
			c2.setCourseName(".Net");
			c2.setDuration(50);
			st.addCourse(c1);
			st.addCourse(c2);
			session.save(st);

			
				tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}
		finally {
			
			session.close();
			
		}
	}



	private static void updateStudentAndHostel() {
		Session session= getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			Student st=session.get(Student.class, 1);
			Hostel hostel=new Hostel();
			hostel.setName("ASK Towers");
			hostel.setLocation("Navular");
			st.setHostel(hostel);
			session.save(st);

			
				tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}
		finally {
			
			session.close();
			
		}
	}



	private static void getMentor() {
		Session session= getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			Mentor mentor=session.get(Mentor.class, 1);
			System.out.println(mentor.getName());
			List<Student> students=mentor.getStudents();
			students.forEach(student->System.out.println(student.getFirstName()+"/t"+student.getLastName()+"/t"+student.getEmail()));
			//by default fetch type 
			//one to one ----Eager
			//many to many ----Lazy
			//one to many -----Lazy
			//one to one Eager
			
				tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}
		finally {
			
			session.close();
			
		}
	}



	private static void getStudent() {
		Session session= getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			Student st=session.get(Student.class, 1);
			System.out.println(st.getFirstName());
			
				tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}
		finally {
			
			session.close();
			
		}
	}



	private static void insertMentor() {
		Session session= getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			Mentor m1=new Mentor();
			m1.setName("nag");
			m1.setSkill(".Net");
			m1.setAdress("vsp");
			m1.setExp(10);
			Student st1=new Student();
			st1.setFirstName("raju");
			st1.setLastName("lenka");
			st1.setEmail("raju@gmail.com");
			Student st2=new Student();
			st1.setFirstName("kittu");
			st1.setLastName("krishna");
			st1.setEmail("kittu@gmail.com");
			m1.addStudent(st1);
			m1.addStudent(st2);
			
			//st1.setMentor(m1);
			//st2.setMentor(m1);
			//No need to save the mentor when you load the student automatically mentor will save
			//session.save(m1);
			session.save(m1);
			
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}
		finally {
			
			session.close();
			
		}
	}
		
	

	private static void insertStudent() {
		Session session= getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			Student st1=new Student();
			st1.setFirstName("Balu");
			st1.setLastName("pulli");
			st1.setEmail("balu@gmail.com");
			Student st2=new Student();
			st1.setFirstName("kittu");
			st1.setLastName("krishna");
			st1.setEmail("kittu@gmail.com");
			Mentor m1=new Mentor();
			m1.setName("ravi");
			m1.setSkill("java");
			m1.setAdress("chennai");
			m1.setExp(10);
			st1.setMentor(m1);
			st2.setMentor(m1);
			//No need to save the mentor when you load the student automatically mentor will save
			//session.save(m1);
			session.save(st1);
			session.save(st2);
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}
		finally {
			
			session.close();
			
		}
	}

	private static Session getSession() {
		SessionFactory factory=AppConfig.sessionFactory();
		Session session=factory.openSession();
		
		return session;
	}

}
