package com.hibernate.chapter08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.chapter08.Delegate;
import com.hibernate.chapter08.Event;


public class TestManytoManymap {

	public static void main(String[] args) {

		

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Delegate.class);
		config.addAnnotatedClass(Event.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session mysession = factory.getCurrentSession();
		mysession.beginTransaction();
		
		Delegate obj=new Delegate();
		obj.setDelname("delsri");
		Delegate obj1=new Delegate();
		obj1.setDelname("delvasu");
		Delegate obj2=new Delegate();
		obj2.setDelname("delela");
		Delegate obj3=new Delegate();
		obj3.setDelname("delese");
		Delegate obj4=new Delegate();
		obj4.setDelname("deleloka");
		
		
		Event ob=new Event();
		ob.setEvnet("evesri");
		Event ob1=new Event();
		ob1.setEvnet("evevas");
		Event ob2=new Event();
		ob2.setEvnet("eveela");
		
		ob.getDelegates().add(obj);
		ob1.getDelegates().add(obj1);
		ob2.getDelegates().add(obj2);
		ob1.getDelegates().add(obj3);
		ob2.getDelegates().add(obj4);
		
		
		mysession.save(obj);
		mysession.save(obj1);
		mysession.save(obj2);
		mysession.save(obj3);
		mysession.save(obj4);
		mysession.save(ob);
		mysession.save(ob1);
		mysession.save(ob2);
		mysession.getTransaction().commit();		
	}

}
