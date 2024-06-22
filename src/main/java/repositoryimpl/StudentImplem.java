package repositoryimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Repository.StudentRepository;
import config.AppConfig;
import entity.Student;

public class StudentImplem implements StudentRepository{

	@SuppressWarnings("deprecation")
	@Override
	public Student insert(Student student) {
		SessionFactory factory=AppConfig.sessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(student);
			
			tx.commit();
			
		}catch(Exception e2) {
			
			session.close();
		}
		return student;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory=AppConfig.sessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//session.save(student);
			Student student=session.get(Student.class, 1);
			session.delete(student);
			tx.commit();
			
		}catch(Exception e2) {
			
			//session.close();
			tx.rollback();
		}
		finally {
			
			session.close();
		}
	}

	@Override
	public void update(int id, Student student) {
		// TODO Auto-generated method stub
		SessionFactory factory=AppConfig.sessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//session.save(student);
			Student student1=session.get(Student.class, id);
			student1.setFirstName(student.getFirstName());
			student1.setLastName(student.getLastName());
			student.setEmail(student1.getEmail());
			tx.commit();
			
		}catch(Exception e2) {
			
			//session.close();
			tx.rollback();
		}
		finally {
			
			session.close();
		}
		
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		SessionFactory factory=AppConfig.sessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		List<Student> student=null;
		try {
			tx=session.beginTransaction();
			session.save(student);
			TypedQuery<Student> query=session.createQuery("select stnt from entity.Student stnt");
			student=query.getResultList();
			tx.commit();
			
		}catch(Exception e2) {
			
			session.close();
		}
		return student;
		
	}

	@Override
	public Optional<Student> get(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory=AppConfig.sessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		Student student=null;
		try {
			tx=session.beginTransaction();
			//session.save(student);
			 student=session.get(Student.class, id);
			
			tx.commit();
			 
		}catch(Exception e2) {
			
			//session.close();
			tx.rollback();
		}
		finally {
			
			session.close();
		}
		

		return Optional.of(student);
	}

}
