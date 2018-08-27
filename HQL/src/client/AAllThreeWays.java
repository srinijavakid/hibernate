package client;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class AAllThreeWays { 

	public static void main(String[] args)
	{
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		
/* Selecting all objects(records) start_______________________ */
		
	
		
//		Query qry = session.createQuery("from Product p");
//		
//		List l =qry.list();
//		System.out.println("Total Number Of Records : "+l.size());		
//		Iterator it = l.iterator();
//		
//		while(it.hasNext())
//		{
//			Object o = (Object)it.next();
//			Product p = (Product)o;
//			System.out.println("Product id : "+p.getProductId());
//			System.out.println("Product Name : "+p.getProName());
//			System.out.println("Product Price : "+p.getPrice());
//			System.out.println("----------------------");
//		}		
		
	
		
		
/* Selecting all objects(records) end________________________ */		
		
		
	
/* Selecting partial objects(More than one object) start__________ */		
		
	
		
	
//		Query qry = session.createQuery("select p.productId,p.proName from Product p");
//		
//		List l =qry.list();
//		System.out.println("Total Number Of Records : "+l.size());		
//		Iterator it = l.iterator();
//		
//		while(it.hasNext())
//		{
//			Object o[] = (Object[])it.next();
//			
//			System.out.println("Product id : "+o[0]+ " Product Name : "+o[1]);
//			
//			System.out.println("----------------");
//		}			
		
		
		
		
/* Selecting partial objects(More than one object)end_____________ */				
		
		
/* Selecting single object start_____________ */
		
     Query qry = session.createQuery("select p.productId from Product p");
		
		List l =qry.list();
		System.out.println("Total Number Of Records : "+l.size());		
		Iterator it = l.iterator();
		
		while(it.hasNext())
		{
			Integer i = (Integer)it.next();			
			System.out.println("Product id : "+i.intValue());
			System.out.println("---------------------------");
			
		}		

/* selecting single object end____________ */
		
		
		
		
		session.close();
		factory.close();
	}
	
}
