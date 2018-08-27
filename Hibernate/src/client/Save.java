package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class Save {

	public static void main(String[] args) {

		// Step 1
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		// Step 2
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Product p = new Product();

		p.setProductId(101);
		p.setProName("Dhoni");
		p.setPrice(5000);

		// Returns the key
		Transaction tx = session.beginTransaction();
		System.out.println("Object got saved");
		System.out.println("Saved Object ID:--->  " + session.save(p));
		tx.commit();

		Product p1 = new Product();

		// Dont have return type
		p1.setProductId(102);
		p1.setProName("Sachin");
		p1.setPrice(1200);

		Transaction txs = session.beginTransaction();
		session.persist(p1);
		System.out.println("Object got saved");
		System.out.println("Object saved successfully.....!!");
		txs.commit();

		session.close();
		factory.close();
	}

}
