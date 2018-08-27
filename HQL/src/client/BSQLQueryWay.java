package client;

import org.hibernate.*;
import org.hibernate.cfg.*;

import domain.Product;

import java.util.*;

public class BSQLQueryWay { 

	public static void main(String[] args)
	{
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		
/* Selecting all objects(records) start_______________________ */
		
	
		
		Query qry = session.createQuery("from Product p");
		
		List l =qry.list();
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
			System.out.println("----------------------");
		}		
		
		
		SQLQuery sqlQrys = session.createSQLQuery("select count(*) from TEST.PRODUCTS");
		// Hear PRODUCTS is the table in the database...
		System.out.println(sqlQrys.uniqueResult());
		
		
		SQLQuery sqlQry = session.createSQLQuery("select * from TEST.PRODUCTs").addEntity(Product.class);
		// Hear PRODUCTS is the table in the database...
		List ls = sqlQry.list();
		Iterator ite = ls.iterator();
		
		System.out.println("------------------SQL QUERY WITH ENTITY--------------------");
		while(ite.hasNext())
		{
			Object o = (Object)ite.next();
			Product p = (Product)o;
			System.out.println("Product id : "+p.getProductId());
			System.out.println("Product Name : "+p.getProName());
			System.out.println("Product Price : "+p.getPrice());
			System.out.println("----------------------");
		}	
		
		session.close();
		factory.close();
	}
	
}
