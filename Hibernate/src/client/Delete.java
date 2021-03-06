package client;

import org.hibernate.*;
import org.hibernate.cfg.*;

import domain.Product;

public class Delete {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object obj = session.get(Product.class, new Integer(101));
		Product before = (Product) obj;
		System.out.println("Product Before Delete:-    "
				+ before.getPrice());

		
		Object o = session.load(Product.class, new Integer(101));
		Product s = (Product) o;
		Transaction tx = session.beginTransaction();
	
		session.delete(s);
		tx.commit();

		Object ob = session.get(Product.class, new Integer(101));
		Product after = (Product) ob;
		System.out.println("Product After Delete:-    "
				+ after.getPrice());

		// Object o1 = session.get(Product.class, new Integer(100));
		// Object o2 = session.load(Product.class, new Integer(100));
		//		
		// System.out.println("Get Object"+ o1);
		// System.out.println("Load Object"+ o2);

		session.close();
		factory.close();
	}

}
