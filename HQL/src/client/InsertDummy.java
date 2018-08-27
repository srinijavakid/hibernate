package client;

import java.util.ArrayList;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;


public class InsertDummy {

	public static void main(String[] args) {

		// Step 1
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		// Step 2
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		for (int i = 0; i < 100; i++) {

			Product p = new Product();

			p.setProName(getRandomName());
			p.setPrice(new Random().nextInt(10000));

			// Returns the key
			Transaction tx = session.beginTransaction();
			System.out.println("Object got saved");
			System.out.println("Saved Object ID:--->  " + session.save(p));
			tx.commit();
		}
		session.close();
		factory.close();
	}

	public static String getRandomName() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Santro");
		names.add("XUV");
		names.add("ZEN");
		names.add("Alto");
		names.add("Swift");
		names.add("Figo");
		names.add("Fortuner");
		names.add("Vento");
		names.add("Audi");
		names.add("Jaquar");
		names.add("Sunny");

		int index = new Random().nextInt(names.size());
		String anynames = names.get(index);

		return anynames;

	}

}
