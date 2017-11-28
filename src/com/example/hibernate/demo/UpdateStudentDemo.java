package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	
	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		Session session = (Session) factory.getCurrentSession();
		
		try {
			
			// begin the transaction
		    session.beginTransaction();
			
			int studentId = 1;
			//use the session to save the java object
			
			//create the student object
			System.out.println("Retrieve student based on its id" + studentId);
			Student theStudent = session.get(Student.class, studentId);
			
			//Get complete my student
			System.out.println("Get complete  : " + theStudent);
			
			System.out.println("Updating student ...");
			theStudent.setFirstName("Scooby");
			
			//commit the transaction
			session.getTransaction().commit();
			
			// New code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Update email for all students
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		}catch(Exception ex) {
			
		}finally {
			//close the session
			session.close();
			factory.close();
		}
	}
}
