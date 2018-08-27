package com.hibernate.chapter05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestInheritence {

	public static void main(String[] args) {

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session mysession = factory.getCurrentSession();
		mysession.beginTransaction();

		Project obj1 = new Project();
		obj1.setProjectname("catering");
		mysession.save(obj1);

		Project obj2 = new Project();
		obj2.setProjectname("stealing");
		mysession.save(obj2);

		Module obj3 = new Module();
		obj3.setProjectname("srider");
		obj3.setModulename("srilanka");
		mysession.save(obj3);
		
		Module obj4 = new Module();
		obj4.setProjectname("pakdan");
		obj4.setModulename("pakdan");
		mysession.save(obj4);
		
		Task obj5=new Task();
		obj5.setProjectname("boomboom");
		obj5.setModulename("dandan");
		obj5.setTaskname("pak");
		mysession.save(obj5);
		
		Task obj6=new Task();
		obj6.setProjectname("dool");
		obj6.setModulename("jiok");
		obj6.setTaskname("pak");
		mysession.save(obj6);

		mysession.getTransaction().commit();

	}

}
