package com.hibernate.chapter06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestOnetoOnemap {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetails.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session mysession = factory.getCurrentSession();
		mysession.beginTransaction();

		PersonDetails ob = new PersonDetails();
		ob.setDesigination("engineer");
		ob.setIncome(400);
		mysession.save(ob);
		

		Person obj = new Person();
		obj.setPername("srini");
		obj.setPerdet(ob);
		mysession.save(obj);

		PersonDetails ob1= new PersonDetails();
		ob1.setDesigination("doctor");
		ob1.setIncome(1000);
		mysession.save(ob1);

		Person obj1 = new Person();
		obj1.setPername("vasu");
		obj1.setPerdet(ob1);
		mysession.save(obj1);

		mysession.getTransaction().commit();
	}

}
