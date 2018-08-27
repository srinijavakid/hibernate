package com.hibernate.chapter02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class TestOneclasstwotable {
	public static void main(String[] args) {
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(Customer.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		
		SessionFactory factory=config.buildSessionFactory();
		Session mysession=factory.getCurrentSession();
		mysession.beginTransaction();
		
		{
		Customer srini=new Customer();
		srini.setCustomerName("Srini");
		srini.setCustomerAddress("Ambattur");
		srini.setCreditscore(2);
		srini.setRewardpoints(5622);
		mysession.save(srini);
		}
		{
		Customer vasu=new Customer();
		vasu.setCustomerName("Vasu");
		vasu.setCustomerAddress("Perambur");
		vasu.setCreditscore(234);
		vasu.setRewardpoints(547);
		mysession.save(vasu);
		}
	
		
		mysession.getTransaction().commit();
		
}
}
