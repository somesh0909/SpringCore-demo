package config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import entity.Course;
import entity.Hostel;
import entity.Mentor;
import entity.Student;

public class AppConfig {

	public static SessionFactory  sessionFactory(){
		
		Configuration configuration=new Configuration();
		
		Properties properties=new Properties();
		//Data Source properties
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/surendra");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "Suri123@");
		
		//Hibernate properties
		
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.FORMAT_SQL, "true");
		properties.put("hibernate.connection.autocommit", true);
		
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Mentor.class);
		configuration.addAnnotatedClass(Hostel.class);
		configuration.addAnnotatedClass(Course.class);
		
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		
		return sessionFactory;
	}
}
