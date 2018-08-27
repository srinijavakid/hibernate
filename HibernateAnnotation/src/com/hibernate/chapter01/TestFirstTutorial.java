package com.hibernate.chapter01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class TestFirstTutorial {
	public static void main(String[] args) {
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(Tutorial.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		
		SessionFactory factory=config.buildSessionFactory();
		Session mysession=factory.getCurrentSession();
		mysession.beginTransaction();
		
		
		Tutorial srini=new Tutorial();
		srini.setPageurl("HI");
		mysession.save(srini);
		mysession.getTransaction().commit();
		
}
}
