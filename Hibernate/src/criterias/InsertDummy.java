package criterias;

import java.util.ArrayList;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Player;

public class InsertDummy {

	public static void main(String[] args) {

		// Step 1
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		// Step 2
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		for (int i = 0; i < 100; i++) {

			Player p = new Player();

			p.setName(getRandomName());
			p.setScore(new Random().nextInt(5000));

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

		names.add("Ganguly");
		names.add("Sachein");
		names.add("Dhoni");
		names.add("Yuvi");
		names.add("Virat");
		names.add("Karthick");
		names.add("Bajji");
		names.add("Zaheer");
		names.add("Dravid");
		names.add("Luxman");
		names.add("Raina");

		int index = new Random().nextInt(names.size());
		String anynames = names.get(index);

		return anynames;

	}

}
