package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			System.out.println("Creating 3 Student objects ...");
			Student studentOne = new Student("Fouchimi", "Ousmane", "ousmanefouchimi@gmail.com");
			Student studentTwo = new Student("Ramatou", "rama", "rama@yahoo.ca");
			Student studentThree = new Student("Leboss", "Legrand", "lebosslegrand@gmail.com");		
			// begin the transaction
			session.beginTransaction();
					
			//save the object in the session
			System.out.println("Saving the student ...");
			session.save(studentOne);
			session.save(studentTwo);
			session.save(studentThree);
					
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done ...");
					
		}finally {
			//close the session
			session.close();
			factory.close();
		}
	}

}
