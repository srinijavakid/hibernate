package client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class DNamedSQLQuery {
	public static void main(String[] args)
	{
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		
/* HQL Query_______________________ */
		
		
		Query qrys = session.getNamedQuery("HQLQuery");
		qrys.setParameter("param1",new Integer(5));
		
		List l =qrys.list();
		System.out.println("Total Number Of Records : "+l.size());	
		System.out.println("----------------------");
		Iterator it = l.iterator();
		
		while(it.hasNext())
		{
			Object o = (Object)it.next();
			Product p = (Product)o;
			System.out.println("Product id : "+p.getProductId());
			System.out.println("Product Name : "+p.getProName());
			System.out.println("Product Price : "+p.getPrice());
			System.out.println("-------SQL Query---------------");
		}	
		
		Query qry = session.getNamedQuery("SQLQuery");
		
		List li =qry.list();
		System.out.println("Total Number Of Records : "+li.size());	
		System.out.println("----------------------");
		Iterator ite = li.iterator();
		
		while(ite.hasNext())
		{
			Object o[] = (Object[])ite.next();
			
			System.out.println("Product id : "+o[0]+ " Product Name : "+o[1]);
			
			System.out.println("----------------");
		}		
	}		
}
