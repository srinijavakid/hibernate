package com.hibernate.chapter03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.chapter02.Customer;

public class TestTwoclassonetable {

	
	public static void main(String[] args) {
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(School.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		
		SessionFactory factory=config.buildSessionFactory();
		Session mysession=factory.getCurrentSession();
		mysession.beginTransaction();
		
		Schooldetail srm=new Schooldetail();
		srm.setIspublicschool(true);
		srm.setSchooladdress("Ambattur");
		srm.setStudentcount(98);
		
		School myschool=new School();
		myschool.setSchoolname("Sirramasamy");
		myschool.setSchooldetails(srm);
		
		
		mysession.save(myschool);
		mysession.getTransaction().commit();
		
}
}
