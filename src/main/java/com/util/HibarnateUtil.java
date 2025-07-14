package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibarnateUtil {

	private static SessionFactory factory;
	static {
		try {
			Configuration cfg = new Configuration().configure("/com/config/Hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static SessionFactory getSessionFactory() {
		return factory;

	}
}
