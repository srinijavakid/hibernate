package recepies;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class Generators {

	public static void main(String[] args) {

		// Step 1
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		// Step 2
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Product p = new Product();

		p.setProName("Dhoni");
		p.setPrice(5000);

		// Returns the key
		Transaction tx = session.beginTransaction();
		System.out.println("Object got saved");
		System.out.println("Saved Object ID:--->  " + session.save(p));
		tx.commit();

		session.close();
		factory.close();
	}

}
