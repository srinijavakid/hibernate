package com.hibernate.chapter04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCompoundKey {

	public static void main(String[] args) {
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(Account.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		
		SessionFactory factory=config.buildSessionFactory();
		Session mysession=factory.getCurrentSession();
		mysession.beginTransaction();
		
		CompoundKey ck=new CompoundKey(100,1001);
		Account acc=new Account();
		acc.setAccbalance(56);
		acc.setComkey(ck);
		
		
		mysession.save(acc);
		mysession.getTransaction().commit();
		
}

}
