package com.hibernate.employee;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {

	public static void main(String[] args){
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Employee.class);
		config.configure("hibernate.cfg.xml");
		
		//new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		// Transient Object
		Employee samuel = new Employee();
		Employee daniel = new Employee();
		{
	//		employee.setId(1);
			samuel.setName("Samuel");
			samuel.setEmpJoinDate(new GregorianCalendar(2013, 03, 07));
			samuel.setEmpLoginTime(Date.valueOf("2010-06-05"));
		}
		
		{
					daniel.setName("Daniel");
					daniel.setEmpJoinDate(new GregorianCalendar(2013, 03, 05));
					daniel.setEmpLoginTime(Date.valueOf("2008-06-05"));
				}
		
		// Save the object in current session		
		session.save(samuel);
		session.save(daniel);
		
		// Save the object in database
		session.getTransaction().commit();
//		session.close();
		
		
		
		
	}
}

