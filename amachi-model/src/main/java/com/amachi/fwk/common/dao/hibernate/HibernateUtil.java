package com.amachi.fwk.common.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
//	private static ServiceRegistry serviceRegistry;
	private static Session session;

	static {
		try {

//			Configuration configuration = new Configuration();
//			configuration.configure();
//			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(builder.build());

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @return the session
	 */
	public static Session getSession() {
//		if (!session.isOpen()) {
//			setSession(null);
//		}
		if (session == null) {
			session = getSessionFactory().openSession();
		}
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public static void setSession(Session session) {
		HibernateUtil.session = session;
	}

}
