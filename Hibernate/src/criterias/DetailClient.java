package criterias;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import domain.Player;

public class DetailClient {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object[] intArr = { 1200, 8000 };

		Criteria criteria = session.createCriteria(Player.class);

		// criteria.add(Restrictions.ge("score",8000));
		// criteria.add(Restrictions.gt("score",8000));
		//        
		// criteria.add(Restrictions.le("score",1000));
		// criteria.add(Restrictions.lt("score",1250));
		//        
		// criteria.add(Restrictions.in("score",intArr));
		// criteria.add(Restrictions.not(Expression.in("score",intArr)));
		//        
		// criteria.add(Restrictions.eq("score",1200));
		// criteria.add(Restrictions.not(Expression.eq("score",1200)));
		//        
		// criteria.add(Restrictions.like("name","Ra%"));
		// criteria.add(Restrictions.not(Restrictions.like("name","%a%")));
		//    	
		// criteria.add(Restrictions.between("score",1,1000));
		//        
		// criteria.add(Restrictions.isNotNull("name"));
		// criteria.add(Restrictions.isNull("name"));
		//        
		// criteria.add(Restrictions.eqProperty("score","productId"));
		//        
		// Criterion c1=Restrictions.and(Restrictions.like("name","dhoni"),
		// Restrictions.gt("score", new Integer(1000)));
		// criteria.add(c1);
		//        
		// Criterion c1=Restrictions.or(Restrictions.like("name","dhoni"),
		// Restrictions.gt("score", new Integer(1000)));
		// criteria.add(c1);
		//        
		// criteria.addOrder(Order.asc("score"));
		// criteria.addOrder(Order.desc("score"));
		//        
		// criteria.setFirstResult(1);
		// criteria.setMaxResults(2);
		//        
		// criteria.setProjection( Projections.rowCount() );
		// criteria.setProjection( Projections.max("score") );
		// criteria.setProjection( Projections.avg("score") );//Double cannot
		// cast to int exception
		//          
		// criteria.setProjection(Projections.property("name"));
		//        
		// Projection p1 = Projections.property("name");
		// criteria.setProjection(p1);
		//        
		// ProjectionList p1=Projections.projectionList();
		// p1.add(Projections.property("name"));
		// p1.add(Projections.property("score"));
		// criteria.setProjection(p1);

		List l = criteria.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			// While selecting whole object..

			Player p = (Player) it.next();
			System.out.println(p.getPlayerId() + "----" + p.getName() + "----"
					+ p.getScore());

			// While selecting partial object..
			// Object ob[] = (Object[])it.next();
			// System.out.println(ob[0]+"--------"+ob[1]);

			// While selecting any particular row..
			// String s = (String)it.next();
			// System.out.println(s);

			// int i = (Integer)it.next();
			// System.out.println(i);
		}
		session.close();
		factory.close();

	}
}