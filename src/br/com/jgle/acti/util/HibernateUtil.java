package br.com.jgle.acti.util;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new AnnotationConfiguration();
			configuration.configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Metodo utilitario para executar querys SQL
	 * 
	 * @param query
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Collection executeQuery(String query) {

		Session session = getSession();

		SQLQuery sqlQuery = session.createSQLQuery(query);

		List list = sqlQuery.list();

		return list;
	}

	@SuppressWarnings("rawtypes")
	public static Collection executeQuery(String query, Class clazz) {

		Session session = getSession();

		SQLQuery sqlQuery = session.createSQLQuery(query);

		sqlQuery.addEntity(clazz);

		List list = sqlQuery.list();

		return list;
	}

	/**
	 * Metodo utilitario para executar querys SQL
	 * 
	 * @param query
	 * @return
	 */
	public static Integer executeUpdateQuery(String query) {

		Session session = getSession();

		SQLQuery sqlQuery = session.createSQLQuery(query);

		int numberOfRows = sqlQuery.executeUpdate();

		return numberOfRows;
	}

	/**
	 * Metodo utilitario para executar querys SQL
	 * 
	 * @param query
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Collection executeHQL(String hql) {

		Session session = getSession();

		Query query = session.createQuery(hql);

		List list = query.list();

		return list;
	}

	/**
	 * Recuperar a Session. Se ja existe uma na ThreadLocal entao ela eh
	 * utilizada, senao eh criada uma nova com o beginTransaction()
	 * 
	 * @return
	 */
	public static Session getSession() {
		try {
			if (sessionThreadLocal.get() == null) {
				sessionThreadLocal.set(sessionFactory.openSession());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return (Session) sessionThreadLocal.get();
	}

	/**
	 * Recuperar a Session. Se ja existe uma na ThreadLocal entao ela eh
	 * utilizada, senao eh criada uma nova com o beginTransaction()
	 * 
	 * @return
	 */
	public static void closeSession() {
		try {
			if (sessionThreadLocal.get() != null) {
				Session session = (Session) sessionThreadLocal.get();
				if (session != null && session.isOpen()) {
					try {
						session.close();
					} catch (Exception e) {
					}
				}
				sessionThreadLocal.remove();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}