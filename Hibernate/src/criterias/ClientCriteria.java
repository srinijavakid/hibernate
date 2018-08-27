package criterias;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import domain.Player;

public class ClientCriteria {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Criteria crit = session.createCriteria(Player.class);

		Criterion cn = Restrictions.gt("score", new Integer(4010));
		crit.add(cn);

		List l = crit.list();
		System.out.println("List total size..._" + l.size());
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Player p = (Player) it.next();
			System.out.println("Player ID:-  " + p.getPlayerId());
			System.out.println("Player Name:-  " + p.getName());
			System.out.println("Player Score:-  " + p.getScore());
			System.out.println("-----------------");
		}

		session.close();
		factory.close();
	}

}