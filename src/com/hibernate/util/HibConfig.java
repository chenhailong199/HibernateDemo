package com.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibConfig {
	private static Configuration config;
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction tran;
	static {
		try {
			config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
		} catch (HibernateException e) {
			throw new RuntimeException("hibernate初始化失败", e);
		}
	}	
	public static Session getSession(){
		return session ;
	}	
	
	public static void commit(){
		try {
			tran.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tran != null){
				tran.rollback();
			}
		}
	}
}
