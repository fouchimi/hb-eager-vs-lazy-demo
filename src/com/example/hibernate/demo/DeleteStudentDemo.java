package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	
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
			
		    System.out.println("Delete student id 5");
			session.createQuery("DELETE FROM Student WHERE id=5 ").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done !!!");
			
			//commit the transaction
			session.getTransaction().commit();
			
		}catch(Exception ex) {
			
		}finally {
			//close the session
			session.close();
			factory.close();
		}
	}
}
