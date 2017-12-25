package org.glassfish.jersey.archetypes.com_mayia.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.glassfish.jersey.archetypes.com_mayia.pojo.CampusMind;
import org.glassfish.jersey.archetypes.com_mayia.pojo.customexception.StoringException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class CampusMindDAOImpl implements CampusMindDAOInterface {

	static SessionFactory sessionFactory;
	static Session session;

	@Override
	public boolean add(int num) throws StoringException {

		try {
			for (int i = 0; i < num; i++) {
				CampusMind cmp = new CampusMind();
				cmp.setTrack("EAI");
				cmp.setUserName("Nikhil" + i);
				session.save(cmp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new StoringException("not valid");
		}
		return true;

	}

	@Override
	public List<CampusMind> read(int num) {
		Query qry = session.createQuery("FROM CampusMind");

		List<CampusMind> cmpMind = qry.list();
//		System.out.println("Total Number Of Records : " + l.size());
		return cmpMind;
		// Iterator it = l.iterator();
		// System.out.println("campus minds = "+l.get(0).getCampusMind());

		/*
		 * while (it.hasNext()) { CampusMind oor = (Orchard) it.next(); //
		 * CampusMind cmd = (CampusMind) oor.getCampusMind(); // Set<CampusMind>
		 * cmd = HashSet<CampusMind>(); Set<CampusMind> cmd = new
		 * HashSet<CampusMind>(); System.out.println("orchard set size = " +
		 * oor.getCampusMind()); System.out.println("team lead set size = " +
		 * oor.getTeamLead()); cmd = oor.getCampusMind(); for (CampusMind cmAns
		 * : cmd) { System.out.println("campus minds name = ");
		 * System.out.println(cmAns.getName()); } //
		 * System.out.println(cmd.getName());
		 * 
		 * 
		 * System.out.println("Product id : "+o[0]+ "Product Name : "+o[1]);
		 * 
		 * System.out.println("----------------");
		 * 
		 * }
		 */

	}

	@Override
	public boolean update(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean startConnection() {
		try {
			String hibernateFilePath = "hibernate.cfg.xml";

			sessionFactory = new Configuration().configure(hibernateFilePath).buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean closeConnection() {
		try {
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
