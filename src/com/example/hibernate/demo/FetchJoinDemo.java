package com.example.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
        
        // create session factory
        SessionFactory factory = new Configuration()
        		.configure("hibernate.cfg.xml")
        		.addAnnotatedClass(Instructor.class)
        		.addAnnotatedClass(InstructorDetail.class)
        		.addAnnotatedClass(Course.class)
                .buildSessionFactory();
 
        // create a session
        Session session = factory.getCurrentSession();
 
        try {
      
            // start a transaction
            session.beginTransaction();
            
            // get the instructor from db
            int theId = 1;
            
            Query<Instructor> query = session.createQuery("select i from Instructor i "
            		+ "JOIN FETCH i.courses "
            		+ "where i.id=:theInstructorId", 
            		Instructor.class);
            
            // set parameter on query
            query.setParameter("theInstructorId", theId);
            
            Instructor tempInstructor = query.getSingleResult();
            
            System.out.println("tempInstructor: " + tempInstructor);
            
            // commit transaction
            session.getTransaction().commit();
           
            //Close the session
            session.close();
            
            System.out.println("\nThe session is now closed!");
            
            //Fetch instructor related courses
            System.out.println("luv2Code: Courses: " + tempInstructor.getCourses());
            
            System.out.println("Done!");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	//session.close();
            factory.close();
        }
    }
}
