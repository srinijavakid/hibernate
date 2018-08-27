package client;

import org.hibernate.*;
import org.hibernate.cfg.*;

import domain.Product;

public class Retrieve {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.get(Product.class, new Integer(101));
		Product s = (Product) o;

		// For loading Transaction scope is not necessary...
		System.out.println("Product Name:-    " + s.getProName());

		// Object o1 = session.get(Product.class, new Integer(100));
		// Object o2 = session.load(Product.class, new Integer(100));
		//		
		// System.out.println("Get Object"+ o1);
		// System.out.println("Load Object"+ o2);

		session.close();
		factory.close();
	}

}
