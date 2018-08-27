package com.hibernate.project;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(Login.class);
		config.addAnnotatedClass(User.class);
		config.configure("hibernate.cfg.xml");
		
	new SchemaExport(config).create(true, true);
		
	SessionFactory factory=config.buildSessionFactory();
	Session mysession=factory.getCurrentSession();
	
	mysession.beginTransaction();
	{
	Login srini=new Login();
	
	srini.setUsername("Srini");
	srini.setPassword("srini123");
	mysession.save(srini);
	}
	
	
	{
		Login manoj=new Login();
		
		manoj.setUsername("Manoj");
		manoj.setPassword("manoj123");
		mysession.save(manoj);
	}
	{
		User venkat=new User();

		venkat.setFname("venkat");
		venkat.setLname("subhu");
		venkat.setAge("22");
		mysession.save(venkat);
	}
	{
		User guru=new User();

		guru.setFname("guru");
		guru.setLname("sixface");
		guru.setAge("45");
		mysession.save(guru);
	
	}
	{
		User ranjith=new User();

		ranjith.setFname("ranjith");
		ranjith.setLname("kumar");
		ranjith.setAge("99");
		mysession.save(ranjith);
	}
	
	mysession.getTransaction().commit();
	}

}
