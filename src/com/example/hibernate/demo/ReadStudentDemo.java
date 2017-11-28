package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	
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
			System.out.println("Creating tempStudent ...");
			Student tempStudent = new Student("Wallen", "Ball", "wallenball@gmail.com");
			
			// begin the transaction
			session.beginTransaction();
			
			//save the object in the session
			System.out.println("Saving the student ...");
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done ...");
			
			// My new Code
			// Find out the student id: Primary key
			System.out.println("Saved Student. Generated Id: " + tempStudent.getId());
			
			//Get a new session and start transaction
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve the student based on the student's id
			System.out.println("\nGetting student with the id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			//Commit transaction
			
			session.getTransaction().commit();
			
		}catch(Exception ex) {
			
		}finally {
			//close the session
			session.close();
			factory.close();
		}
	}
}
