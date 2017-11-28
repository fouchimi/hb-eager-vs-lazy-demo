package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Employee;

public class MainEmployeeDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
						          .configure("hibernate.cfg.xml")
						          .addAnnotatedClass(Employee.class)
						          .buildSessionFactory();
				
		Session session = (Session) factory.getCurrentSession();
		
		try {
			// Create couple of employees
			Employee firstEmployee = new Employee("Sidick", "Aboubakar", "IUT");
			Employee secondEmployee = new Employee("Barack", "Ousseni", "CMR");
			Employee thirdEmployee = new Employee("Ousmane", "Fouchimi", "Charter Communications LLC");
			Employee fourthEmployee = new Employee("Olivia", "Hires", "Charter Communications LLC");
			
			// start transaction
			session.beginTransaction();
			
			session.save(firstEmployee);
			session.save(secondEmployee);
			session.save(thirdEmployee);
			session.save(fourthEmployee);
			
			// Commit transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			int empId = 1;
			Employee employee = session.get(Employee.class, empId);
			
			//Employee with empId
			System.out.println("\nEmployee with id: " + empId + " " + employee);
			
			List<Employee> employeeList = session.createQuery("from Employee where company='Charter Communications LLC'").list();
		
			for(Employee curEmployee : employeeList) {
				System.out.println(curEmployee);
			}
			
			session.getTransaction().commit();
			
			session  = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Employee emp = session.get(Employee.class, 3);
			
			//Deleting student with Id :  3
		
			session.delete(emp);
			
			System.out.println("Student deleted !");
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
