package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	
	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		Session session = (Session) factory.getCurrentSession();
		
		try {
			
			//Start transaction
			session.beginTransaction();
			
			//Query students list
			List<Student> studentList = session.createQuery("from Student").list();
			
			//Iterate through studentList
			for(Student student : studentList) { 
				System.out.println(student);
			}                                                                        
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}catch(Exception ex) {
			
		}finally {
			//close the session
			session.close();
			factory.close();
		}
	}
}
