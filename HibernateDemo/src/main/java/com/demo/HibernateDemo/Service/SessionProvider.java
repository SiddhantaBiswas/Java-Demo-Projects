package com.demo.HibernateDemo.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.HibernateDemo.POJO.Course;
import com.demo.HibernateDemo.POJO.Student;

public class SessionProvider {

	private static SessionFactory sf;

	public Session getSession() {
		Configuration config = new Configuration().configure()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class);
		sf = config.buildSessionFactory();

		Session session = sf.getCurrentSession();
		return session;
	}
	
	public SessionFactory getSessionFactory() {
		Configuration config = new Configuration().configure()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class);
		sf = config.buildSessionFactory();

		return sf;
	}

	public void closeSession() {
		sf.close();
	}

}
