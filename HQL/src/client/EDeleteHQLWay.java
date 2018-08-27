package client;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class EDeleteHQLWay { 
 
    public static void main(String[] args)
    {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession(); 
        
        //To display before initial start ------------------
        Query qrys = session.createQuery("select p.productId,p.proName from Product p");
		
        System.out.println("INTIAL TABLE");		
		List l =qrys.list();
		Iterator it = l.iterator();
		
		while(it.hasNext())
		{
			Object o[] = (Object[])it.next();
			
			System.out.println("Product id : "+o[0]+ "    Product Name : "+o[1]);
			
			System.out.println("----------------");
		}			
		//To display before intial END ------------------
		
   		//Delete record start -----------------
            Query qry = session.createQuery
            ("delete from Product p where p.productId=:param1");
            qry.setParameter("param1",100);
            int res = qry.executeUpdate();
 
            System.out.println("Command successfully executed....");
            System.out.println("Numer of records effected due to delete query"+res);
         //Delete record END -----------------
            
            //To display after delete start ------------------
            Query qrys12 = session.createQuery("select p.productId,p.proName from Product p");
    		
    		
    		System.out.println("AFTER DELETE");
    		List l12 =qrys12.list();
    		Iterator it12 = l12.iterator();
    		
    		while(it12.hasNext())
    		{
    			Object o[] = (Object[])it12.next();
    			
    			System.out.println("Product id : "+o[0]+ "    Product Name : "+o[1]);
    			
    			System.out.println("----------------");
    		}			
    	//To display before delete END ------------------
        session.close();
        factory.close();
    }
 
}