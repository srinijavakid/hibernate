package client;
 
import org.hibernate.*;
import org.hibernate.cfg.*;

import domain.Product;

import java.util.*;
 
public class CParameterHQL { 
 
    public static void main(String[] args)
    {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
 
//Using label...............
 
        Query qry = session.createQuery("from Product p where p.productId= :param1");
        qry.setParameter("param1",55);
 
        List l =qry.list();
        System.out.println("Total Number Of Records : "+l.size());
        Iterator it = l.iterator();
 
        while(it.hasNext())
        {
            Object o = (Object) it.next();
            Product p = (Product)o;
            System.out.println("Product Name : "+p.getProName());
            System.out.println("Product Price : "+p.getPrice());
            System.out.println("---------------------------");
 
        }       
 
      
 
/* Using Question Mark  */
 /*
        Query qry = session.createQuery("from Product p where p.productId= ?");
            qry.setParameter(0,103);
 
            List l =qry.list();
            System.out.println("Total Number Of Records : "+l.size());
            Iterator it = l.iterator();
 
            while(it.hasNext())
            {
                Object o = (Object) it.next();
                Product p = (Product)o;
                System.out.println("Product Name : "+p.getProName());
                System.out.println("Product Price : "+p.getPrice());
                System.out.println("---------------------------");
 
            }       
 
 //To call Stored Procedures
  
        Query q = session.createSQLQuery(" { call changesalary(?,?) }");
        q.setInteger(0,100);  // first parameter, index starts with 0
        q.setInteger(1,4000); // secon parameter
        q.executeUpdate();
        */
        session.close();
        factory.close();
    }

}