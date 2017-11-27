package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	
	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		Session session = (Session) factory.getCurrentSession();
		
		try {
			
			//use the session to save the java object
			
			//create the student object
			System.out.println("Creating temp Student ...");
			Student theStudent = new Student("Fouchimi", "Ousmane", "ousmanefouchimi@gmail.com");
			
			// begin the transaction
			session.beginTransaction();
			
			//save the object in the session
			System.out.println("Saving the student ...");
			session.save(theStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
		}catch(Exception ex) {
			
		}finally {
			//close the session
			session.close();
		}
	}
}
