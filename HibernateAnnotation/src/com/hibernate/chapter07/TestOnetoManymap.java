package com.hibernate.chapter07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestOnetoManymap {

	public static void main(String[] args) {

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(College.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session mysession = factory.getCurrentSession();
		mysession.beginTransaction();
		
		
		College col=new College();
		col.setColname("veltech");
		mysession.save(col);
		
		Student stu=new Student();
		stu.setStuname("srini");
		stu.setCollege(col);
		mysession.save(stu);
		
		
		mysession.getTransaction().commit();
	}

}
