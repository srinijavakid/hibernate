package client;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import domain.Product;
 
public class SelectExample { 
 
    public static void main(String[] args)
    {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Object o=session.load(Product.class,new Integer(105));
        
        // For loading Transaction scope is not necessary...
        Criteria criteria = session.createCriteria(Product.class);
        List l=criteria.list();
        Iterator it=l.iterator();
        while(it.hasNext())
               {
        	Product p=(Product)it.next();
            System.out.println(p.getProductId()+"----"+p.getProName()+"----"+p.getPrice());
               }
        session.close();
        factory.close();
    }
}